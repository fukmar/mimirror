package negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import dto.AreaRestaurantDTO;
import dto.ComandaDTO;
import dto.FacturaDTO;
import entities.CajaEntity;
import enumns.AreaRest;

public class Caja extends AreaRestaurant
{
	private Salon salon;
	
	public Caja(){}
	
	public Caja(Integer codArea,AreaRest area,Salon salon,Local local) {
	super(codArea, area,local);
		this.salon=salon;
		// TODO Auto-generated constructor stub
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
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

	public CajaEntity toEntity() 
	{
		CajaEntity c=new CajaEntity();
		c.setCodArea(codArea);
		c.setArea(area);
		c.setSalon(salon.toEntity());
		c.setLocal(local.toEntity());
		return c;
	}

	@Override
	public AreaRestaurantDTO toDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
