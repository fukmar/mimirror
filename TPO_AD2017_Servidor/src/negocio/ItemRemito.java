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

import dto.*;
import dto.SolicitudIndividualDTO;
import entities.ItemRemitoEntity;
import entities.MateriaPrimaEntity;
import entities.RemitoEntity;
import entities.SolicitudIndividualEntity;
import enumns.EstadoItemRemito;

public class ItemRemito {

	private Integer codItemRemito;
	private MateriaPrima materiaprima;
	private Float cantidad;
	private EstadoItemRemito estadoremito;
    private Remito remito;
	private List<SolicitudIndividual> solicitudes;

	public ItemRemito() {
		super();
	}
	
	
	public ItemRemito(Integer codItemRemito, MateriaPrima materiaprima, Float cantidad,
			EstadoItemRemito estadoremito, Remito remito, List<SolicitudIndividual> solicitudes) {
		super();
		this.codItemRemito = codItemRemito;
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.estadoremito = estadoremito;
		this.remito = remito;
		this.solicitudes = solicitudes;
	}
	


	public ItemRemito(MateriaPrima materiaprima, Float cantidad, EstadoItemRemito estadoremito, Remito remito,
			List<SolicitudIndividual> solicitudes) {
		super();
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.estadoremito = estadoremito;
		this.remito = remito;
		this.solicitudes = solicitudes;
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


	public EstadoItemRemito getEstadoremito() {
		return estadoremito;
	}


	public void setEstadoremito(EstadoItemRemito estadoremito) {
		this.estadoremito = estadoremito;
	}


	public Remito getRemito() {
		return remito;
	}


	public void setRemito(Remito remito) {
		this.remito = remito;
	}


	public List<SolicitudIndividual> getSolicitudes() {
		return solicitudes;
	}


	public void setSolicitudes(List<SolicitudIndividual> solicitudes) {
		this.solicitudes = solicitudes;
	}


	public ItemRemitoEntity toEntity() {
		ItemRemitoEntity item=new ItemRemitoEntity();
		item.setCodItemRemito(codItemRemito);
		item.setCantidad(cantidad);
		item.setEstadoremito(estadoremito);
		item.setMateriaprima(materiaprima.toEntity());
		item.setRemito(remito.toEntity());
		List<SolicitudIndividualEntity> solicitudesentity=new ArrayList <SolicitudIndividualEntity>();
		for(SolicitudIndividual s:solicitudes)
		{
			solicitudesentity.add(s.toEntity());
		}
		item.setSolicitudes(solicitudesentity);
		return item;
		
	}


	public ItemRemitoDTO toDTO() {
		List<SolicitudIndividualDTO> solis= new ArrayList<SolicitudIndividualDTO>();
		for(SolicitudIndividual solComun : this.solicitudes) {
			solis.add(solComun.toDTO());
		}

		ItemRemitoDTO itemDTO= new ItemRemitoDTO(this.codItemRemito, Math.round(this.cantidad), this.estadoremito, this.materiaprima.toDTO(), solis);
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
