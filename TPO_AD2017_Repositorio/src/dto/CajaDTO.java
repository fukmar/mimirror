package dto;

import java.io.Serializable;
import java.util.List;


import enumns.AreaRest;


public class CajaDTO extends AreaRestaurantDTO implements Serializable
{
	
private SalonDTO salon;
	
	public CajaDTO()
	{}
	
	
	


	public CajaDTO(Integer codArea, AreaRest area,SalonDTO salon) {
		super(codArea, area);
		this.salon=salon;
	}





	public SalonDTO getSalon() {
		return salon;
	}

	public void setSalon(SalonDTO salon) {
		this.salon = salon;
	}
	

	
	
}
