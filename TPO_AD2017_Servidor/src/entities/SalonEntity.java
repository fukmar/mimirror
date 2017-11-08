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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codSalon")
	private Integer codSalon;
	private String nombreSalon;
	@OneToMany
	@JoinColumn(name="codSector")
	private List<SectorEntity> sectores;
	
	public SalonEntity(){}


	public SalonEntity(AreaRest area,
			String nombreSalon, List<SectorEntity> sectores) {
		super(area);
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

	public List<SectorEntity> getSectores() {
		return sectores;
	}

	public void setSectores(List<SectorEntity> sectores) {
		this.sectores = sectores;
	}
}
