package dto;

import java.io.Serializable;



//import negocio.Unidad;

public class UnidadDTO implements Serializable
{
	private Integer codigoUni;
	private String descripcion;
	
	public UnidadDTO() {}
	
	public UnidadDTO(String descripcion) {
		super();
	
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigoUni;
	}
	public void setCodigo(Integer codigo) {
		this.codigoUni = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "UnidadDTO [codigoUni=" + codigoUni + ", descripcion=" + descripcion + "]";
	}

	
	
	
}
