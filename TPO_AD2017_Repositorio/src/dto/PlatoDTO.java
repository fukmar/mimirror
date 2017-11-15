package dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import enumns.CategoriaPlato;




public class PlatoDTO implements Serializable
{

	private Integer codigo;
	private String nombre;
	private float precio;
	private List<ElaboradoDTO> productoPlato;
	private CartaDTO carta;
	private CategoriaPlato categoria;
	
	public PlatoDTO() {}

	public PlatoDTO(Integer codigo, String nombre, float precio, List<ElaboradoDTO> productoPlato, CartaDTO carta,
			CategoriaPlato categoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.productoPlato = productoPlato;
		this.carta = carta;
		this.categoria = categoria;
	}

	public CategoriaPlato getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPlato categoria) {
		this.categoria = categoria;
	}

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

	public CartaDTO getCarta() {
		return carta;
	}

	public void setCarta(CartaDTO carta) {
		this.carta = carta;
	}

	@Override
	public String toString() {
		return "PlatoDTO [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio +"]";
	}


	
}
