package com.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Pelicula;
import com.entidades.dao.DAOFactory;

@WebServlet("/DevolverPeliculaController")
public class DevolverPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DevolverPeliculaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(idPelicula);
		pelicula.setEstado("Disponible");
		pelicula.setAlquilador(null);
		DAOFactory.getFactory().getPeliculaDAO().update(pelicula);
		response.sendRedirect("ListarPeliculasAlquiladas");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
