package negocio;

import java.util.Date;
import java.util.List;

import enumns.MedioDePago;

public class ItemComanda {

	private Integer codItemComanda;
	private Plato plato;
	private Integer cantidad;
	
	public ItemComanda(){
		
	}
	
	public ItemComanda(Plato plato, Integer cantidad) {
		super();

		this.plato = plato;
		this.cantidad = cantidad;
	}
	
	public Integer getCodItemComanda() {
		return codItemComanda;
	}
	public void setCodItemComanda(Integer codItemComanda) {
		this.codItemComanda = codItemComanda;
	}
	public Plato getPlato() {
		return plato;
	}
	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
}
