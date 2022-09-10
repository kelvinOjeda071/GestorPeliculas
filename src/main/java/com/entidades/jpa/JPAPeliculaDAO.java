package com.entidades.jpa;

import com.entidades.Pelicula;
import com.entidades.dao.PeliculaDAO;

public class JPAPeliculaDAO extends JPAGenericDAO<Pelicula, Integer> implements PeliculaDAO{

	public JPAPeliculaDAO() {
		super(Pelicula.class);
	}

}
