package com.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	@JoinColumn(name = "alquilador")
	@ManyToOne
	private Persona alquilador;

	public Pelicula() {
		super();
	}

	public Pelicula( String nombre, int anioPublicacion, int calificacion, String genero, String estado,
			String pathImage, Persona alquilador) {
		super();
		this.nombre = nombre;
		this.anioPublicacion = anioPublicacion;
		this.calificacion = calificacion;
		this.genero = genero;
		this.estado = estado;
		this.pathImage = pathImage;
		this.alquilador = alquilador;
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

	public Persona getAlquilador() {
		return alquilador;
	}

	public void setAlquilador(Persona alquilador) {
		this.alquilador = alquilador;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", anioPublicacion=" + anioPublicacion + ", calificacion="
				+ calificacion + ", genero=" + genero + ", estado=" + estado + ", pathImage=" + pathImage
				+ ", alquilador=" + alquilador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(alquilador, anioPublicacion, calificacion, estado, genero, id, nombre, pathImage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(alquilador, other.alquilador) && anioPublicacion == other.anioPublicacion
				&& calificacion == other.calificacion && Objects.equals(estado, other.estado)
				&& Objects.equals(genero, other.genero) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pathImage, other.pathImage);
	}
	
	

}
