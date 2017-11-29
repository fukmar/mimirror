package dto;

import java.io.Serializable;
import java.util.List;
import enumns.AreaRest;


public class SalonDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer codSalon;
	private String nombreSalon;
	protected LocalDTO local;
	private List<SectorDTO> sectores;

	public SalonDTO(){}




public SalonDTO(Integer codSalon, String nombreSalon, LocalDTO local, List<SectorDTO> sectores) {
		super();
		this.codSalon = codSalon;
		this.nombreSalon = nombreSalon;
		this.local = local;
		this.sectores = sectores;
	}




public SalonDTO(String nombreSalon, LocalDTO local, List<SectorDTO> sectores) {
		super();
		this.nombreSalon = nombreSalon;
		this.local = local;
		this.sectores = sectores;
	}


public SalonDTO(String nombreSalon, LocalDTO local) {
	super();
	this.nombreSalon = nombreSalon;
	this.local = local;
}




public List<SectorDTO> getSectores() {
	return sectores;
}




public void setSectores(List<SectorDTO> sectores) {
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


public LocalDTO getLocal() {
	return local;
}


public void setLocal(LocalDTO local) {
	this.local = local;
}


@Override
public String toString() {
	return "SalonDTO [nombreSalon=" + nombreSalon + "]";
}

	
}
