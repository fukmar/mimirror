package dto;

import java.io.Serializable;
import java.util.List;


import enumns.AreaRest;



public class CajaDTO extends AreaRestaurantDTO implements Serializable
{
	
private SalonDTO salon;
	
	public CajaDTO(){}
	
	public CajaDTO(Integer codArea,AreaRest area,SalonDTO salon,LocalDTO local) {
	super(codArea, area,local);
		this.salon=salon;
		// TODO Auto-generated constructor stub
	}

	public SalonDTO getSalon() {
		return salon;
	}

	public void setSalon(SalonDTO salon) {
		this.salon = salon;
	}
	
/*	public CajaEntity toNegocio() 
	{
		CajaEntity c=new CajaEntity();
		c.setCodArea(codArea);
		c.setArea(area);
		//c.setLocal(local.toNegocio);
		//c.setSalon(salon.toNegocio());
		return c;
	}*/

	
}
