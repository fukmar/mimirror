package entities;

import java.util.List;

import negocio.Mozo;

public class SectorEntity 
{
	private Integer codSector;
	private String descripcion;
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
