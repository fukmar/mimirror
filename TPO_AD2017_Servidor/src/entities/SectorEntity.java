package entities;

import java.util.List;

import negocio.Mozo;
import javax.persistence.*;
@Entity
@Table(name="sectores")

public class SectorEntity 
{
	@Id
	@Column(name="codSector")
	private Integer codSector;
	private String descripcion;
	@OneToMany
	@JoinColumn(name="codMozo")
	private List<MozoEntity> mozo;
	
	public SectorEntity(){}

	public SectorEntity(Integer codSector, String descripcion, List<MozoEntity> mozo) {
		super();
		this.codSector = codSector;
		this.descripcion = descripcion;
		this.mozo = mozo;
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

	public List<MozoEntity> getMozo() {
		return mozo;
	}

	public void setMozo(List<MozoEntity> mozo) {
		this.mozo = mozo;
	}
}
