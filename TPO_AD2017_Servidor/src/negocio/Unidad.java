package negocio;

import dto.UnidadDTO;
import entities.UnidadEntity;

public class Unidad 
{
	private Integer codigoUni;
	private String descripcion;

	public Unidad(){}

	public Unidad(Integer codigo, String descripcion) {
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

	public UnidadEntity toEntity() {
		UnidadEntity u=new UnidadEntity();
		u.setCodigo(codigoUni);
		u.setDescripcion(descripcion);
		return u;
	}

	public UnidadDTO toDTO() 
	{
		UnidadDTO u=new UnidadDTO();
		u.setCodigo(codigoUni);
		u.setDescripcion(descripcion);
		return u;
	}

}
