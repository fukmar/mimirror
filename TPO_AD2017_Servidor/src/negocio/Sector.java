package negocio;

import java.util.List;

import dto.MozoDTO;

public class Sector 
{
	private Integer codSector;
	private String descripcion;
	private List<Mozo> mozo;
	
	public Sector(){}

	public Sector(String descripcion, List<Mozo> mozo) {
		super();
	
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

	public List<Mozo> getMozo() {
		return mozo;
	}

	public void setMozo(List<Mozo> mozo) {
		this.mozo = mozo;
	}
}
