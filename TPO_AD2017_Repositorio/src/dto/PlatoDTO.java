package dto;

import java.io.Serializable;
import java.util.List;

public class PlatoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String nombre;
	private float precio;
	private List<ProductoDTO> productoPlato;
	
	public PlatoDTO(){}

	public PlatoDTO(Integer codigo, String nombre, float precio, List<ProductoDTO> productoPlato) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.productoPlato = productoPlato;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<ProductoDTO> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<ProductoDTO> productoPlato) {
		this.productoPlato = productoPlato;
	}

	@Override
	public String toString() {
		return "PlatoDTO [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", productoPlato="
				+ productoPlato + "]";
	}
	
	
}
