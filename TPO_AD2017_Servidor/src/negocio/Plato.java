package negocio;

import java.util.List;



public class Plato 
{
	private Integer codigo;
	private String nombre;
	private float precio;
	private List<Producto> productoPlato;
	
	public Plato(){}

	public Plato(Integer codigo, String nombre, float precio, List<Producto> productoPlato) {
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

	public List<Producto> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<Producto> productoPlato) {
		this.productoPlato = productoPlato;
	}

}
