package negocio;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


public class ItemFactura 
{
	private Integer codItemFactura; 
	private ItemComanda itemcomanda; 
	private Factura factura;
	private double subtotal;
	
	public ItemFactura() {
		super();
	}
	


	public ItemFactura(ItemComanda itemcomanda, Factura factura) {
		super();
		this.itemcomanda = itemcomanda;
		this.factura=factura;
	}


	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}



	public Integer getCodItemFactura() {
		return codItemFactura;
	}

	public void setCodItemFactura(Integer codItemFactura) {
		this.codItemFactura = codItemFactura;
	}



	public ItemComanda getItemcomanda() {
		return itemcomanda;
	}

	public void setItemcomanda(ItemComanda itemcomanda) {
		this.itemcomanda = itemcomanda;
	}



	public Factura getFactura() {
		return factura;
	}



	public void setFactura(Factura factura) {
		this.factura = factura;
	}
}
