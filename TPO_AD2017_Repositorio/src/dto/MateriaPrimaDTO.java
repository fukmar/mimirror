package dto;

import java.io.Serializable;



public class MateriaPrimaDTO implements Serializable
{
	private Integer codigo;
	private String descripcion;
	private UnidadDTO unidadUso;
	private Float cantidad;
	private Integer estadescontado=0;
	private DepositoDTO deposito;

	public MateriaPrimaDTO(){}

	public MateriaPrimaDTO(String descripcion, UnidadDTO unidadUso, Float cantidad) {
	super();

	this.descripcion = descripcion;
	this.unidadUso = unidadUso;
	this.setCantidad(cantidad);
}

	public Integer getEstadescontado() {
		return estadescontado;
	}

	public void setEstadescontado(Integer estadescontado) {
		this.estadescontado = estadescontado;
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


	public UnidadDTO getUnidadUso() {
		return unidadUso;
	}

	public void setUnidadUso(UnidadDTO unidadUso) {
		this.unidadUso = unidadUso;
	}


	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public DepositoDTO getDeposito() {
		return deposito;
	}

	public void setDeposito(DepositoDTO deposito) {
		this.deposito = deposito;
	}
	
	
	
	
}
