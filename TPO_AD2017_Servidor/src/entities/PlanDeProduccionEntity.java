package entities;

import enumns.Estado;
import negocio.Elaborado;
import negocio.ItemPlanProduccion;
import negocio.PlanDeProduccion;
import negocio.Plato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="planesdeproduccion")
public class PlanDeProduccionEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoPDP;
	private Date fechaplan;
	private Estado estado;
	private double avance;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="itemplanid", cascade = CascadeType.ALL)
	private List<ItemPlanProduccionEntity> itemspdp;
	
	public PlanDeProduccionEntity(){}
	
	public PlanDeProduccionEntity(Estado estado) {
		super();
		this.estado = estado;
	}
	

	public PlanDeProduccionEntity(Integer codigoPDP, Date fechaplan, Estado estado, double avance,
			List<ItemPlanProduccionEntity> itemspdp) {
		super();
		this.codigoPDP = codigoPDP;
		this.fechaplan = fechaplan;
		this.estado = estado;
		this.avance = avance;
		this.itemspdp = itemspdp;
	}

	public double getAvance() {
		return avance;
	}

	public void setAvance(double avance) {
		this.avance = avance;
	}

	public Date getFechaplan() {
		return fechaplan;
	}

	public void setFechaplan(Date fechaplan) {
		this.fechaplan = fechaplan;
	}

	public List<ItemPlanProduccionEntity> getItemspdp() {
		return itemspdp;
	}

	public void setItemspdp(List<ItemPlanProduccionEntity> itemspdp) {
		this.itemspdp = itemspdp;
	}

	public Integer getCodigoPDP() {
		return codigoPDP;
	}
	public void setCodigoPDP(Integer codigoPDP) {
		this.codigoPDP = codigoPDP;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

	public PlanDeProduccion toNegocio() 
	{
		PlanDeProduccion p=new PlanDeProduccion();
		p.setCodigoPDP(codigoPDP);
		List <ItemPlanProduccion> planesnegocio= new ArrayList <ItemPlanProduccion>();
		for (ItemPlanProduccionEntity itemplan:itemspdp)
		{
			planesnegocio.add(itemplan.toNegocio());
		}
		p.setItemspdp(planesnegocio);
		p.setEstado(estado);
		p.setAvance(avance);
		p.setFechaplan(fechaplan);
		return p;
	}
}
