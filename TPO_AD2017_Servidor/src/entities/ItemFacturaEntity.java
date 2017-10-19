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
	private ComandaEntity comanda;
	
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

	
	
}
