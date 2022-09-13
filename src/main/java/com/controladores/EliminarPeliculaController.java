package com.controladores;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter out = response.getWriter();
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(idPelicula);
		DAOFactory.getFactory().getPeliculaDAO().delete(pelicula);
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Está seguro que quiere eliminar la película ?');");
		out.println("location='ListarPeliculasController';");
		out.println("</script>");
		System.out.println("Ingresa eliminar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
