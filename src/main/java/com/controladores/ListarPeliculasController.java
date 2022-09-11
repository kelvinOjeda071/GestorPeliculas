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

@WebServlet("/ListarPeliculasController")
public class ListarPeliculasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarPeliculasController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		obtenerListaPeliculas(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		obtenerListaPeliculas(request, response);
	}
	
	private void obtenerListaPeliculas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pelicula> peliculas = DAOFactory.getFactory().getPeliculaDAO().getAll();
		request.setAttribute("peliculas", peliculas);
		request.getRequestDispatcher("/jsp/listarPeliculas.jsp").forward(request, response);
	}

}
