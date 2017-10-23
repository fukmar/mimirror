package dto;

import java.io.Serializable;
import java.util.Date;


public abstract class SolicitudInsumoDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8544151372636600303L;
	
	
	protected Integer codigoArt;
	protected Integer cantidad;
	protected AreaRestaurantDTO area;
	protected String responsable;
	protected Integer lote;
	protected Date fechaCompra;
	protected Date fechaVencimiento;
	protected String motivo;
	
	public SolicitudInsumoDTO(){
		
	}

	public SolicitudInsumoDTO(Integer codigoArt, Integer cantidad,
			AreaRestaurantDTO area, String responsable, Integer lote,
			Date fechaCompra, Date fechaVencimiento, String motivo) {
		super();
		this.codigoArt = codigoArt;
		this.cantidad = cantidad;
		this.area = area;
		this.responsable = responsable;
		this.lote = lote;
		this.fechaCompra = fechaCompra;
		this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
	}

	public Integer getCodigoArt() {
		return codigoArt;
	}

	public void setCodigoArt(Integer codigoArt) {
		this.codigoArt = codigoArt;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
	
	
	
}
