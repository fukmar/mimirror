package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import dao.ItemRemitoDAO;
import dao.RemitoDAO;
import dto.*;
import dto.SolicitudIndividualDTO;
import entities.ItemRemitoEntity;
import entities.MateriaPrimaEntity;
import entities.RemitoEntity;
import entities.SolicitudIndividualEntity;
import enumns.EstadoRemito;

public class ItemRemito {

	private Integer codItemRemito;
	private MateriaPrima materiaprima;
	private Float cantidad;
	private EstadoRemito estadoremito;
    private Remito remito;

	public ItemRemito() {
		super();
	}
	
	
	public ItemRemito(Integer codItemRemito, MateriaPrima materiaprima, Float cantidad,
			EstadoRemito estadoremito, Remito remito) {
		super();
		this.codItemRemito = codItemRemito;
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.estadoremito = estadoremito;
		this.remito = remito;
	}


	public ItemRemito(MateriaPrima materiaprima, Float cantidad, EstadoRemito estadoremito, Remito remito) {
		super();
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.estadoremito = estadoremito;
		this.remito = remito;
		
	}

	
	public Integer getCodItemRemito() {
		return codItemRemito;
	}


	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}


	public MateriaPrima getMateriaprima() {
		return materiaprima;
	}


	public void setMateriaprima(MateriaPrima materiaprima) {
		this.materiaprima = materiaprima;
	}


	public Float getCantidad() {
		return cantidad;
	}


	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}


	public EstadoRemito getEstadoremito() {
		return estadoremito;
	}


	public void setEstadoremito(EstadoRemito estadoremito) {
		this.estadoremito = estadoremito;
	}


	public Remito getRemito() {
		return remito;
	}


	public void setRemito(Remito remito) {
		this.remito = remito;
	}




	public ItemRemitoEntity toEntity() {
		ItemRemitoEntity item=new ItemRemitoEntity();
		item.setCodItemRemito(codItemRemito);
		item.setCantidad(cantidad);
		item.setEstadoremito(estadoremito);
		item.setMateriaprima(materiaprima.toEntity());
		item.setRemito(remito.toEntity());
		return item;
		
	}


	public ItemRemitoDTO toDTO() {
		ItemRemitoDTO itemDTO= new ItemRemitoDTO();
		itemDTO.setCantidad(cantidad);
		itemDTO.setMateriaprima(materiaprima.toDTO());
		itemDTO.setCodItemRemito(codItemRemito);
		itemDTO.setRemito(remito.toDTO());
		// TODO Auto-generated method stub
		return null;
	}


	public void save() 
	{
		ItemRemitoDAO.getInstance().save(this);
		
	}
	
	
	
}
