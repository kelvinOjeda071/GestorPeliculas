package com.test;

import com.entidades.Pelicula;
import com.entidades.dao.DAOFactory;

public class TestJPA {
	public static void main(String[] args) {
		String nombre1 = "Tiburon Martillo";
		int anio = 1940;
		int calificacion = 4;
		String genero = "CIencia Ficcion";
		String estado = "Disponible";
		String pathImagen = "";
		Pelicula p = new Pelicula(1, nombre1, anio, calificacion, genero, estado, pathImagen);
		DAOFactory.getFactory().getPeliculaDAO().create(p);
	}
}
