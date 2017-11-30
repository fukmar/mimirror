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
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="codigoProd")
	private SemiElaboradoEntity semielaborado;
	private Integer cantidad;
	private double porcientoavance=0;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="codigoPDP")
	private PlanDeProduccionEntity plandeProduccion;
	


	public ItemPlanProduccionEntity(SemiElaboradoEntity semielaborado, Integer cantidad, double porcientoavance,
			PlanDeProduccionEntity plandeProduccion) {
		super();
		this.semielaborado = semielaborado;
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


	public SemiElaboradoEntity getSemielaborado() {
		return semielaborado;
	}

	public void setSemielaborado(SemiElaboradoEntity semielaborado) {
		this.semielaborado = semielaborado;
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
		itemplan.setPorcientoavance(porcientoavance);
		itemplan.setSemielaborado(semielaborado.toNegocio());
		return itemplan;
	}

	
}
