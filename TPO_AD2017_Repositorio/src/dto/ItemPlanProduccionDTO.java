package dto;

import java.io.Serializable;

import javax.persistence.*;




public class ItemPlanProduccionDTO implements Serializable {

	private Integer itemplanid;
	//private SemiElaboradoDTO semielaborado;
	private Integer cantidad;
	private double porcientoavance=0;
	//private PlanDeProduccionDTO plandeProduccion;
	

	public ItemPlanProduccionDTO() {
		super();
	}


	public ItemPlanProduccionDTO(/*SemiElaboradoDTO semielaborado, */Integer cantidad, Integer porcientoavance/*,
			PlanDeProduccionDTO plandeProduccion*/) {
		super();
		//this.semielaborado= semielaborado;
		this.cantidad = cantidad;
		this.porcientoavance = porcientoavance;
		//this.plandeProduccion = plandeProduccion;
	}


	public Integer getItemplanid() {
		return itemplanid;
	}


	public void setItemplanid(Integer itemplanid) {
		this.itemplanid = itemplanid;
	}


/*
	public SemiElaboradoDTO getSemielaborado() {
		return semielaborado;
	}


	public void setSemielaborado(SemiElaboradoDTO semielaborado) {
		this.semielaborado = semielaborado;
	}

*/
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

/*
	public PlanDeProduccionDTO getPlandeProduccion() {
		return plandeProduccion;
	}


	public void setPlandeProduccion(PlanDeProduccionDTO plandeProduccion) {
		this.plandeProduccion = plandeProduccion;
	}
*/	
}
