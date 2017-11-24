package dto;

import java.io.Serializable;





public class ItemComandaDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer coditemComanda;
	private Integer cantidad;
	private PlatoDTO plato;
	private ComandaDTO comanda;
	
	
	public ItemComandaDTO()
	{	
	}


	public ItemComandaDTO(Integer cantidad, PlatoDTO plato,ComandaDTO comanda) {
		super();
		this.cantidad = cantidad;
		this.plato = plato;
		this.comanda=comanda;
	}

	public Integer getCoditemComanda() {
		return coditemComanda;
	}


	public void setCoditemComanda(Integer coditemComanda) {
		this.coditemComanda = coditemComanda;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public PlatoDTO getPlato() {
		return plato;
	}


	public void setPlato(PlatoDTO plato) {
		this.plato = plato;
	}


	public ComandaDTO getComanda() {
		return comanda;
	}


	public void setComanda(ComandaDTO comanda) {
		this.comanda = comanda;
	}


	@Override
	public String toString() {
		return "ItemComandaDTO [coditemComanda=" + coditemComanda + ", cantidad=" + cantidad + ", plato=" + plato
				+ ", comanda=" + comanda + "]";
	}

	
	
}
