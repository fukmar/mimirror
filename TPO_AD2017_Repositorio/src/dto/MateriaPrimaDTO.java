package dto;

import java.io.Serializable;

public class MateriaPrimaDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer codigoMP;
	private String descripcion;
	private UnidadDTO unidadUso;

	public MateriaPrimaDTO(){}

	public MateriaPrimaDTO(Integer codigo, String descripcion,UnidadDTO unidadUso) {
		super();
		this.codigoMP = codigo;
		this.descripcion = descripcion;
		this.unidadUso = unidadUso;
	}

	public Integer getCodigo() {
		return codigoMP;
	}

	public void setCodigo(Integer codigo) {
		this.codigoMP = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public UnidadDTO getUnidadUso() {
		return unidadUso;
	}

	public void setUnidadUso(UnidadDTO unidadUso) {
		this.unidadUso = unidadUso;
	}

	@Override
	public String toString() {
		return "MateriaPrimaDTO [codigo=" + codigoMP + ", descripcion=" + descripcion + ", unidadCompra="
				+ ", unidadUso=" + unidadUso + "]";
	}
	
	
	
	
}
