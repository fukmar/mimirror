package entities;

import java.util.List;

import javax.persistence.*;

import negocio.Factura;
import negocio.ItemComanda;
import negocio.Mesa;
import negocio.Mozo;
import entities.FacturaEntity;


@Entity
@Table(name="comandas")
public class ComandaEntity {
	
	@Id
	private Integer codComanda;
	@OneToOne
	@JoinColumn(name="dni")
	private MozoEntity mozo;
	@OneToOne
	@JoinColumn(name="codMesa")
	private MesaEntity mesa;
	@OneToMany
	@JoinColumn(name="codItemComanda")
	private List<ItemComandaEntity> itemsComandaEntity;
	

	
	public ComandaEntity(Integer codComanda, MozoEntity mozo, MesaEntity mesa,
			List<ItemComandaEntity> itemsComandaEntity) {
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

	
	public MozoEntity getMozo() {
		return mozo;
	}

	public void setMozo(MozoEntity mozo) {
		this.mozo = mozo;
	}

	public MesaEntity getMesa() {
		return mesa;
	}

	public void setMesa(MesaEntity mesa) {
		this.mesa = mesa;
	}

	public List<ItemComandaEntity> getItemsComandaEntity() {
		return itemsComandaEntity;
	}

	public void setItemsComandaEntity(List<ItemComandaEntity> itemsComandaEntity) {
		this.itemsComandaEntity = itemsComandaEntity;
	}



}