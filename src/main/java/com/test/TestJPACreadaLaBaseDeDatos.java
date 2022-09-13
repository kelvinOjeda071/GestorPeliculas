package com.test;

import java.util.List;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

public class TestJPACreadaLaBaseDeDatos {

	public static void main(String[] args) {
		// Comprobar funcionamiento getById
		Pelicula p = DAOFactory.getFactory().getPeliculaDAO().getById(1);
		System.out.println(p);
		// Comprobar el funcionamiento de Delete
		DAOFactory.getFactory().getPeliculaDAO().delete(p);
		// Comprobar funcionamiento de devolver peliculas disponibles
		List<Pelicula> peliculas = DAOFactory.getFactory().getPeliculaDAO().getPeliculasDisponibles();
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}
		// Incorporar un nuevo alquilador dentro de una pelicula
		Persona persona = DAOFactory.getFactory().getPersonaDAO().getById(1);
		System.out.println(persona);
		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(1);
		System.out.println(pelicula);
		DAOFactory.getFactory().getPeliculaDAO().update(pelicula);
		DAOFactory.getFactory().getPeliculaDAO().setAlquilador(pelicula.getId(), persona);
		// Comprobar funcionamiento de devolver peliculas por género
		List<Pelicula> peliculasPorGenero = DAOFactory.getFactory().getPeliculaDAO()
				.getPeliculasPorGenero("Documental");
		for (Pelicula peli : peliculasPorGenero) {
			System.out.println(peli);
		}
	}

}
