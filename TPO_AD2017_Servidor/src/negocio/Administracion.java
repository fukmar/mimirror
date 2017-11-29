package negocio;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import entities.AdministracionEntity;
import entities.AreaRestaurantEntity;
import entities.LocalEntity;
import entities.PlanDeProduccionEntity;
import enumns.AreaRest;
import dto.*;

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
	public AdministracionEntity toEntity() {
		AdministracionEntity a=new AdministracionEntity();
		a.setArea(area);
		a.setCodArea(codArea);
		a.setLocal(local.toEntity());
		List <PlanDeProduccionEntity> planesentity = new ArrayList<PlanDeProduccionEntity>();
		for (PlanDeProduccion plan: planesProd)
		{
			planesentity.add(plan.toEntity());
		}
		return a;
	}

	@Override

	public AdministracionDTO toDTO() 
	{
		AdministracionDTO a=new AdministracionDTO();
		a.setArea(area);
		a.setCodArea(codArea);
		a.setLocal(local.toDTO());
		return a;
	}
	
	
	
	
	
	
}
