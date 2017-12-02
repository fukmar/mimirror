package negocio;

import javax.persistence.*;

import dto.ItemPlanProduccionDTO;
import entities.ItemPlanProduccionEntity;
import entities.PlanDeProduccionEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;

public class ItemPlanProduccion {

	private Integer itemplanid;
	private SemiElaborado semielaborado;
	private Integer cantidad;
	private double porcientoavance=0;
	private PlanDeProduccion plandeProduccion;
	

	public ItemPlanProduccion() {
		super();
	}
	public ItemPlanProduccion(SemiElaborado semielaborado, Integer cantidad, double porcientoavance,
			PlanDeProduccion plandeProduccion) {
		super();
		this.semielaborado = semielaborado;
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

	public SemiElaborado getSemielaborado() {
		return semielaborado;
	}
	public void setSemielaborado(SemiElaborado semielaborado) {
		this.semielaborado = semielaborado;
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
	public PlanDeProduccion getPlandeProduccion() {
		return plandeProduccion;
	}
	public void setPlandeProduccion(PlanDeProduccion plandeProduccion) {
		this.plandeProduccion = plandeProduccion;
	}
	public ItemPlanProduccionDTO toDTO()
	{
		ItemPlanProduccionDTO itemplandto=new ItemPlanProduccionDTO();
		itemplandto.setCantidad(cantidad);
		itemplandto.setItemplanid(itemplanid);
		//itemplandto.setPlandeProduccion(plandeProduccion.toDTO());
		itemplandto.setSemielaborado(semielaborado.toDTO());
		itemplandto.setPorcientoavance(porcientoavance);
		return itemplandto;
	}
	public ItemPlanProduccionEntity toEntity()
	{
		ItemPlanProduccionEntity itemplan=new ItemPlanProduccionEntity();
		itemplan.setCantidad(cantidad);
		itemplan.setItemplanid(itemplanid);
		//itemplan.setPlandeProduccion(plandeProduccion.toEntity());
		itemplan.setSemielaborado(semielaborado.toEntitySemi());
		itemplan.setPorcientoavance(porcientoavance);
		return itemplan;
	}
}