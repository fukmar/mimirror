package dto;

import java.io.Serializable;



//import negocio.Unidad;

public class UnidadDTO implements Serializable{

	private Integer codigo;
	private String descripcion;

	public UnidadDTO(){}

	public UnidadDTO(Integer codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "UnidadDTO [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	

	/*public Unidad toNegocio() {
		Unidad u=new Unidad();
		u.setCodigo(codigo);
		u.setDescripcion(descripcion);
		return u;
	}*/
	
	
}
