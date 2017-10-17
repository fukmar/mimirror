package negocio;

import enumns.Estado;

public class PlanDeProduccion 
{
	private Integer codigoPDP;
	private Estado estado;
	
	public PlanDeProduccion(){}
	
	public PlanDeProduccion(Integer codigoPDP, Estado estado) {
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
}
