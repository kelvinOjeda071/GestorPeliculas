package com.test;

import java.util.List;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

public class TestJPA {
	public static void main(String[] args) {
		String name = "Kelvin";
		String password = "123";
		String correo = "kelvin.ojeda@epn.edu.ec";
		String tipo = "Administrador";
		Persona persona1 = new Persona(name, password, correo, tipo);
		DAOFactory.getFactory().getPersonaDAO().create(persona1);
		String nombre1 = "Tiburon Martillo";
		int anio = 1940;
		int calificacion = 4;
		String genero = "Ciencia Ficcion";
		String estado = "Disponible";
		String pathImagen = "";
//		List <Pelicula> peliculas = new ArrayList<>();
		Pelicula p = new Pelicula( nombre1, anio, calificacion, genero, estado, pathImagen, persona1);
//		peliculas.add(p);
//		persona.setPeliculas(peliculas);
//		DAOFactory.getFactory().getPersonaDAO().update(persona);
		DAOFactory.getFactory().getPeliculaDAO().create(p);
		List<Pelicula> peliculas1 = DAOFactory.getFactory().getPeliculaDAO().getPeliculasPorAlquilador(persona1);
		for (Pelicula pelicula : peliculas1) {
			System.out.println(pelicula);
		}
		System.out.println("Persona 1 con peliculas "+ persona1);
	}
}
