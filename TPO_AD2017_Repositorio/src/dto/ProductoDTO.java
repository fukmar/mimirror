package dto;

import java.io.Serializable;

public abstract class ProductoDTO implements Serializable
{
	
	protected Integer numero;
	protected String descripcion;
	
	public ProductoDTO(){}

	public ProductoDTO(Integer numero, String descripcion) {
		super();
		this.numero = numero;
		this.descripcion = descripcion;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ProductoDTO [numero=" + numero + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
