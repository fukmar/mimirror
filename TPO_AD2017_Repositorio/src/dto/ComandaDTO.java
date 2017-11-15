package dto;

import java.io.Serializable;

import enumns.Estado;



public class ComandaDTO implements Serializable
{
	private static final long serialVersionUID = -4258073980581482034L;
	private Integer codComanda;

	private Estado estado;
	private MozoDTO mozo;
	private MesaDTO mesa;
	private CajaDTO caja;
	
	public ComandaDTO(MozoDTO mozo, MesaDTO mesa,CajaDTO caja,Estado estado) {
		super();
		this.mozo = mozo;
		this.mesa = mesa;
		this.caja=caja;
		this.estado=estado;
	}

	public ComandaDTO(){}

	public Integer getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(Integer codComanda) {
		this.codComanda = codComanda;
	}

	
	public MozoDTO getMozo() {
		return mozo;
	}

	public void setMozo(MozoDTO mozo) {
		this.mozo = mozo;
	}

	public MesaDTO getMesa() {
		return mesa;
	}

	public void setMesa(MesaDTO mesa) {
		this.mesa = mesa;
	}

	public CajaDTO getCaja() {
		return caja;
	}

	public void setCaja(CajaDTO caja) {
		this.caja = caja;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

}
