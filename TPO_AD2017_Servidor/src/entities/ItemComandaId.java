package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import negocio.Plato;

@Embeddable
public class ItemComandaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column (name = "codigoComanda")
	private int codigoComanda;

	@ManyToOne (optional = false)
	@JoinColumn(name="codPlato")
	private Plato plato;
	
	public ItemComandaId(){
		
	}

	public int getCodigoComanda() {
		return codigoComanda;
	}

	public void setCodigoComanda(int codigoComanda) {
		this.codigoComanda = codigoComanda;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
