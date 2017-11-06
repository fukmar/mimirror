package entities;

import java.util.List;
import javax.persistence.*;
import negocio.Comanda;

@Entity
@Table(name="Mozos")
public class MozoEntity {
	
	@Id
	@Column(name="codMozo")
	private Integer dni;
	private String nombre, apellido;
	private Float procentajeComision;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codSector", nullable = false)
	private SectorEntity sector;
	
	public MozoEntity(){}
	
	public MozoEntity(Integer dni, String nombre, String apellido, Float procentajeComision) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.procentajeComision = procentajeComision;
		
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
		return procentajeComision;
	}

	public void setProcentajeComision(Float procentajeComision) {
		this.procentajeComision = procentajeComision;
	}


		

}
