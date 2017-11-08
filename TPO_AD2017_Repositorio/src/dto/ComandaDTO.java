package dto;

import java.io.Serializable;



public class ComandaDTO implements Serializable
{
	private static final long serialVersionUID = -4258073980581482034L;
	private Integer codComanda;
	
	private MozoDTO mozo;
	private MesaDTO mesa;
	
	public ComandaDTO(){}
	
	

	public ComandaDTO(Integer codComanda, MozoDTO mozo, MesaDTO mesa) {
		super();
		this.codComanda = codComanda;
		this.mozo = mozo;
		this.mesa = mesa;
	}



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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "ComandaDTO [codComanda=" + codComanda + ", mozo=" + mozo + ", mesa=" + mesa + "]";
	}
	
	

}
