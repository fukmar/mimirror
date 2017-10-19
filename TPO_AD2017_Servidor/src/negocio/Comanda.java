package negocio;

import java.util.List;

public class Comanda {
	
	private Integer codComanda;
	private Mozo mozo;
	private Mesa mesa;
	private List<ItemComanda> itemsComanda;
	
	public Comanda(Integer codComanda, Mozo mozo, Mesa mesa, List<ItemComanda> itemsComanda) {
		super();
		this.codComanda = codComanda;
		this.mozo = mozo;
		this.mesa = mesa;
		this.itemsComanda = itemsComanda;
	}
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Comanda(Integer codComanda, Mozo mozo, Mesa mesa, Factura factura, List<ItemComanda> itemsComanda) {
		super();
		this.codComanda = codComanda;
		this.mozo = mozo;
		this.mesa = mesa;
		this.factura = factura;
		this.itemsComanda = itemsComanda;
	}

	public Comanda(){}

	public Integer getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(Integer codComanda) {
		this.codComanda = codComanda;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public List<ItemComanda> getItemsComanda() {
		return itemsComanda;
	}

	public void setItemsComanda(List<ItemComanda> itemsComanda) {
		this.itemsComanda = itemsComanda;
	}
	
	
}
