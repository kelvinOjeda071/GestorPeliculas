package com.entidades.jpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.DAOFactory;
import com.entidades.dao.PersonaDAO;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO {

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@Override
	public Persona autorinzarPersona(String correo, String password, String tipo) {

		String sentenciaJPQL = "SELECT p FROM Persona p WHERE p.correo = :p1 AND p.password = :p2 AND p.tipo = :p3";
		Query query = em.createQuery(sentenciaJPQL);
		query.setParameter("p1", correo);
		query.setParameter("p2", password);
		query.setParameter("p3", tipo);
		try {
			Persona personaConsultada = (Persona) query.getSingleResult();
			return personaConsultada;
		} catch (NoResultException e) {
			return null;
		}

	}

}
