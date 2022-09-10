package com.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "anioPublicacion")
	private int anioPublicacion;
	@Column(name = "calificacion")
	private int calificacion;
	@Column(name = "genero")
	private String genero;
	@Column(name = "estado")
	private String estado;	
	@Column(name = "pathImage")
	private String pathImage;
	
	public Pelicula() {
		super();
	}
	public Pelicula(int id, String nombre, int anioPublicacion, int calificacion, String genero, String estado,
			String pathImage) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anioPublicacion = anioPublicacion;
		this.calificacion = calificacion;
		this.genero = genero;
		this.estado = estado;
		this.pathImage = pathImage;
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
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", anioPublicacion=" + anioPublicacion + ", calificacion="
				+ calificacion + ", genero=" + genero + ", estado=" + estado + ", pathImage=" + pathImage + "]";
	}
	
	
	
	

}
