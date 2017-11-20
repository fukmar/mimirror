package negocio;

import java.util.List;

import dto.SalonDTO;
import dto.SectorDTO;
import entities.LocalEntity;
import entities.SalonEntity;
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


	public SalonEntity toEntity() 
	{
		SalonEntity s=new SalonEntity();
		s.setNombreSalon(nombreSalon);
		return s;
	}


	public SalonDTO toDTO() 
	{
		SalonDTO s=new SalonDTO();
		s.setCodArea(codArea);
		s.setNombreSalon(nombreSalon);
		s.setArea(area);
		return s;
	}


	
}
