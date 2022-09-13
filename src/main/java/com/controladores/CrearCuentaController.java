package com.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

@WebServlet("/CrearCuentaController")
public class CrearCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearCuentaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("jsp/crearCuenta.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Persona personaCreada = null;
		String correo = request.getParameter("correo");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipo");

		personaCreada = DAOFactory.getFactory().getPersonaDAO().comprobarCreacionDeUsuario(correo, tipo);

		if (personaCreada == null) {
			personaCreada = new Persona(nombre, password, correo, tipo);
			DAOFactory.getFactory().getPersonaDAO().create(personaCreada);
			response.sendRedirect("jsp/login.jsp");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('El usuario ya existe');");
			out.println("location='jsp/crearCuenta.jsp';");
			out.println("</script>");
		}

	}

}
