package entities;

import java.util.Date;

import javax.persistence.*;

import enumns.AreaRest;
import enumns.EstadoSolicitud;
import negocio.SolicitudIndividual;

@Entity
@Table(name="solicitudIndividual")
public class SolicitudIndividualEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="codsolicitudIndividual")
	private Integer codsolicitudIndividual;
	
    private AreaRest area;
    private EstadoSolicitud estado;
	protected String responsable;
	//protected Integer lote;
	//protected Date fechaCompra;
	//protected Date fechaVencimiento;
	protected String motivo;
	@OneToOne
	@JoinColumn(name="codigo")
	private  MateriaPrimaEntity materiaprima;
	private float cantidad;


	public SolicitudIndividualEntity(AreaRest area, String responsable,
		 String motivo, MateriaPrimaEntity materiaprima, float cantidad, EstadoSolicitud estado) {
		super();
		this.area = area;
		this.estado=estado;
		this.responsable = responsable;
		//this.lote = lote;
		//this.fechaCompra = fechaCompra;
		//this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
	}



	public SolicitudIndividualEntity() {
	}



	public EstadoSolicitud getEstado() {
		return estado;
	}



	public void setEstado(EstadoSolicitud estado) {
		this.estado = estado;
	}



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



	public Integer getCodsolicitudIndividual() {
		return codsolicitudIndividual;
	}



	public void setCodsolicitudIndividual(Integer codsolicitudIndividual) {
		this.codsolicitudIndividual = codsolicitudIndividual;
	}





	public String getMotivo() {
		return motivo;
	}



	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



	public MateriaPrimaEntity getMateriaprima() {
		return materiaprima;
	}



	public void setMateriaprima(MateriaPrimaEntity materiaprima) {
		this.materiaprima = materiaprima;
	}



	public float getCantidad() {
		return cantidad;
	}



	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}



	public SolicitudIndividual toNegocio() {
		SolicitudIndividual s=new SolicitudIndividual();
		s.setArea(area);
		s.setCantidad(cantidad);
		s.setCodsolicitudIndividual(codsolicitudIndividual);
		s.setMateriaprima(materiaprima.toNegocio());
		s.setMotivo(motivo);
		s.setResponsable(responsable);
		s.setEstado(estado);
		return s;
	}
	
	
}
