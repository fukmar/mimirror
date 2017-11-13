package negocio;

import java.util.List;

import dto.SectorDTO;
import entities.LocalEntity;
import enumns.AreaRest;

public class Salon extends AreaRestaurant
{
	private String nombreSalon;
	
	public Salon(){}


	public Salon(Integer codArea,AreaRest area,String nombreSalon,Local local) {
		super(codArea, area,local);
		this.nombreSalon = nombreSalon;

	}

	

	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}

}
