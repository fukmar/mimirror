package dto;

import java.io.Serializable;

import enumns.AreaRest;


public class AreaRestaurantDTO implements Serializable
{

	protected Integer codArea;
	protected AreaRest area;
	protected LocalDTO local;
	
	
	public AreaRestaurantDTO(){}

	public AreaRestaurantDTO(Integer codArea,AreaRest area,LocalDTO local) 
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

	public LocalDTO getLocal() {
		return local;
	}

	public void setLocal(LocalDTO local) {
		this.local = local;
	}
	
	
	
}
