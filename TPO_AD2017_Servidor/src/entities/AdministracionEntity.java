package entities;
import javax.persistence.*;

import negocio.PlanDeProduccion;
import enumns.*;
import java.util.*;

@Entity
@Table(name="administraciones")
public class AdministracionEntity extends AreaRestaurantEntity {

	@OneToMany(fetch=FetchType.LAZY,mappedBy="administracion")
	private List<PlanDeProduccionEntity> planesProd;


	
	public AdministracionEntity(Integer codArea,AreaRest area,List<PlanDeProduccionEntity> planesProd,LocalEntity local) {
		super(codArea, area,local);
		this.planesProd = planesProd;
	}

	public AdministracionEntity(){
		
	}

	
	public List<PlanDeProduccionEntity> getPlanesProd() {
		return planesProd;
	}

	public void setPlanesProd(List<PlanDeProduccionEntity> planesProd) {
		this.planesProd = planesProd;
	}
	
	
}
