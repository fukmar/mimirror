package negocio;

import java.util.*;

import entities.AreaRestaurantEntity;
import entities.LocalEntity;
import entities.ProductoEntity;
import enumns.AreaRest;

public class Barra extends AreaRestaurant
{

	private List<Producto> estimadoDiario;
	
	public Barra(){
		
	}

	
	public Barra(Integer codArea, AreaRest area,
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


	@Override
	public AreaRestaurantEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
