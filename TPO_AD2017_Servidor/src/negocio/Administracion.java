package negocio;

import java.util.*;

import enumns.AreaRest;

public class Administracion extends AreaRestaurant {

	private List<PlanDeProduccion> planesProd;


	public Administracion(Integer codArea, AreaRest area,
			List<PlanDeProduccion> planesProd) {
		super(area);
		this.planesProd = planesProd;
	}

	
	public Administracion(){
		
	}

	public List<PlanDeProduccion> getPlanesProd() {
		return planesProd;
	}

	public void setPlanesProd(List<PlanDeProduccion> planesProd) {
		this.planesProd = planesProd;
	}
	
	
	
	
	
	
}
