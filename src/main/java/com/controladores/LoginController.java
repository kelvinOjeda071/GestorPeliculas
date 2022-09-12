package com.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("jsp/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Persona personaAutorizada = null;
		// 1.- Obtener los parámetros
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipo");

		// 2.- Me comunico con el Modelo
		personaAutorizada = DAOFactory.getFactory().getPersonaDAO().autorinzarPersona(correo, password, tipo);

		// 3.- Redirecciono a la Vista
		if (personaAutorizada != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", personaAutorizada);
			System.out.println("Ingreso");

			request.getRequestDispatcher("/ListarPeliculasController").forward(request, response);

		} else {
			response.sendRedirect("jsp/login.jsp");
			System.out.println("No pudo ingresar");
		}

	}

}
