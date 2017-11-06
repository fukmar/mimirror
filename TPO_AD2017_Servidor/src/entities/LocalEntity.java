package entities;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="locales")
public class LocalEntity 
{
	@Id
	@Column(name="codLocal")
	private Integer codigoLocal;
	private String direccion;
	private String barrio;
	
	//Un local tiene varias areas
	
	@OneToMany
	private List<AreaRestaurantEntity> areas;
	
	
	public LocalEntity(){}


	public LocalEntity(Integer codigoLocal, String direccion, String barrio, List<AreaRestaurantEntity> areas) {
		super();
		this.codigoLocal = codigoLocal;
		this.direccion = direccion;
		this.barrio = barrio;
		this.areas = areas;
	}


	public Integer getCodigoLocal() {
		return codigoLocal;
	}


	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getBarrio() {
		return barrio;
	}


	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}


	public List<AreaRestaurantEntity> getAreas() {
		return areas;
	}


	public void setAreas(List<AreaRestaurantEntity> areas) {
		this.areas = areas;
	}

	
}
