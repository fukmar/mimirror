package negocio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dao.ItemComandaDAO;
import dto.ItemComandaDTO;
import entities.ComandaEntity;
import entities.ItemComandaEntity;
import entities.PlatoEntity;
import enumns.EstadoItemComanda;
import enumns.MedioDePago;

public class ItemComanda {

	private Integer coditemComanda;
	private Integer cantidad;
	private Plato plato;
	private Comanda comanda;
	private EstadoItemComanda estado;
	
	public ItemComanda()
	{	
	}

	public ItemComanda(Integer cantidad, EstadoItemComanda estado,Plato plato,Comanda comanda) {
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

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
	
	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public void save() 
	{
		ItemComandaDAO.getInstance().save(this);
	}
	
	public ItemComandaEntity toEntity()
	{
		ItemComandaEntity i=new ItemComandaEntity();
		i.setCantidad(cantidad);
		i.setCoditemComanda(coditemComanda);
		i.setPlato(plato.toEntity());
		i.setEstado(estado);
		i.setComanda(comanda.toEntity());
		return i;
	}
	public ItemComandaDTO toDTO()
	{
		ItemComandaDTO i=new ItemComandaDTO();
		i.setCantidad(cantidad);
		i.setCoditemComanda(coditemComanda);
		i.setPlato(plato.toDTO());
		i.setEstado(estado);
		//i.setComanda(comanda.toDTO());
		return i;
	}
}

