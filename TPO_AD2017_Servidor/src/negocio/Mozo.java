package negocio;

import java.util.List;

import dto.MozoDTO;
import entities.MozoEntity;
import entities.SectorEntity;

public class Mozo {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private Float porcentajeComision;
	
	public Mozo(){}
	
	public Mozo(Integer dni, String nombre, String apellido, Float procentajeComision)
	{
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



	public MozoEntity toEntity() 
	{
		MozoEntity m=new MozoEntity();
		m.setDni(dni);
		m.setNombre(nombre);
		m.setApellido(apellido);
		m.setPorcentajeComision(porcentajeComision);
		return m;
	}

	public MozoDTO toDTO() 
	{
		MozoDTO m=new MozoDTO();
		m.setDni(dni);
		m.setNombre(nombre);
		m.setApellido(apellido);
		m.setProcentajeComision(porcentajeComision);
		return m;
	}

	

}
