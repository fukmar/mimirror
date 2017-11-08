package entities;


import javax.persistence.*;

import negocio.Producto;
import enumns.AreaRest;

import java.util.*;

@Entity
@Table(name="cafeterias")
public class CafeteriaEntity extends AreaRestaurantEntity {
	
	@OneToMany
	@JoinColumn(name="codEstimadoDiario")
	private List<ProductoEntity> estimadoDiario;

	public CafeteriaEntity(Integer codArea, AreaRest area,
			List<ProductoEntity> estimadoDiario) {
		super(codArea, area);
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
	
}
