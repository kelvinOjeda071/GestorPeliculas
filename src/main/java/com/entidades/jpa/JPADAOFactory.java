package com.entidades.jpa;


import com.entidades.dao.DAOFactory;
import com.entidades.dao.PeliculaDAO;
import com.entidades.dao.PersonaDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public PeliculaDAO getPeliculaDAO() {
		return new JPAPeliculaDAO();
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

	
	
}
