package dto;

import java.io.Serializable;
import java.util.List;

import enumns.AreaRest;


public class AdministracionDTO extends AreaRestaurantDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7507016844667053465L;
	private List<PlanDeProduccionDTO> planesProd;

	public AdministracionDTO(){
		
	}
	
	public AdministracionDTO(Integer codArea,AreaRest area,List<PlanDeProduccionDTO> planesProd,LocalDTO local) {
		super(codArea, area,local);
		this.planesProd = planesProd;
	}

	

	
	public List<PlanDeProduccionDTO> getPlanesProd() {
		return planesProd;
	}

	public void setPlanesProd(List<PlanDeProduccionDTO> planesProd) {
		this.planesProd = planesProd;
	}
	
	
	
}
