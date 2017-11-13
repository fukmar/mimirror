package negocio;

import dto.MateriaPrimaDTO;
import dto.UnidadDTO;
import entities.DepositoEntity;
import entities.UnidadEntity;

public class MateriaPrima 
{
	private Integer codigo;
	private String descripcion;
	private Unidad unidadUso;
	private Float cantidad;
	private Deposito deposito;

	public MateriaPrima(){}

	public MateriaPrima(String descripcion, Unidad unidadUso, Float cantidad) {
	super();

	this.descripcion = descripcion;
	this.unidadUso = unidadUso;
	this.setCantidad(cantidad);
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
		m.setUnidadUso(unidadUso.toDTO());
		return m;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
}
