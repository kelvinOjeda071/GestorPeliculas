package com.entidades.dao;

import java.util.List;

import com.entidades.Pelicula;
import com.entidades.Persona;

public interface PeliculaDAO extends GenericDAO<Pelicula, Integer>{
	public List<Pelicula> getPeliculasPorAlquilador(Persona p);
	public List<Pelicula> getPeliculasDisponibles();
	public void setAlquilador(Integer idPelicula, Persona p);
	
}
