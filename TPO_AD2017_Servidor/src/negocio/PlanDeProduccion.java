package negocio;

import entities.*;
import entities.PlanDeProduccionEntity;
import enumns.Estado;

public class PlanDeProduccion 
{
	private Integer codigoPDP;
	private Estado estado;
	private Administracion administracion;
	
	public PlanDeProduccion(){}
	
	public PlanDeProduccion(Estado estado) {
		super();
		
		this.estado = estado;
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

	public Administracion getAdministracion() {
		return administracion;
	}

	public void setAdministracion(Administracion administracion) {
		this.administracion = administracion;
	}
	
	public PlanDeProduccionEntity toEntity() {
		PlanDeProduccionEntity plan=new PlanDeProduccionEntity(this.estado);
		return plan;
	}
	
}
