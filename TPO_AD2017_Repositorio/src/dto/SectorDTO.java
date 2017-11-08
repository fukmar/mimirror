package dto;

import java.io.Serializable;
import java.util.List;

public class SectorDTO implements Serializable
{
	private Integer codSector;
	private String descripcion;
	
	
	public SectorDTO(){}

	public SectorDTO(String descripcion) {
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

	@Override
	public String toString() {
		return "SectorDTO [codSector=" + codSector + ", descripcion=" + descripcion + "]";
	}


	
	
	
}
