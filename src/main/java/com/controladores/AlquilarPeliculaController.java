package com.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

@WebServlet("/AlquilarPeliculaController")
public class AlquilarPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlquilarPeliculaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Persona personaIngresada = (Persona) request.getSession().getAttribute("usuarioLogeado");
		// Se obtienen los parametros
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		// Se comunica con el modelo
		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(idPelicula);
		pelicula.setEstado("No Disponible");
		DAOFactory.getFactory().getPeliculaDAO().update(pelicula);
		DAOFactory.getFactory().getPeliculaDAO().setAlquilador(idPelicula, personaIngresada);
		// Se envia a la vista
		response.sendRedirect("ListarPeliculasController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
