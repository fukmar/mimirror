package dto;

import java.io.Serializable;


public class MozoDTO implements Serializable
{
	private static final long serialVersionUID = 1999050924715622562L;
	private Integer dni;
	private String nombre, apellido;
	private Float porcentajeComision;
	
	public MozoDTO(){}
	
	public MozoDTO(Integer dni, String nombre, String apellido, Float procentajeComision) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.porcentajeComision = procentajeComision;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Float getProcentajeComision() {
		return porcentajeComision;
	}

	public void setProcentajeComision(Float procentajeComision) {
		this.porcentajeComision = procentajeComision;
	}

	

	@Override
	public String toString() {
		return "MozoDTO [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", procentajeComision="
				+ porcentajeComision + "]";
	}

	
	
}
