package entities;

import java.util.List;


import javax.persistence.*;

import negocio.Sector;
@Entity
@Table(name="sectores")

public class SectorEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codSector")
	private Integer codSector;
	private String descripcion;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codSalon")
	private SalonEntity salon;
	
	
	public SectorEntity(){}

	public SectorEntity(String descripcion,SalonEntity salon) {
		super();
		
		this.descripcion = descripcion;
		this.salon=salon;
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

	public SalonEntity getSalon() {
		return salon;
	}

	public void setSalon(SalonEntity salon) {
		this.salon = salon;
	}

	public Sector toNegocio() 
	{
		Sector s=new Sector();
		s.setCodSector(codSector);
		s.setDescripcion(descripcion);
		s.setSalon(salon.toNegocio());
		return s;
	}

	
	

}
