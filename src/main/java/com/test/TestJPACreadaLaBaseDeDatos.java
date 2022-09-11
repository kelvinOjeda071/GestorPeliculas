package com.test;

import com.entidades.Pelicula;
import com.entidades.dao.DAOFactory;

public class TestJPACreadaLaBaseDeDatos {

	public static void main(String[] args) {
		Pelicula p = DAOFactory.getFactory().getPeliculaDAO().getById(1);
		System.out.println(p);
		DAOFactory.getFactory().getPeliculaDAO().delete(p);
	}

}
