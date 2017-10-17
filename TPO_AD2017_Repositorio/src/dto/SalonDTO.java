package dto;

import java.io.Serializable;
import java.util.List;

public class SalonDTO extends AreaRestaurantDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codSalon;
	private String nombreSalon;
	private List<SectorDTO> sectores;
	
	public SalonDTO(){}

	public SalonDTO(Integer codSalon, String nombreSalon, List<SectorDTO> sectores) {
		super();
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

	public List<SectorDTO> getSectores() {
		return sectores;
	}

	public void setSectores(List<SectorDTO> sectores) {
		this.sectores = sectores;
	}

	@Override
	public String toString() {
		return "SalonDTO [codSalon=" + codSalon + ", nombreSalon=" + nombreSalon + ", sectores=" + sectores + "]";
	}
	
	
}
