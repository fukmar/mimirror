package entities;

import java.util.List;


import javax.persistence.*;
@Entity
@Table(name="sectores")

public class SectorEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codSector")
	private Integer codSector;
	private String descripcion;
	
	
	public SectorEntity(){}

	public SectorEntity(String descripcion) {
		super();
		
		this.descripcion = descripcion;
		//this.mozo = mozo;
		//this.mesa = mesas;
	}

	public Integer getCodSector() {
		return codSector;
	}

	public void setCodSector(Integer codSector) {
		this.codSector = codSector;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	

}
