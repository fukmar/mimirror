package negocio;

import dto.UnidadDTO;
import entities.UnidadEntity;

public class Unidad 
{
	private Integer codigo;
	private String descripcion;

	public Unidad(){}

	public Unidad(Integer codigo, String descripcion) {
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

	public UnidadEntity toEntity() {
		UnidadEntity u=new UnidadEntity();
		u.setCodigo(codigo);
		u.setDescripcion(descripcion);
		return u;
	}

	public UnidadDTO toDTO() 
	{
		UnidadDTO u=new UnidadDTO();
		u.setCodigo(codigo);
		u.setDescripcion(descripcion);
		return u;
	}

}
