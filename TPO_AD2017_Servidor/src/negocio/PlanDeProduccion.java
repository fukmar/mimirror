package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import dao.PlanDeProduccionDAO;
import dto.ItemPlanProduccionDTO;
import dto.PlanDeProduccionDTO;
import entities.*;
import enumns.Estado;

public class PlanDeProduccion 
{
	private Integer codigoPDP;
	private Estado estado;
	private List<ItemPlanProduccion> itemspdp;
	private Date fechaplan;
	private double avance;
	
	public PlanDeProduccion(){}
	
	public PlanDeProduccion(Estado estado) {
		super();
		
		this.estado = estado;
	}
	
	public PlanDeProduccion(Estado estado, List<ItemPlanProduccion> itemspdp,
			Date fechaplan) {
		super();
		this.estado = estado;
		this.itemspdp = itemspdp;
		this.fechaplan = fechaplan;
	}

	public Date getFechaplan() {
		return fechaplan;
	}

	public void setFechaplan(Date fechaplan) {
		this.fechaplan = fechaplan;
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

	public double getAvance() {
		return avance;
	}

	public void setAvance(double avance) {
		this.avance = avance;
	}


	
	public List<ItemPlanProduccion> getItemspdp() {
		return itemspdp;
	}

	public void setItemspdp(List<ItemPlanProduccion> itemspdp) {
		this.itemspdp = itemspdp;
	}

	public PlanDeProduccionEntity toEntity() {
		PlanDeProduccionEntity plan=new PlanDeProduccionEntity();
		List <ItemPlanProduccionEntity> planesentity= new ArrayList <ItemPlanProduccionEntity>();
		for (ItemPlanProduccion itemplan:itemspdp)
		{
			planesentity.add(itemplan.toEntity());
		}
		plan.setItemspdp(planesentity);
		plan.setCodigoPDP(codigoPDP);
		plan.setEstado(estado);
		plan.setFechaplan(fechaplan);
		plan.setAvance(avance);
		return plan;
	}
	public PlanDeProduccionDTO toDTO() {
		PlanDeProduccionDTO plandto=new PlanDeProduccionDTO();
		plandto.setCodigoPDP(codigoPDP);
		plandto.setEstado(estado);
		plandto.setFechaplan(fechaplan);
		List <ItemPlanProduccionDTO> planesdto= new ArrayList <ItemPlanProduccionDTO>();
		for (ItemPlanProduccion itemplan:itemspdp)
		{
			planesdto.add(itemplan.toDTO());
		}
		plandto.setItemspdp(planesdto);
		plandto.setAvance(avance);
		return plandto;
	}

	public void save() {
		PlanDeProduccionDAO.getInstance().save(this);
		
	}
	
	public PlanDeProduccion getPlanPorCod(Integer codigo) {
		PlanDeProduccion plan=PlanDeProduccionDAO.getInstance().getPlanByCod(codigo);
		return plan;
	}
	
	
}
