package com.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

@WebServlet("/ListarPeliculasAlquiladas")
public class ListarPeliculasAlquiladas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarPeliculasAlquiladas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona personaIngresada = (Persona) request.getSession().getAttribute("usuarioLogeado");
		List<Pelicula> peliculasAlquiladas = DAOFactory.getFactory().getPeliculaDAO().getPeliculasPorAlquilador(personaIngresada);
		request.setAttribute("peliculasAlquiladas", peliculasAlquiladas);
		request.getRequestDispatcher("/jsp/listarPeliculasAlquiladas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
