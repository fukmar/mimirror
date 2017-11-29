package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enumns.Estado;



public class PlanDeProduccionDTO implements Serializable
{
	private Integer codigoPDP;
	private Estado estado;
	private List<ItemPlanProduccionDTO> itemspdp;
	private Date fechaplan;
	private double avance;
	
	public PlanDeProduccionDTO(){}
	
	public PlanDeProduccionDTO(Estado estado) {
		super();
		
		this.estado = estado;
	}
	


	public PlanDeProduccionDTO(Estado estado, List<ItemPlanProduccionDTO> itemspdp,
			Date fechaplan) {
		super();
		this.estado = estado;
		this.itemspdp = itemspdp;
		this.fechaplan = fechaplan;
	}

	public List<ItemPlanProduccionDTO> getItemspdp() {
		return itemspdp;
	}

	public void setItemspdp(List<ItemPlanProduccionDTO> itemspdp) {
		this.itemspdp = itemspdp;
	}

	public double getAvance() {
		return avance;
	}

	public void setAvance(double avance) {
		this.avance = avance;
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



	public Date getFechaplan() {
		return fechaplan;
	}

	public void setFechaplan(Date fechaplan) {
		this.fechaplan = fechaplan;
	}

	@Override
	public String toString() {
		return "PlanDeProduccionDTO [codigoPDP=" + codigoPDP + ", estado=" + estado + "]";
	}
	
 
	
}
