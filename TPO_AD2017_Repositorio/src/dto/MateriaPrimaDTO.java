package dto;

import java.io.Serializable;

public class MateriaPrimaDTO implements Serializable
{

	private Integer codigo;
	private String descripcion;
	private UnidadDTO unidadCompra;
	private UnidadDTO unidadUso;

	public MateriaPrimaDTO(){}

	public MateriaPrimaDTO(Integer codigo, String descripcion, UnidadDTO unidadCompra, UnidadDTO unidadUso) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.unidadCompra = unidadCompra;
		this.unidadUso = unidadUso;
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

	public UnidadDTO getUnidadCompra() {
		return unidadCompra;
	}

	public void setUnidadCompra(UnidadDTO unidadCompra) {
		this.unidadCompra = unidadCompra;
	}

	public UnidadDTO getUnidadUso() {
		return unidadUso;
	}

	public void setUnidadUso(UnidadDTO unidadUso) {
		this.unidadUso = unidadUso;
	}

	@Override
	public String toString() {
		return "MateriaPrimaDTO [codigo=" + codigo + ", descripcion=" + descripcion + ", unidadCompra=" + unidadCompra
				+ ", unidadUso=" + unidadUso + "]";
	}
	
	
	
	
}
