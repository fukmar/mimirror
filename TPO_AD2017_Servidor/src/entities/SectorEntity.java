package entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

import negocio.Mesa;
import negocio.Sector;
@Entity
@Table(name="sectores")

public class SectorEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codSector")
	private Integer codSector;
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="codSalon",nullable=false)
	private SalonEntity salon;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="sector", cascade = CascadeType.ALL)
	private List<MesaEntity> mesas ;
	
	
	public SectorEntity(){}


	public SectorEntity(String descripcion, SalonEntity salon, List<MesaEntity> mesas) {
		super();
		this.descripcion = descripcion;
		this.salon = salon;
		this.mesas = mesas;
	}
	public SectorEntity(String descripcion, SalonEntity salon) {
		super();
		this.descripcion = descripcion;
		this.salon = salon;
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
	

	public List<MesaEntity> getMesas() {
		return mesas;
	}


	public void setMesas(List<MesaEntity> mesas) {
		this.mesas = mesas;
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
