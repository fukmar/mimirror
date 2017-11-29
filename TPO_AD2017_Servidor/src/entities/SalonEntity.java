package entities;

import java.util.ArrayList;
import java.util.List;

import negocio.Salon;
import negocio.Sector;

import javax.persistence.*;

import dto.SectorDTO;
import enumns.AreaRest;
@Entity
@Table(name="salones")
public class SalonEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codSalon")
	protected Integer codSalon;
	private String nombreSalon;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codLocal")
	protected LocalEntity local;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="salon", cascade = CascadeType.ALL)
	private List<SectorEntity> sectores;
	
	public SalonEntity(){}

	public SalonEntity(String nombreSalon, LocalEntity local, List<SectorEntity> sectores) {
		super();
		this.nombreSalon = nombreSalon;
		this.local = local;
		this.sectores = sectores;
	}

	public SalonEntity(String nombreSalon, LocalEntity local) {
		super();
		this.nombreSalon = nombreSalon;
		this.local = local;
	}
	
	public SalonEntity(Integer codSalon, String nombreSalon, LocalEntity local, List<SectorEntity> sectores) {
		super();
		this.codSalon = codSalon;
		this.nombreSalon = nombreSalon;
		this.local = local;
		this.sectores = sectores;
	}

	public List<SectorEntity> getSectores() {
		return sectores;
	}

	public void setSectores(List<SectorEntity> sectores) {
		this.sectores = sectores;
	}

	public Integer getCodSalon() {
		return codSalon;
	}


	public void setCodSalon(Integer codSalon) {
		this.codSalon = codSalon;
	}


	public LocalEntity getLocal() {
		return local;
	}


	public void setLocal(LocalEntity local) {
		this.local = local;
	}



	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}


	public Salon toNegocio() 
	{
		Salon s=new Salon();
		s.setCodSalon(codSalon);
		s.setLocal(local.toNegocio());
		s.setNombreSalon(nombreSalon);
		return s;
	}

}
