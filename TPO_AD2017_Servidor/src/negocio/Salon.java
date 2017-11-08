package negocio;

import java.util.List;

import dto.SectorDTO;
import enumns.AreaRest;

public class Salon extends AreaRestaurant
{
	private Integer codSalon;
	private String nombreSalon;
	private List<Sector> sectores;
	
	public Salon(){}
	
	public Salon(Integer codArea, AreaRest area,
			String nombreSalon, List<Sector> sectores) {
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

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
}
