package com.entidades.jpa;

import java.util.List;

import javax.persistence.Query;

import com.entidades.Pelicula;
import com.entidades.Persona;
import com.entidades.dao.PeliculaDAO;


public class JPAPeliculaDAO extends JPAGenericDAO<Pelicula, Integer> implements PeliculaDAO{

	public JPAPeliculaDAO() {
		super(Pelicula.class);
	}

	@Override
	public List<Pelicula> getPeliculasPorAlquilador(Persona persona) {
		String sentenciaJPQL = "SELECT p FROM Pelicula p WHERE p.alquilador = :p1";
		Query query = em.createQuery(sentenciaJPQL);
		query.setParameter("p1", persona);
		return (List<Pelicula>) query.getResultList();
	}

	@Override
	public List<Pelicula> getPeliculasDisponibles() {
		String sentenciaJPQL = "SELECT p FROM Pelicula p WHERE p.estado = :p1";
		Query query = em.createQuery(sentenciaJPQL);
		query.setParameter("p1", "Disponible");
		return (List<Pelicula>) query.getResultList();
	}

	@Override
	public void setAlquilador(Integer idPelicula, Persona p) {
		em.getTransaction().begin();
		String sentenciaJPQL = "UPDATE Pelicula p SET p.alquilador = :p1 WHERE p.id = :p2";
		Query query = em.createQuery(sentenciaJPQL);
		query.setParameter("p1", p);
		query.setParameter("p2", idPelicula);
		 int updateCount = query.executeUpdate();
		 System.out.println("Lineas modificadas "+ updateCount);
		em.getTransaction().commit();
		
	}

}
