package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Producto {

	private @Id @GeneratedValue Long id;
	private String nombre;
	private String precio;
	private String descripcion;

	private Producto() {}

	public Producto(String nombre, String precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		
	}

	

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Producto producto = (Producto) o;
		return Objects.equals(id, producto.id) &&
			Objects.equals(nombre, producto.nombre) &&
			Objects.equals(precio, producto.precio) &&
			Objects.equals(descripcion, producto.descripcion);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, nombre, precio, descripcion);
	}


	@Override
	public String toString() {
		return "Producto{" +
			"id=" + id +
			", nombre='" + nombre + '\'' +
			", precio='" + precio + '\'' +
			", descripcion='" + descripcion + '\'' +
			'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}