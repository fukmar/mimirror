package dto;

import java.io.Serializable;
import java.util.Date;



public abstract class ProductoDTO implements Serializable
{
	
	private Integer codigoProd;
	protected String tipo;
	protected String calidad;
	protected String descripcion;
	

	
	protected Integer cantidad;
	protected Date caducidad;
	
	public ProductoDTO(){}
	
	


	public ProductoDTO(String tipo, String calidad, String descripcion,
			Integer cantidad, Date caducidad) {
		super();
		
		this.tipo = tipo;
		this.calidad = calidad;
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "ProductoDTO [numero=" + codigoProd + ", tipo=" + tipo + ", calidad=" + calidad + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + ", caducidad=" + caducidad + "]";
	}



	
	
	
}
