package entities;

import javax.persistence.*;

import negocio.Plato;


@Entity
@Table(name="itemcomanda")
public class ItemComandaEntity {
	@Id
	private Integer codItemComanda;
	@OneToOne
	@JoinColumn(name="codPlato")
	private Plato plato;
	private Integer cantidad;
	
	public ItemComandaEntity(){
		
	}
	
	public ItemComandaEntity(Integer codItemComanda, Plato plato, Integer cantidad) {
		super();
		this.codItemComanda = codItemComanda;
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
