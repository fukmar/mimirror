package negocio;

import java.util.*;
//FALTAN METODOS DE NEGOCIO

import entities.SolicitudIndividualEntity;
import entities.SolicitudInsumoEntity;


public abstract class SolicitudInsumo {
	
	protected Integer cantidadAPedir;
	protected MateriaPrima materiaPrima; 
	protected AreaRestaurant area;
	protected String responsable;
	protected Integer lote;
	protected Date fechaCompra;
	protected Date fechaVencimiento;
	protected String motivo;
	protected Deposito deposito;

    public SolicitudInsumo(){
	}
	
	

	public SolicitudInsumo(Integer codSolicitudInsumo,Integer cantidadAPedir, MateriaPrima materiaPrima,
			AreaRestaurant area, String responsable, Integer lote, Date fechaCompra, Date fechaVencimiento,
			String motivo) {
		this.area = area;
		this.responsable = responsable;
		this.lote = lote;
		this.fechaCompra = fechaCompra;
		this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
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

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public abstract SolicitudInsumoEntity toEntity();

	
	
	
	
}
