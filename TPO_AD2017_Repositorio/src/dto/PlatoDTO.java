package dto;

import java.io.Serializable;
import java.util.List;



public class PlatoDTO implements Serializable
{
	private Integer codigo;
	private String nombre;
	private float precio;
	

	private List<ElaboradoDTO> productoPlato;
	
	public PlatoDTO(){}

	public PlatoDTO(String nombre, float precio, List<ElaboradoDTO> productoPlato) {
		super();
	
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

	public List<ElaboradoDTO> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<ElaboradoDTO> productoPlato) {
		this.productoPlato = productoPlato;
	}

	@Override
	public String toString() {
		return "PlatoDTO [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", productoPlato="
				+ productoPlato + "]";
	}


	
}
