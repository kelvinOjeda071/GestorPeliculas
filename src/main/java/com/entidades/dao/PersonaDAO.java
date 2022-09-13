package com.entidades.dao;

import java.util.List;

import com.entidades.Pelicula;
import com.entidades.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer>{
	
	public abstract Persona autorinzarPersona (String correo, String password, String tipo);
	public abstract Persona comprobarCreacionDeUsuario(String correo, String tipo);
}
