package dto;

import java.io.Serializable;
import java.util.List;


public class SectorDTO implements Serializable
{
	private Integer codSector;
	private String descripcion;
	private SalonDTO salon;
	
	
	public SectorDTO(){}

	public SectorDTO(String descripcion,SalonDTO salon) {
		super();
		
		this.descripcion = descripcion;
		this.salon=salon;
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

	public SalonDTO getSalon() {
		return salon;
	}

	public void setSalon(SalonDTO salon) {
		this.salon = salon;
	}

	@Override
	public String toString() {
		return "SectorDTO [codSector=" + codSector + ", descripcion=" + descripcion + ", salon=" + salon + "]";
	}
	
	
	
}
