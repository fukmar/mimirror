package entities;

import java.io.Serializable;

import javax.persistence.*;

import negocio.Plato;


@Entity
@Table(name="itemcomanda")

public class ItemComandaEntity 
{
	//@EmbeddedId
	//private ItemComandaId id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer coditemComanda;
	private Integer cantidad;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private PlatoEntity plato;
	
	public ItemComandaEntity()
	{
		
	}

	public ItemComandaEntity(Integer coditemComanda, Integer cantidad, PlatoEntity plato) {
		super();
		this.coditemComanda = coditemComanda;
		this.cantidad = cantidad;
		this.plato = plato;
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

	public PlatoEntity getPlato() {
		return plato;
	}

	public void setPlato(PlatoEntity plato) {
		this.plato = plato;
	}
	
	
	
}
