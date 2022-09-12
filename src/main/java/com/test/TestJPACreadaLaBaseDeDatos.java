package com.test;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

public class TestJPACreadaLaBaseDeDatos {

	public static void main(String[] args) {
//		Pelicula p = DAOFactory.getFactory().getPeliculaDAO().getById(1);
//		System.out.println(p);
//		DAOFactory.getFactory().getPeliculaDAO().delete(p);
//		List <Pelicula> peliculas = DAOFactory.getFactory().getPeliculaDAO().getPeliculasDisponibles();
//		for (Pelicula pelicula : peliculas) {
//			System.out.println(pelicula);
//		}
		Persona persona = DAOFactory.getFactory().getPersonaDAO().getById(1);
		System.out.println(persona);
		Pelicula pelicula = DAOFactory.getFactory().getPeliculaDAO().getById(1);
		System.out.println(pelicula);
//		pelicula.setAlquilador(persona);
//		DAOFactory.getFactory().getPeliculaDAO().update(pelicula);
		DAOFactory.getFactory().getPeliculaDAO().setAlquilador(pelicula.getId(), persona);
	}

}
