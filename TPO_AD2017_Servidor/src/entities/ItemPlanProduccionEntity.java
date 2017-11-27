package entities;

import javax.persistence.*;

import dto.ItemPlanProduccionDTO;
import negocio.ItemPlanProduccion;


@Entity
@Table(name="ItemsPlandeProduccion")
public class ItemPlanProduccionEntity {
	@Id
	@GeneratedValue
	private Integer itemplanid;
	@ManyToOne
	@JoinColumn(name="codigo")
	private PlatoEntity plato;
	private Integer cantidad;
	private double porcientoavance=0;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="codigoPDP")
	private PlanDeProduccionEntity plandeProduccion;
	


	public ItemPlanProduccionEntity(PlatoEntity plato, Integer cantidad, double porcientoavance,
			PlanDeProduccionEntity plandeProduccion) {
		super();
		this.plato = plato;
		this.cantidad = cantidad;
		this.porcientoavance = porcientoavance;
		this.plandeProduccion = plandeProduccion;
	}

	public ItemPlanProduccionEntity() {
		super();
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public PlanDeProduccionEntity getPlandeProduccion() {
		return plandeProduccion;
	}

	public void setPlandeProduccion(PlanDeProduccionEntity plandeProduccion) {
		this.plandeProduccion = plandeProduccion;
	}

	public Integer getItemplanid() {
		return itemplanid;
	}

	public void setItemplanid(Integer itemplanid) {
		this.itemplanid = itemplanid;
	}

	public PlatoEntity getPlato() {
		return plato;
	}

	public void setPlato(PlatoEntity plato) {
		this.plato = plato;
	}

	public double getPorcientoavance() {
		return porcientoavance;
	}

	public void setPorcientoavance(double porcientoavance) {
		this.porcientoavance = porcientoavance;
	}


	public ItemPlanProduccion toNegocio()
	{
		ItemPlanProduccion itemplan=new ItemPlanProduccion();
		itemplan.setItemplanid(itemplanid);
		itemplan.setCantidad(cantidad);
		itemplan.setPlato(plato.toNegocio());
		itemplan.setPorcientoavance(porcientoavance);
		return itemplan;
	}

	
}
