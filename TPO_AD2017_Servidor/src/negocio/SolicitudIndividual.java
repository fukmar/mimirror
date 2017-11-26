package negocio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dto.*;
import entities.*;
import enumns.EstadoSolicitud;

public class SolicitudIndividual  {

	private static final long serialVersionUID = 1L;
	private Integer codsolicitudIndividual;
	protected AreaRestaurant area;
	protected String responsable;
	protected Integer lote;
	protected Date fechaCompra;
	protected Date fechaVencimiento;
	protected String motivo;
	private  MateriaPrima materiaprima;
	private float cantidad;
	private SolicitudDiaria solicitudDiaria;
	private EstadoSolicitud estado;
	
	public SolicitudIndividual(){
		
	}
	
	public SolicitudIndividual(AreaRestaurant area, String responsable, Integer lote,
			Date fechaCompra, Date fechaVencimiento, String motivo, MateriaPrima materiaprima, float cantidad,
			SolicitudDiaria solicitudDiaria,EstadoSolicitud estado) {
		super();
		this.area = area;
		this.estado=estado;
		this.responsable = responsable;
		this.lote = lote;
		this.fechaCompra = fechaCompra;
		this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.solicitudDiaria = solicitudDiaria;
	}

	public EstadoSolicitud getEstado() {
		return estado;
	}

	public void setEstado(EstadoSolicitud estado) {
		this.estado = estado;
	}

	public Integer getCodsolicitudIndividual() {
		return codsolicitudIndividual;
	}

	public void setCodsolicitudIndividual(Integer codsolicitudIndividual) {
		this.codsolicitudIndividual = codsolicitudIndividual;
	}

	public SolicitudDiaria getSolicitudDiaria() {
		return solicitudDiaria;
	}

	public void setSolicitudDiaria(SolicitudDiaria solicitudDiaria) {
		this.solicitudDiaria = solicitudDiaria;
	}

	public AreaRestaurant getArea() {
		return area;
	}

	public void setArea(AreaRestaurant area) {
		this.area = area;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public MateriaPrima getMateriaprima() {
		return materiaprima;
	}

	public void setMateriaprima(MateriaPrima materiaprima) {
		this.materiaprima = materiaprima;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SolicitudIndividualEntity toEntity() {
		SolicitudIndividualEntity s=new SolicitudIndividualEntity();
		s.setArea(area.toEntity());
		s.setCantidad(cantidad);
		s.setCodsolicitudIndividual(codsolicitudIndividual);
		s.setFechaCompra(fechaCompra);
		s.setFechaVencimiento(fechaVencimiento);
		s.setLote(lote);
		s.setMateriaprima(materiaprima.toEntity());
		s.setMotivo(motivo);
		s.setEstado(estado);
		s.setResponsable(responsable);
		return s;
	}
	
	public SolicitudIndividualDTO toDTO() {
		SolicitudIndividualDTO soli =new SolicitudIndividualDTO(this.area.toDTO(), this.responsable, this.lote, this.fechaCompra, this.fechaVencimiento, this.motivo, this.materiaprima.toDTO(), this.cantidad, this.solicitudDiaria.toDTO(), this.estado);
		return soli;
	}
	
	
	
}
