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

@WebServlet("/BuscarPeliculaPorGeneroController")
public class BuscarPeliculaPorGeneroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarPeliculaPorGeneroController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/listarPeliculaPorGenero.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se obtienen los parametros
		String genero = request.getParameter("genero");
		// Se comunica con el modelo
		List<Pelicula> peliculasPorGenero = DAOFactory.getFactory().getPeliculaDAO().getPeliculasPorGenero(genero);
		// Se envia a la vista
		request.setAttribute("peliculasPorGenero", peliculasPorGenero);
		doGet(request, response);
		
	}

}
