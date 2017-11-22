package negocio;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import entities.AreaRestaurantEntity;
import entities.LocalEntity;
import entities.PlanDeProduccionEntity;
import enumns.AreaRest;

public class Administracion extends AreaRestaurant 
{
	private List<PlanDeProduccion> planesProd;

	public Administracion(){
		
	}
	
	public Administracion(Integer codArea,AreaRest area,List<PlanDeProduccion> planesProd,Local local) {
		super(codArea, area,local);
		this.planesProd = planesProd;
	}

	

	
	public List<PlanDeProduccion> getPlanesProd() {
		return planesProd;
	}

	public void setPlanesProd(List<PlanDeProduccion> planesProd) {
		this.planesProd = planesProd;
	}

	@Override
	public AreaRestaurantEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
