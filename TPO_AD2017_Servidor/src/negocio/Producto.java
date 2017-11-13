package negocio;

import java.util.Date;



public abstract class Producto
{
private Integer codigoProd;
	
	protected String tipo;
	protected String calidad;
	protected String descripcion;
	protected PlanDeProduccion pdp;
	protected Integer cantidad;
	protected Date caducidad;
	
	public Producto(){}
	
	


	public Producto(String tipo, String calidad, String descripcion, PlanDeProduccion pdp,
			Integer cantidad, Date caducidad) {
		super();
		
		this.tipo = tipo;
		this.calidad = calidad;
		this.descripcion = descripcion;
		this.pdp = pdp;
		this.cantidad = cantidad;
		this.caducidad = caducidad;
	}


	public Integer getNumero() {
		return codigoProd;
	}
	public void setNumero(Integer numero) {
		this.codigoProd = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getCalidad() {
		return calidad;
	}




	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}




	public PlanDeProduccion getPdp() {
		return pdp;
	}




	public void setPdp(PlanDeProduccion pdp) {
		this.pdp = pdp;
	}




	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	public Date getCaducidad() {
		return caducidad;
	}




	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
}
