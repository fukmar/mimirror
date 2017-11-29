package entities;
import javax.persistence.*;

import enumns.AreaRest;
//FALTAN METODOS DE NEGOCIO
import negocio.AreaRestaurant;

@Entity
@Table(name="AreasRestaurant")
public class AreaRestaurantEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codAreaRestaurant")
	protected Integer codArea;
	
	@Enumerated(EnumType.STRING)
	protected AreaRest area;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codLocal")
	protected LocalEntity local;
	
	
	public AreaRestaurantEntity(){}



	public AreaRestaurantEntity(AreaRest area, LocalEntity local) {
		super();
		this.area = area;
		this.local = local;
	}



	public AreaRestaurantEntity(Integer codArea, AreaRest area, LocalEntity local) {
		super();
		this.codArea = codArea;
		this.area = area;
		this.local = local;
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
		AreaRestaurant r=new AreaRestaurant();
		r.setArea(area);
		r.setCodArea(codArea);
		r.setLocal(local.toNegocio());
		return r;
	}


		
}
