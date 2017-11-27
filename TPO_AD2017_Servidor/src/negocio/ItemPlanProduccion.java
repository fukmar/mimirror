package negocio;

import javax.persistence.*;

import dto.ItemPlanProduccionDTO;
import entities.ItemPlanProduccionEntity;
import entities.PlanDeProduccionEntity;
import entities.PlatoEntity;

public class ItemPlanProduccion {

	private Integer itemplanid;
	private Plato plato;
	private Integer cantidad;
	private double porcientoavance=0;
	private PlanDeProduccion plandeProduccion;
	

	public ItemPlanProduccion() {
		super();
	}
	public ItemPlanProduccion(Plato plato, Integer cantidad, double porcientoavance,
			PlanDeProduccion plandeProduccion) {
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
	public Plato getPlato() {
		return plato;
	}
	public void setPlato(Plato plato) {
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
		itemplandto.setPlandeProduccion(plandeProduccion.toDTO());
		itemplandto.setPlato(plato.toDTO());
		itemplandto.setPorcientoavance(porcientoavance);
		return itemplandto;
	}
	public ItemPlanProduccionEntity toEntity()
	{
		ItemPlanProduccionEntity itemplan=new ItemPlanProduccionEntity();
		itemplan.setCantidad(cantidad);
		itemplan.setItemplanid(itemplanid);
		itemplan.setPlandeProduccion(plandeProduccion.toEntity());
		itemplan.setPlato(plato.toEntity());
		itemplan.setPorcientoavance(porcientoavance);
		return itemplan;
	}
}