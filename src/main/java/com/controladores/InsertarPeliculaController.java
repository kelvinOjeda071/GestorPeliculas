package com.controladores;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.entidades.Pelicula;
import com.entidades.dao.DAOFactory;

@WebServlet("/InsertarPeliculaController")
public class InsertarPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int maxMemSize = 1024 * 1000;
	private int maxFileSize = 1024 * 5000;
	private String filePath;

	public void init() {
		filePath = getServletContext().getRealPath("/") + getServletContext().getInitParameter("file-upload");
	}

	public InsertarPeliculaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/insertarPelicula.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		java.io.PrintWriter out = response.getWriter();

		if (!isMultipart) {
			out.println("Error: el formato de envio no es multipart");
			return;
		}

		Pelicula pelicula = new Pelicula();

		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(maxMemSize);
		factory.setRepository(new File("c:\\temp"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);

		try {
			List fileItems = upload.parseRequest(new ServletRequestContext(request));
			Iterator i = fileItems.iterator();

			int archivoActual = 1;
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					if (fi.getSize() == 0) { // Si no inserto un archivo
						archivoActual++;
						continue;
					}
					String fileName = fi.getName();
					File file = new File(filePath + fileName);
					System.out.println("filePath "+ filePath);
					System.out.println("file name "+ fileName);
					System.out.println(file.getPath());
					fi.write(file);

					switch (archivoActual) {
					case 1:
						pelicula.setPathImage(fileName);
						break;
					}

				} else {
					String nombreCampo = fi.getFieldName();
					String valorCampo = fi.getString();
					switch (nombreCampo) {
					case "nombre":
						pelicula.setNombre(valorCampo);
						break;
					case "calificacion":
						pelicula.setCalificacion(Integer.parseInt(valorCampo));
						break;
					case "anio":
						pelicula.setAnioPublicacion(Integer.parseInt(valorCampo));
						break;
					case "genero":
						pelicula.setGenero(valorCampo);
						break;
					case "estado":
						pelicula.setEstado(valorCampo);
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		DAOFactory.getFactory().getPeliculaDAO().create(pelicula);
		response.sendRedirect("ListarPeliculasController");

	}

}
