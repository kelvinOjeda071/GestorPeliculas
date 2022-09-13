package com.controladores;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter out = response.getWriter();
		Persona personaAutorizada = null;
		// Obtener los parámetros
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipo");

		// Me comunico con el Modelo
		personaAutorizada = DAOFactory.getFactory().getPersonaDAO().autorinzarPersona(correo, password, tipo);
		System.out.println(correo);
		System.out.println(password);
		System.out.println(tipo);
		// Redirecciono a la Vista
		if (personaAutorizada != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", personaAutorizada);
			System.out.println("Ingreso");

			request.getRequestDispatcher("/ListarPeliculasController").forward(request, response);

		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('El usuario o la contraseña ya no son válidas');");
			out.println("location='jsp/login.jsp';");
			out.println("</script>");

			System.out.println("No pudo ingresar");
		}

	}

}
