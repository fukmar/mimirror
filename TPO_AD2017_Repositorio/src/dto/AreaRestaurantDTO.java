package dto;

import java.io.Serializable;

import enumns.AreaRest;

public abstract class AreaRestaurantDTO implements Serializable
{
	private Integer codArea;
	private AreaRest area;
	
	public AreaRestaurantDTO(){}

	public AreaRestaurantDTO(Integer codArea, AreaRest area) {
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

	@Override
	public String toString() {
		return "AreaRestaurantDTO [codArea=" + codArea + ", area=" + area + "]";
	}
	
	
}
