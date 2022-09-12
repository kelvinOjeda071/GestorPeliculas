package com.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Pelicula;
import com.entidades.dao.DAOFactory;

@WebServlet("/ActualizarPeliculaController")
public class ActualizarPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActualizarPeliculaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(idPelicula);
		request.setAttribute("pelicula", pelicula);
		request.getRequestDispatcher("/jsp/actualizarPelicula.jsp").forward(request, response);
		System.out.println("Actualizar pelicula");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPelicula = Integer.parseInt(request.getParameter("id"));
		String nombrePelicula = request.getParameter("nombre");
		int calificacion = Integer.parseInt(request.getParameter("calificacion"));
		int anio = Integer.parseInt(request.getParameter("anio"));
		String genero = request.getParameter("genero");
		String estado = request.getParameter("estado");

		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(idPelicula);
		pelicula.setId(idPelicula);
		pelicula.setNombre(nombrePelicula);
		pelicula.setCalificacion(calificacion);
		pelicula.setAnioPublicacion(anio);
		pelicula.setGenero(genero);
		switch (estado) {
		case "Disponible": {
			pelicula.setAlquilador(null);
			break;
		}
		}
		pelicula.setEstado(estado);
		DAOFactory.getFactory().getPeliculaDAO().update(pelicula);
		request.getRequestDispatcher("/ListarPeliculasController").forward(request, response);
		System.out.println("llega al post");
	}

}
