package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class SolicitudIndividualDTO  {

	private static final long serialVersionUID = 1L;
	private Integer codsolicitudIndividual;
	protected AreaRestaurantDTO area;
	protected String responsable;
	protected Integer lote;
	protected Date fechaCompra;
	protected Date fechaVencimiento;
	protected String motivo;
	private  MateriaPrimaDTO materiaprima;
	private float cantidad;
	private SolicitudDiariaDTO solicitudDiaria;
	
	public SolicitudIndividualDTO(){
		
	}
	
	
	public SolicitudIndividualDTO(AreaRestaurantDTO area, String responsable,
			Integer lote, Date fechaCompra, Date fechaVencimiento, String motivo, MateriaPrimaDTO materiaprima,
			float cantidad, SolicitudDiariaDTO solicitudDiaria) {
		super();
		this.area = area;
		this.responsable = responsable;
		this.lote = lote;
		this.fechaCompra = fechaCompra;
		this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.solicitudDiaria = solicitudDiaria;
	}


	public Integer getCodsolicitudIndividual() {
		return codsolicitudIndividual;
	}

	public void setCodsolicitudIndividual(Integer codsolicitudIndividual) {
		this.codsolicitudIndividual = codsolicitudIndividual;
	}


	public AreaRestaurantDTO getArea() {
		return area;
	}


	public void setArea(AreaRestaurantDTO area) {
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


	public MateriaPrimaDTO getMateriaprima() {
		return materiaprima;
	}


	public void setMateriaprima(MateriaPrimaDTO materiaprima) {
		this.materiaprima = materiaprima;
	}


	public float getCantidad() {
		return cantidad;
	}


	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


	public SolicitudDiariaDTO getSolicitudDiaria() {
		return solicitudDiaria;
	}


	public void setSolicitudDiaria(SolicitudDiariaDTO solicitudDiaria) {
		this.solicitudDiaria = solicitudDiaria;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SolicitudIndividualDTO [materiales=" + materiaprima + ", cantidad=" + cantidad + ", motivo=" + motivo + ", responsable=" + responsable + "]";
	//faltan cosas que mostrar pero sirve para probar
	}
	
	
	
	
}
