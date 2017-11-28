package entities;


import javax.persistence.*;

import negocio.AreaRestaurant;
import negocio.Producto;
import enumns.AreaRest;

import java.util.*;

@Entity
@Table(name="cafeterias")
public class CafeteriaEntity extends AreaRestaurantEntity {
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="codEstimadoDiario")
	private List<ProductoEntity> estimadoDiario;

	public CafeteriaEntity(AreaRest area,
			List<ProductoEntity> estimadoDiario,LocalEntity local) {
		super(area,local);
		this.estimadoDiario = estimadoDiario;
	}

	public List<ProductoEntity> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<ProductoEntity> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	private CafeteriaEntity(){
		
	}

	@Override
	public AreaRestaurant toNegocio() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
