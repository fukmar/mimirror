package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReservaDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codReserva;
	private String nombre;
	private Date fechayHora;
	private Integer cantidadComensales;
	
	public ReservaDTO() {}
	
	public ReservaDTO(String nombre, Date fechayHora, Integer cantidad) {
		super();
		this.nombre = nombre;
		this.fechayHora = fechayHora;
		this.cantidadComensales = cantidad;
	}

	public Integer getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(Integer codReserva) {
		this.codReserva = codReserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechayHora() {
		return fechayHora;
	}

	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
	}
	
	public Integer getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(Integer cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}


	@Override
	public String toString() {
		return "ReservaDTO [codReserva=" + codReserva + ", nombre=" + nombre + ", fechayHora=" + fechayHora + "]";
	}

	
}
