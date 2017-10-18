package entities;

import java.util.List;

import javax.persistence.*;

import negocio.ItemComanda;
import negocio.Mesa;
import negocio.Mozo;

@Entity
@Table(name="comandas")
public class ComandaEntity {
	
	@Id
	private Integer codComanda;
	private Mozo mozo;
	private Mesa mesa;
	@OneToMany
	@JoinColumn(name="codItemComanda")
	private List<ItemComandaEntity> itemsComandaEntity;
	
	public ComandaEntity(Integer codComanda, Mozo mozo, Mesa mesa, List<ItemComandaEntity> itemsComandaEntity) {
		super();
		this.codComanda = codComanda;
		this.mozo = mozo;
		this.mesa = mesa;
		this.itemsComandaEntity = itemsComandaEntity;
	}
	
	public ComandaEntity(){}

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

	public List<ItemComandaEntity> getItemsComandaEntity() {
		return itemsComandaEntity;
	}

	public void setItemsComandaEntity(List<ItemComandaEntity> itemsComandaEntity) {
		this.itemsComandaEntity = itemsComandaEntity;
	}



}