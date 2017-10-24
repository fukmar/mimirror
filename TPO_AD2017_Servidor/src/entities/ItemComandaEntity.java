package entities;

import javax.persistence.*;

import negocio.Plato;


@Entity
@Table(name="itemcomanda")
public class ItemComandaEntity {
	@EmbeddedId
	private ItemComandaId id;
	private Integer cantidad;
	
	public ItemComandaEntity(){
		
	}
	

	public ItemComandaEntity(ItemComandaId id, Integer cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}


	public ItemComandaId getId() {
		return id;
	}


	public void setId(ItemComandaId id) {
		this.id = id;
	}


	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
}
