package dto;

import java.io.Serializable;



//import negocio.Unidad;

public class UnidadDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -997895407044949042L;
	private Integer codigoUni;
	private String descripcion;

	public UnidadDTO(){}

	public UnidadDTO(Integer codigo, String descripcion) {
		super();
		this.codigoUni = codigo;
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
		return "UnidadDTO [codigo=" + codigoUni + ", descripcion=" + descripcion + "]";
	}

	

	/*public Unidad toNegocio() {
		Unidad u=new Unidad();
		u.setCodigo(codigo);
		u.setDescripcion(descripcion);
		return u;
	}*/
	
	
}
