package entities;

import java.util.List;

import negocio.Salon;
import negocio.Sector;

import javax.persistence.*;

import enumns.AreaRest;
@Entity
@Table(name="salones")
public class SalonEntity extends AreaRestaurantEntity
{
	
	private String nombreSalon;
	
	public SalonEntity(){}


	public SalonEntity(Integer codArea,AreaRest area,String nombreSalon,LocalEntity local) {
		super(codArea, area,local);
		this.nombreSalon = nombreSalon;

	}

	

	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}


	public Salon toNegocio() 
	{
		Salon s=new Salon();
		s.setCodArea(codArea);
		s.setArea(area);
		s.setLocal(local.toNegocio());
		s.setNombreSalon(nombreSalon);
		return s;
	}





}
