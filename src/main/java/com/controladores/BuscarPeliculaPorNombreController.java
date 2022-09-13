package com.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Pelicula;
import com.entidades.dao.DAOFactory;

@WebServlet("/BuscarPeliculaPorNombreController")
public class BuscarPeliculaPorNombreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarPeliculaPorNombreController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/listarPeliculaPorNombre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se obtienen los parametros
		String nombre = request.getParameter("nombre");
		// Se comunica con el modelo
		List<Pelicula> peliculasPorNombre = DAOFactory.getFactory().getPeliculaDAO().getPeliculasPorNombre(nombre);
		// Se envia a la vista
		request.setAttribute("peliculasPorNombre", peliculasPorNombre);
		doGet(request, response);
		
	}

}
