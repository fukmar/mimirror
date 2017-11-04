package negocio;

import java.util.List;



public class Plato 
{
	private Integer codigo;
	private String nombre;
	private float precio;
	private List<Elaborado> productoPlato;
	
	public Plato(){}

	public Plato(String nombre, float precio, List<Elaborado> productoPlato) {
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

	public List<Elaborado> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<Elaborado> productoPlato) {
		this.productoPlato = productoPlato;
	}

}
