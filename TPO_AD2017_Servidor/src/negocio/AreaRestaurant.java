package negocio;


import entities.AreaRestaurantEntity;
import enumns.AreaRest;
//FALTAN METODOS DE NEGOCIO

public abstract class AreaRestaurant 
{
	
	protected Integer codArea;
	protected AreaRest area;
	protected Local local;
	
	
	public AreaRestaurant(){}

	public AreaRestaurant(Integer codArea,AreaRest area,Local local) 
	{
		super();
		this.codArea=codArea;
		this.area = area;
		this.local=local;
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	public abstract AreaRestaurantEntity toEntity();
	
	
}
