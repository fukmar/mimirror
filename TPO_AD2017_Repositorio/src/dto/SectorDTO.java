package dto;

import java.io.Serializable;
import java.util.List;

public class SectorDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -152834421019023307L;
	private Integer codSector;
	private String descripcion;
	private List<MozoDTO> mozo;
	
	public SectorDTO(){}

	public SectorDTO(Integer codSector, String descripcion, List<MozoDTO> mozo) {
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

	public List<MozoDTO> getMozo() {
		return mozo;
	}

	public void setMozo(List<MozoDTO> mozo) {
		this.mozo = mozo;
	}

	@Override
	public String toString() {
		return "SectorDTO [codSector=" + codSector + ", descripcion=" + descripcion + ", mozo=" + mozo + "]";
	}
	
	
}
