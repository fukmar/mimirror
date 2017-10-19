package entities;

import java.util.List;

import negocio.Sector;

import javax.persistence.*;

import enumns.AreaRest;
@Entity
@Table(name="salones")
public class SalonEntity extends AreaRestaurantEntity
{
	@Id
	@Column(name="codSalon")
	private Integer codSalon;
	private String nombreSalon;
	@OneToMany
	@JoinColumn(name="codSector")
	private List<Sector> sectores;
	
	public SalonEntity(){}


	public SalonEntity(Integer codArea, AreaRest area, Integer codSalon,
			String nombreSalon, List<Sector> sectores) {
		super(codArea, area);
		this.codSalon = codSalon;
		this.nombreSalon = nombreSalon;
		this.sectores = sectores;
	}

	public Integer getCodSalon() {
		return codSalon;
	}

	public void setCodSalon(Integer codSalon) {
		this.codSalon = codSalon;
	}

	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
}
