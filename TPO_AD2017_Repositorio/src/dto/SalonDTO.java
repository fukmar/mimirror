package dto;

import java.io.Serializable;
import java.util.List;


import enumns.AreaRest;



public class SalonDTO extends AreaRestaurantDTO implements Serializable
{
	private String nombreSalon;

	public SalonDTO(){}


	public SalonDTO(Integer codArea,AreaRest area,String nombreSalon,LocalDTO local) 
	{
		super(codArea, area,local);
	    this.nombreSalon = nombreSalon;
	}



public String getNombreSalon() {
	return nombreSalon;
}

public void setNombreSalon(String nombreSalon) {
	this.nombreSalon = nombreSalon;
}


/*public SalonEntity toEntity() 
{
	SalonEntity s=new SalonEntity();
	s.setNombreSalon(nombreSalon);
	return s;
}*/


	
}
