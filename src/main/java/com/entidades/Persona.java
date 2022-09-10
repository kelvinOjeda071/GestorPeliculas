package com.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.entidades.dao.DAOFactory;

@Entity
public class Persona {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "password")
	private String password;
	@Column(name = "correo")
	private String correo;
	@Column(name = "tipo")
	private String tipo;


	public Persona(int id, String nombre, String password, String correo, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
		this.tipo = tipo;
	}

	public Persona() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Pelicula> getPeliculas() {
		return DAOFactory.getFactory().getPeliculaDAO().getPeliculasPorAlquilador(this);
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", password=" + password + ", correo=" + correo + ", tipo="
				+ tipo +  "]";
	}

}
