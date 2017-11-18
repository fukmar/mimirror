package dto;

import java.io.Serializable;
import java.util.List;

import enumns.AreaRest;


public class SalonDTO extends AreaRestaurantDTO implements Serializable
{
	
private String nombreSalon;
	
	public SalonDTO(){}


	
	public SalonDTO(String nombreSalon) {
		super();
		this.nombreSalon = nombreSalon;
	}



	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}



	@Override
	public String toString() {
		return "SalonDTO [nombreSalon=" + nombreSalon + "]";
	}


	
}
