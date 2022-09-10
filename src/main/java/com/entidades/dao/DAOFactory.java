package com.entidades.dao;

import com.entidades.jpa.JPADAOFactory;

public abstract class DAOFactory {
	private static DAOFactory factory = new JPADAOFactory();
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract PeliculaDAO getPeliculaDAO();
	
}
