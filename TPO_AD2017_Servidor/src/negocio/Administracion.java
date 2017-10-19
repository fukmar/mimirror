package negocio;

import java.util.*;

import enumns.AreaRest;

public class Administracion extends AreaRestaurant {

	private List<PlanDeProduccion> planesProd;

	public Administracion(List<PlanDeProduccion> planesProd,Integer codArea,
	 AreaRest area) {
	
		this.codArea=codArea;
		this.area=area;
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
