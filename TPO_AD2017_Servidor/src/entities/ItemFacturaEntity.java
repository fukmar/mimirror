package entities;
import javax.persistence.*;

import negocio.Comanda;

@Entity
@Table(name="itemsfactura")
public class ItemFacturaEntity 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codItemFactura; 
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codItemComanda")
	private ItemComandaEntity itemcomanda; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codFactura")
	private FacturaEntity factura;
	
	
	public ItemFacturaEntity(ItemComandaEntity itemcomanda, FacturaEntity factura) {
		super();
		this.itemcomanda = itemcomanda;
		this.factura=factura;
	}



	public Integer getCodItemFactura() {
		return codItemFactura;
	}

	public void setCodItemFactura(Integer codItemFactura) {
		this.codItemFactura = codItemFactura;
	}



	public ItemComandaEntity getItemcomanda() {
		return itemcomanda;
	}

	public void setItemcomanda(ItemComandaEntity itemcomanda) {
		this.itemcomanda = itemcomanda;
	}



	public FacturaEntity getFactura() {
		return factura;
	}



	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	
	
	
	
}
