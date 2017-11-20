package negocio;

import java.util.*;

import entities.LocalEntity;
import entities.ProductoEntity;
import enumns.AreaRest;
public class Cafeteria extends AreaRestaurant 
{

	private List<Producto> estimadoDiario;

	private Cafeteria(){
		
	}

	public Cafeteria(Integer codArea, AreaRest area,
			List<Producto> estimadoDiario,Local local) {
		super(codArea, area,local);
		this.estimadoDiario = estimadoDiario;
	}


	public List<Producto> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<Producto> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	
	
}
