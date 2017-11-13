package negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import dto.ComandaDTO;
import dto.FacturaDTO;
import entities.CajaEntity;
import entities.LocalEntity;
import entities.SalonEntity;
import enumns.AreaRest;

public class Caja extends AreaRestaurant
{
	private SalonEntity salon;
	
	public Caja(){}
	
	public Caja(Integer codArea,AreaRest area,SalonEntity salon,Local local) {
	super(codArea, area,local);
		this.salon=salon;
		// TODO Auto-generated constructor stub
	}

	public SalonEntity getSalon() {
		return salon;
	}

	public void setSalon(SalonEntity salon) {
		this.salon = salon;
	}
	
	public CajaEntity toNegocio() 
	{
		CajaEntity c=new CajaEntity();
		c.setCodArea(codArea);
		c.setArea(area);
		//c.setLocal(local.toNegocio);
		//c.setSalon(salon.toNegocio());
		return c;
	}

}
