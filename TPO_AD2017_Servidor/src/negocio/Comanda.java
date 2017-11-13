package negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import entities.CajaEntity;
import entities.ComandaEntity;
import entities.MesaEntity;
import entities.MozoEntity;
import enumns.Estado;

public class Comanda 
{
	
	private Integer codComanda;
	private Estado estado;
	private Mozo mozo;
	private Mesa mesa;
	private Caja caja;
	
	public Comanda(Mozo mozo, Mesa mesa,Caja caja,Estado estado) {
		super();
		this.mozo = mozo;
		this.mesa = mesa;
		this.caja=caja;
		this.estado=estado;
	}

	public Comanda(){}

	public Integer getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(Integer codComanda) {
		this.codComanda = codComanda;
	}

	
	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public ComandaEntity toEntity() 
	{
		ComandaEntity c=new ComandaEntity();
		c.setCodComanda(codComanda);
		c.setEstado(estado);
		c.setCaja(caja.toNegocio());
		//c.setMesa(mesa.toNegocio());
		//c.setMesa(mesa.toNegocio());
		return c;
	}
	
	
}
