package dto;

import java.io.Serializable;

import enumns.Estado;


public class PlanDeProduccionDTO implements Serializable
{
	private Integer codigoPDP;
	private Estado estado;
	private AdministracionDTO administracion;
	
	public PlanDeProduccionDTO(){}
	
	public PlanDeProduccionDTO(Estado estado) {
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

	public AdministracionDTO getAdministracion() {
		return administracion;
	}

	public void setAdministracion(AdministracionDTO administracion) {
		this.administracion = administracion;
	}

	@Override
	public String toString() {
		return "PlanDeProduccionDTO [codigoPDP=" + codigoPDP + ", estado=" + estado + ", administracion="
				+ administracion + "]";
	}
	
 
	
}
