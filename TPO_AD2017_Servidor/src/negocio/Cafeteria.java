package negocio;

import java.util.*;

import enumns.AreaRest;
public class Cafeteria extends AreaRestaurant {

	private List<Producto> estimadoDiario;

	public Cafeteria(Integer codArea, AreaRest area,
			List<Producto> estimadoDiario) {
		super(area);
		this.estimadoDiario = estimadoDiario;
	}

	public List<Producto> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<Producto> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	private Cafeteria(){
		
	}
	
}
