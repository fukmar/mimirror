package negocio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import entities.ComandaEntity;
import entities.PlatoEntity;
import enumns.MedioDePago;

public class ItemComanda {

	private Integer coditemComanda;
	private Integer cantidad;
	private Plato plato;
	private Comanda comanda;
	
	
	public ItemComanda()
	{	
	}

	public ItemComanda(Integer cantidad, Plato plato,Comanda comanda) {
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

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
}
