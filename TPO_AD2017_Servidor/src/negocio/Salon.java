package negocio;

import java.util.List;

import dto.SectorDTO;

public class Salon 
{
	private Integer codSalon;
	private String nombreSalon;
	private List<Sector> sectores;
	
	public Salon(){}

	public Salon(Integer codSalon, String nombreSalon, List<Sector> sectores) {
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

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
}
