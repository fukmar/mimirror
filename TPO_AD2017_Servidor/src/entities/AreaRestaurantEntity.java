package entities;
import javax.persistence.*;

import enumns.AreaRest;
//FALTAN METODOS DE NEGOCIO
import negocio.AreaRestaurant;

@Entity
//@Table(name="AreasRestaurant")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AreaRestaurantEntity {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codAreaRestaurant")
	protected Integer codArea;
	
	@Enumerated(EnumType.STRING)
	protected AreaRest area;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codLocal")
	protected LocalEntity local;
	
	
	public AreaRestaurantEntity(){}

	public AreaRestaurantEntity(Integer codArea,AreaRest area,LocalEntity local) {
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

	public LocalEntity getLocal() {
		return local;
	}

	public void setLocal(LocalEntity local) {
		this.local = local;
	}

	public AreaRestaurant toNegocio() {
		// TODO Auto-generated method stub
		return null;
	}
		
	
	
	//hashCode e equals? revisar ejemplo ProductoEntity

}
