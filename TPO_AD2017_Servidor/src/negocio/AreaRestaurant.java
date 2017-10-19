package negocio;

import enumns.AreaRest;
//FALTAN METODOS DE NEGOCIO

public abstract class AreaRestaurant {
	
	protected Integer codArea;
	protected AreaRest area;
	
	public AreaRestaurant(){
		
	}

	public AreaRestaurant(Integer codArea, AreaRest area) {
		super();
		this.codArea = codArea;
		this.area = area;
	}

	public Integer getCodArea() {
		return codArea;
	}

	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}

	public AreaRest getArea() {
		return area;
	}

	public void setArea(AreaRest area) {
		this.area = area;
	}
	
	
}
