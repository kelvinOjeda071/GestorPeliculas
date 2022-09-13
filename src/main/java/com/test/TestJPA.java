package com.test;

import java.util.List;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.DAOFactory;

public class TestJPA {
	public static void main(String[] args) {
		// Usuarios
		String name1 = "Kelvin";
		String password1 = "123";
		String correo1 = "kelvin.ojeda@epn.edu.ec";
		String tipo1 = "Administrador";
		Persona persona1 = new Persona(name1, password1, correo1, tipo1);
		DAOFactory.getFactory().getPersonaDAO().create(persona1);
		
		String name2 = "Kelvin";
		String password2 = "123";
		String correo2 = "k@h.c";
		String tipo2 = "Usuario";
		Persona persona2 = new Persona(name2, password2, correo2, tipo2);
		DAOFactory.getFactory().getPersonaDAO().create(persona2);
		// Peliculas
		String nombrePelicula1 = "Tiburon Martillo";
		int anio1 = 1940;
		int calificacion1 = 4;
		String genero = "Ciencia Ficcion";
		String estado = "Disponible";
		String pathImagen = "4996970.jpg-c_310_420_x-f_jpg-q_x-xxyxx.jpg";
		Pelicula p = new Pelicula( nombrePelicula1, anio1, calificacion1, genero, estado, pathImagen, null);
		DAOFactory.getFactory().getPeliculaDAO().create(p);
		DAOFactory.getFactory().getPeliculaDAO().create(new Pelicula("hey1", 1889, 3, "Documental", estado, "personal-assistant_6deae601_900x1291.jpg", null));
		DAOFactory.getFactory().getPeliculaDAO().create(new Pelicula("hey2", 1998, 4, "Drama", estado, "Love and Monsters 1.jpg", null));
		DAOFactory.getFactory().getPeliculaDAO().create(new Pelicula("Avatar", 2001, 5, "Accion", estado, "0633235c56059330e42f73ac706fb553.jpg", null));
		DAOFactory.getFactory().getPeliculaDAO().create(new Pelicula("Aventura", 1999, 5, "Documental", estado, "099b1a64d6f0d9badc744c93cb8143c1.jpg", null));
		DAOFactory.getFactory().getPeliculaDAO().create(new Pelicula("Star War", 2012, 2, "Accion", estado, "movie-poster-star-wars-star-wars-the-rise-of-skywalker-2019-year-movies-hd-wallpaper-preview.jpg", null));
		
		
		
		// Probar método para obtener peliculas por alquilador
		List<Pelicula> peliculas1 = DAOFactory.getFactory().getPeliculaDAO().getPeliculasPorAlquilador(persona1);
		for (Pelicula pelicula : peliculas1) {
			System.out.println(pelicula);
		}
		
	}
}
