package entities;

import java.util.List;
import javax.persistence.*;
import negocio.Comanda;
import negocio.Mozo;

@Entity
@Table(name="mozos")
public class MozoEntity {
	
	@Id
	@Column(name="codMozo")
	private Integer dni;
	private String nombre;
	private String apellido;
	private Float porcentajeComision;
	
	public MozoEntity(){}
	
	public MozoEntity(Integer dni, String nombre, String apellido, Float procentajeComision) {
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
	
	public Float getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(Float porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}


	public Mozo toNegocio() 
	{
		Mozo m=new Mozo();
		m.setDni(dni);
		m.setNombre(nombre);
		m.setApellido(apellido);
		m.setProcentajeComision(porcentajeComision);
		return m;
	}


		

}
