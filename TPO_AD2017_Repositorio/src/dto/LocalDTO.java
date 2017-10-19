package dto;

import java.io.Serializable;

public class LocalDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2178847006516954658L;
	private Integer codigoLocal;
	private String direccion;
	private String barrio;
	
	public LocalDTO(){}

	public LocalDTO(Integer codigoLocal, String direccion, String barrio) {
		super();
		this.codigoLocal = codigoLocal;
		this.direccion = direccion;
		this.barrio = barrio;
	}

	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	@Override
	public String toString() {
		return "LocalDTO [codigoLocal=" + codigoLocal + ", direccion=" + direccion + ", barrio=" + barrio + "]";
	}
	
	
}
