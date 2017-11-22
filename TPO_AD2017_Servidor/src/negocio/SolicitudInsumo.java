package negocio;

import java.util.*;
//FALTAN METODOS DE NEGOCIO

import entities.SolicitudInsumoEntity;



public abstract class SolicitudInsumo {
	
	protected Integer codSolicitudInsumo;
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
	
		this.cantidadAPedir = cantidadAPedir;
		this.materiaPrima = materiaPrima;
		this.area = area;
		this.responsable = responsable;
		this.lote = lote;
		this.fechaCompra = fechaCompra;
		this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
		this.codSolicitudInsumo=codSolicitudInsumo;
	}



	public Integer getCodSolicitudInsumo() {
		return codSolicitudInsumo;
	}

	public void setCodSolicitudInsumo(Integer codSolicitudInsumo) {
		this.codSolicitudInsumo = codSolicitudInsumo;
	}

	public Integer getCantidadAPedir() {
		return cantidadAPedir;
	}

	public void setCantidadAPedir(Integer cantidadAPedir) {
		this.cantidadAPedir = cantidadAPedir;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
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
