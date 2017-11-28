package negocio;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dto.ItemFacturaDTO;
import entities.ItemFacturaEntity;


public class ItemFactura 
{
	private Integer codItemFactura; 
	private ItemComanda itemcomanda; 
	private Factura factura;
	private double subtotal;
	
	public ItemFactura() {
		super();
	}
	



	public ItemFactura(ItemComanda itemcomanda, Factura factura, double subtotal) {
		super();
		this.itemcomanda = itemcomanda;
		this.factura = factura;
		this.subtotal = subtotal;
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



	public void setFactura(Factura factura) {
		this.factura = factura;
	}



	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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



	public ItemFacturaEntity toEntity()
	{
		ItemFacturaEntity itement=new ItemFacturaEntity();
		
		itement.setCodItemFactura(codItemFactura);
		itement.setFactura(factura.toEntity());
		itement.setItemcomanda(itemcomanda.toEntity());
		itement.setSubtotal(subtotal);
		return itement;
	}
	
	public ItemFacturaDTO toDTO()
	{ 
		ItemFacturaDTO itemdto=new ItemFacturaDTO();
		itemdto.setCodItemFactura(codItemFactura);
		itemdto.setFactura(factura.toDTO());
		itemdto.setItemcomanda(itemcomanda.toDTO());
		itemdto.setSubtotal(subtotal);
		return itemdto;
	}
	
}
