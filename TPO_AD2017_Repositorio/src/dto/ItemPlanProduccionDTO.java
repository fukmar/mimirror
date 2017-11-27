package dto;

import javax.persistence.*;


public class ItemPlanProduccionDTO {

	private Integer itemplanid;
	private PlatoDTO plato;
	private Integer cantidad;
	private double porcientoavance=0;
	private PlanDeProduccionDTO plandeProduccion;
	

	public ItemPlanProduccionDTO() {
		super();
	}


	public ItemPlanProduccionDTO(PlatoDTO plato, Integer cantidad, Integer porcientoavance,
			PlanDeProduccionDTO plandeProduccion) {
		super();
		this.plato = plato;
		this.cantidad = cantidad;
		this.porcientoavance = porcientoavance;
		this.plandeProduccion = plandeProduccion;
	}


	public Integer getItemplanid() {
		return itemplanid;
	}


	public void setItemplanid(Integer itemplanid) {
		this.itemplanid = itemplanid;
	}


	public PlatoDTO getPlato() {
		return plato;
	}


	public void setPlato(PlatoDTO plato) {
		this.plato = plato;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public double getPorcientoavance() {
		return porcientoavance;
	}


	public void setPorcientoavance(double porcientoavance) {
		this.porcientoavance = porcientoavance;
	}


	public PlanDeProduccionDTO getPlandeProduccion() {
		return plandeProduccion;
	}


	public void setPlandeProduccion(PlanDeProduccionDTO plandeProduccion) {
		this.plandeProduccion = plandeProduccion;
	}
	
}
