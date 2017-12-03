package negocio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dao.SolicitudIndividualDAO;
import dto.*;
import entities.*;
import enumns.AreaRest;
import enumns.EstadoSolicitud;

public class SolicitudIndividual  {
 
	private static final long serialVersionUID = 1L;
	private Integer codsolicitudIndividual;
	protected AreaRest area;
	protected String responsable;
	//protected Integer lote;
	//protected Date fechaCompra;
	//protected Date fechaVencimiento;
	protected String motivo;
	private  MateriaPrima materiaprima;
	private float cantidad;
	//private SolicitudDiaria solicitudDiaria;
	private EstadoSolicitud estado;
	
	public SolicitudIndividual(){
		
	}
	
	public SolicitudIndividual(AreaRest area, String responsable,  String motivo, MateriaPrima materiaprima, float cantidad/*,
			SolicitudDiaria solicitudDiaria,*/,EstadoSolicitud estado) {
		super();
		this.area = area;
		this.estado=estado;
		this.responsable = responsable;
		this.motivo = motivo;
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		//this.solicitudDiaria = solicitudDiaria;
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

	/*public SolicitudDiaria getSolicitudDiaria() {
		return solicitudDiaria;
	}

	public void setSolicitudDiaria(SolicitudDiaria solicitudDiaria) {
		this.solicitudDiaria = solicitudDiaria;
	}*/

	public AreaRest getArea() {
		return area;
	}

	public void setArea(AreaRest area) {
		this.area = area;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
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
		s.setArea(area);
		s.setCantidad(cantidad);
		s.setCodsolicitudIndividual(codsolicitudIndividual);
		s.setMateriaprima(materiaprima.toEntity());
		s.setMotivo(motivo);
		s.setEstado(estado);
		s.setResponsable(responsable);
		return s;
	}
	
	public SolicitudIndividualDTO toDTO()
	{
		SolicitudIndividualDTO soli = new SolicitudIndividualDTO();
		soli.setArea(area);
		soli.setCantidad(cantidad);
		soli.setCodsolicitudIndividual(codsolicitudIndividual);
		soli.setEstado(estado);
		soli.setMateriaprima(materiaprima.toDTO());
		soli.setMotivo(motivo);
		soli.setResponsable(responsable);
	//	soli.setSolicitudDiaria(solicitudDiaria.toDTO());
		return soli;
	}

	public void save()
	{
		SolicitudIndividualDAO.getInstance().save(this);
		
	}
	
	
	
}
