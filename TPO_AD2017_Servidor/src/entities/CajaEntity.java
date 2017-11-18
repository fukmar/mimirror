package entities;

import java.util.List;
import javax.persistence.*;

import enumns.AreaRest;
import negocio.Caja;

@Entity
@Table(name="cajas")
public class CajaEntity extends AreaRestaurantEntity
{
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codSalon")
	private SalonEntity salon;
	
	public CajaEntity(){}

	
	public CajaEntity(Integer codArea,AreaRest area,SalonEntity salon,LocalEntity local) {
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


	public Caja toNegocio() 
	{
		Caja caja=new Caja();
		caja.setCodArea(codArea);
		caja.setArea(area);
		caja.setSalon(salon.toNegocio());
		caja.getLocal();
		return caja;
	}
	
	
	

	
}
