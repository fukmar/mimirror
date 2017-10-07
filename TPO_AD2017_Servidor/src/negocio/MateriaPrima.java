package negocio;

import dto.MateriaPrimaDTO;
import dto.UnidadDTO;

public class MateriaPrima 
{
	private Integer codigo;
	private String descripcion;
	private Unidad unidadCompra;
	private Unidad unidadUso;

	public MateriaPrima(){}

	public MateriaPrima(Integer codigo, String descripcion, Unidad unidadCompra, Unidad unidadUso) {
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

	public Unidad getUnidadCompra() {
		return unidadCompra;
	}

	public void setUnidadCompra(Unidad unidadCompra) {
		this.unidadCompra = unidadCompra;
	}

	public Unidad getUnidadUso() {
		return unidadUso;
	}

	public void setUnidadUso(Unidad unidadUso) {
		this.unidadUso = unidadUso;
	}

	public MateriaPrimaDTO toDTO()
	{
		MateriaPrimaDTO m=new MateriaPrimaDTO();
		m.setCodigo(codigo);
		m.setDescripcion(descripcion);
		m.setUnidadCompra(unidadCompra.toDTO());
		m.setUnidadUso(unidadUso.toDTO());
		return m;
	}
}
