package com.entidades.comparadores;

import java.util.Comparator;

import com.entidades.Pelicula;

public class comparadorPorCalificacion implements Comparator<Pelicula>{
	@Override
    public int compare(Pelicula o1, Pelicula o2) {
	 return (o1.getCalificacion() - o2.getCalificacion());
 }
}
