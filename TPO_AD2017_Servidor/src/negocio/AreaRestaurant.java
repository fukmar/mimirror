package negocio;


import dto.AreaRestaurantDTO;
import entities.AreaRestaurantEntity;
import enumns.AreaRest;


public class AreaRestaurant
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
	
	public AreaRestaurantEntity toEntity()
	{
		AreaRestaurantEntity r=new AreaRestaurantEntity();
		r.setArea(area);
		r.setCodArea(codArea);
		r.setLocal(local.toEntity());
		return r;
		
	}

	public AreaRestaurantDTO toDTO() 
	{
		return null;
		
	}
	
}
