package dto;

import java.io.Serializable;


public class ItemFacturaDTO implements Serializable
{

	private static final long serialVersionUID = 244554154493402252L;
	private Integer codItemFactura; 
	private ItemComandaDTO itemcomanda; 
	private FacturaDTO factura;
	private double subtotal;
	


	public ItemFacturaDTO(ItemComandaDTO itemcomanda, FacturaDTO factura, double subtotal) {
		super();
		this.itemcomanda = itemcomanda;
		this.factura = factura;
		this.subtotal = subtotal;
	}



	public double getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	public ItemFacturaDTO() {
		super();
	}



	public Integer getCodItemFactura() {
		return codItemFactura;
	}

	public void setCodItemFactura(Integer codItemFactura) {
		this.codItemFactura = codItemFactura;
	}



	public ItemComandaDTO getItemcomanda() {
		return itemcomanda;
	}

	public void setItemcomanda(ItemComandaDTO itemcomanda) {
		this.itemcomanda = itemcomanda;
	}



	public FacturaDTO getFactura() {
		return factura;
	}



	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}



	@Override
	public String toString() {
		return "ItemFacturaDTO [codItemFactura=" + codItemFactura + ", itemcomanda=" + itemcomanda + ", factura="
				+ factura + "]";
	}


	
}
