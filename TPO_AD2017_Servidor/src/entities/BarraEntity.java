package entities;

import javax.persistence.*;

import enumns.AreaRest;
import negocio.AreaRestaurant;
import negocio.Barra;

import java.util.*;


@Entity
@Table(name="barras")
public class BarraEntity extends AreaRestaurantEntity {

	public BarraEntity(AreaRest area,LocalEntity local) {
		super(area,local);
	}


	
	public BarraEntity(){
		
	}

	@Override
	public Barra toNegocio() {
		Barra barra=new Barra();
		barra.setArea(area);
		barra.setCodArea(codArea);
		barra.setLocal(local.toNegocio());
		return barra;
	}
	
	
}
