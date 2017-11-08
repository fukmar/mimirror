package negocio;

import java.util.*;

import enumns.AreaRest;

public class Barra extends AreaRestaurant {

	private List<Producto> estimadoDiario;
	
	public Barra(){
		
	}

	public Barra(Integer codArea, AreaRest area, List<Producto> estimadoDiario) {
		super(area);
		this.estimadoDiario = estimadoDiario;
	}

	public List<Producto> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<Producto> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	
}
