package entities;

import java.io.Serializable;

import javax.persistence.*;

import enumns.EstadoItemComanda;
import negocio.ItemComanda;
import negocio.Plato;


@Entity
@Table(name="itemcomanda")

public class ItemComandaEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer coditemComanda;
	private Integer cantidad;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codPlato")
	private PlatoEntity plato;
	private EstadoItemComanda estado;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codComanda")
	private ComandaEntity comanda;
	
	
	public ItemComandaEntity()
	{	
	}

	public ItemComandaEntity(Integer cantidad,EstadoItemComanda estado, PlatoEntity plato,ComandaEntity comanda) {
		super();
		this.cantidad = cantidad;
		this.estado=estado;
		this.plato = plato;
		this.comanda=comanda;
	}

	
	public EstadoItemComanda getEstado() {
		return estado;
	}

	public void setEstado(EstadoItemComanda estado) {
		this.estado = estado;
	}

	public ComandaEntity getComanda() {
		return comanda;
	}

	public void setComanda(ComandaEntity comanda) {
		this.comanda = comanda;
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
	
	public ItemComanda toNegocio() 
	{
		ItemComanda i=new ItemComanda();
		i.setCoditemComanda(coditemComanda);
		i.setPlato(plato.toNegocio());
		i.setCantidad(cantidad);
		i.setEstado(estado);
		return i;
	}
	
}
