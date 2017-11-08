package entities;

import java.util.List;

import negocio.Sector;

import javax.persistence.*;

import enumns.AreaRest;
@Entity
@Table(name="salones")
public class SalonEntity extends AreaRestaurantEntity
{
	
	private String nombreSalon;
	
	public SalonEntity(){}


	public SalonEntity(Integer codArea,AreaRest area,String nombreSalon) {
		super(codArea, area);
		this.nombreSalon = nombreSalon;

	}

	

	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}





}
