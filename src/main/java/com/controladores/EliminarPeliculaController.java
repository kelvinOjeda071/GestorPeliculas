package com.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Pelicula;
import com.entidades.dao.DAOFactory;

/**
 * Servlet implementation class EliminarPeliculaController
 */
@WebServlet("/EliminarPeliculaController")
public class EliminarPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarPeliculaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(idPelicula);
		DAOFactory.getFactory().getPeliculaDAO().delete(pelicula);
		request.getRequestDispatcher("/ListarPeliculasController").forward(request, response);
		System.out.println("Ingresa eliminar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
