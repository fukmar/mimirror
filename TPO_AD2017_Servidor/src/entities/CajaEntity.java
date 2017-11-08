package entities;

import java.util.List;
import javax.persistence.*;

import enumns.AreaRest;

@Entity
@Table(name="cajas")
public class CajaEntity extends AreaRestaurantEntity
{

	
	public CajaEntity(){}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codSalon")
	private SalonEntity salon;
	
	public CajaEntity(Integer codArea,AreaRest area,SalonEntity salon) {
		super(codArea, area);
		this.salon=salon;
		// TODO Auto-generated constructor stub
	}

	public SalonEntity getSalon() {
		return salon;
	}

	public void setSalon(SalonEntity salon) {
		this.salon = salon;
	}
	
	
	

	
}
