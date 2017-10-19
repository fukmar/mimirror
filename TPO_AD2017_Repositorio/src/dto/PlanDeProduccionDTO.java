package dto;

import java.io.Serializable;

import enumns.Estado;

public class PlanDeProduccionDTO implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8360988089299212763L;
	private Integer codigoPDP;
	private Estado estado;
	
	public PlanDeProduccionDTO(){}
	
	public PlanDeProduccionDTO(Integer codigoPDP, Estado estado) {
		super();
		this.codigoPDP = codigoPDP;
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

	@Override
	public String toString() {
		return "PlanDeProduccionDTO [codigoPDP=" + codigoPDP + ", estado=" + estado + "]";
	}

	
}
