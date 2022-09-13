package com.controladores;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Pelicula;
import com.entidades.comparadores.ComparadorPorAnio;
import com.entidades.comparadores.ComparadorPorIdPelicula;
import com.entidades.comparadores.ComparadorPorNombre;
import com.entidades.comparadores.comparadorPorCalificacion;
import com.entidades.dao.DAOFactory;

@WebServlet("/OrdenarListaPeliculaController")
public class OrdenarListaPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrdenarListaPeliculaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ordernarPor = request.getParameter("ordenar");
		List<Pelicula> peliculasPorOrden = DAOFactory.getFactory().getPeliculaDAO().getPeliculasDisponibles();
		switch (ordernarPor) {
		case "id": {
			Collections.sort(peliculasPorOrden, new ComparadorPorIdPelicula());
			break;
		}
		case "nombre": {
			Collections.sort(peliculasPorOrden, new ComparadorPorNombre());
			break;
		}
		case "anio": {
			Collections.sort(peliculasPorOrden, new ComparadorPorAnio());
			break;
		}
		case "calificacion": {
			Collections.sort(peliculasPorOrden, new comparadorPorCalificacion());
			break;
		}
		}
		request.setAttribute("peliculasPorOrden", peliculasPorOrden);
		request.getRequestDispatcher("/jsp/listarPeliculasPorOrden.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
