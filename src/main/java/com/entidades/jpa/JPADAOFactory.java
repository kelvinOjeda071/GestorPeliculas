package com.entidades.jpa;


import com.entidades.dao.DAOFactory;
import com.entidades.dao.PeliculaDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public PeliculaDAO getPeliculaDAO() {
		return new JPAPeliculaDAO();
	}

	
	
}
