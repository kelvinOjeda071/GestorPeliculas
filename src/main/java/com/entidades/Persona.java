package com.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.entidades.dao.DAOFactory;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "password")
	private String password;
	@Column(name = "correo")
	private String correo;
	@Column(name = "tipo")
	private String tipo;


	public Persona( String nombre, String password, String correo, String tipo) {
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

	@Override
	public int hashCode() {
		return Objects.hash(correo, id, nombre, password, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(correo, other.correo) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(tipo, other.tipo);
	}
	

}
