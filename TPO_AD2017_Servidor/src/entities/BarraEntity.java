package entities;

import javax.persistence.*;

import enumns.AreaRest;

import java.util.*;


@Entity
@Table(name="barras")
public class BarraEntity extends AreaRestaurantEntity {

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="codEstimadoDiario")
	List<ProductoEntity> estimadoDiario;

	public BarraEntity(Integer codArea, AreaRest area,
			List<ProductoEntity> estimadoDiario,LocalEntity local) {
		super(codArea, area,local);
		this.estimadoDiario = estimadoDiario;
	}

	public List<ProductoEntity> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<ProductoEntity> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	public BarraEntity(){
		
	}
	
	
}
