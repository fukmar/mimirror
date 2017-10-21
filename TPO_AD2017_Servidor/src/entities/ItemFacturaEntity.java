package entities;
import javax.persistence.*;

import negocio.Comanda;

@Entity
@Table(name="itemsfactura")
public class ItemFacturaEntity {
	@Id
	private Integer codItemFactura; 
	@OneToOne
	@JoinColumn(name="codComanda")
	private ComandaEntity comanda;  //segun diagrama de clases item factura se relaciona con itemcomanda.  Me parece más logico que relacionarlo con toda la comanda. 
	@OneToOne
	@JoinColumn(name="codItemComanda")
	private ItemComandaEntity itemcomanda; //añadiendo esto obtendríamos la cantidad y el plato para despues hacer el subtotal
	
	public ItemFacturaEntity(Integer codItemFactura, ComandaEntity comanda, ItemComandaEntity itemcomanda) {
		super();
		this.codItemFactura = codItemFactura;
		this.comanda = comanda;
		this.itemcomanda = itemcomanda;
	}

	public ItemFacturaEntity(Integer codItemFactura, ComandaEntity comanda) {
		super();
		this.codItemFactura = codItemFactura;
		this.comanda = comanda;
	}

	public Integer getCodItemFactura() {
		return codItemFactura;
	}

	public void setCodItemFactura(Integer codItemFactura) {
		this.codItemFactura = codItemFactura;
	}

	public ComandaEntity getComanda() {
		return comanda;
	}

	public void setComanda(ComandaEntity comanda) {
		this.comanda = comanda;
	}

	public ItemComandaEntity getItemcomanda() {
		return itemcomanda;
	}

	public void setItemcomanda(ItemComandaEntity itemcomanda) {
		this.itemcomanda = itemcomanda;
	}

	
	
}
