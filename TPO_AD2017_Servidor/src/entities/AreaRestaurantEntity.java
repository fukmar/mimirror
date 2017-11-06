package entities;
import javax.persistence.*;

import enumns.AreaRest;
//FALTAN METODOS DE NEGOCIO

@Entity
@Table(name="AreasRestaurant")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AreaRestaurantEntity {

	@Id
	@Column(name="codAreaRestaurant",nullable=false)
	protected Integer codArea;
	
	@Enumerated(EnumType.STRING)
	protected AreaRest area;
	
	public AreaRestaurantEntity(){
		
	}

	public AreaRestaurantEntity(Integer codArea, AreaRest area) {
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
		
	//hashCode e equals? revisar ejemplo ProductoEntity

}
