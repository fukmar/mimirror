package entities;

import java.util.List;


import javax.persistence.*;


@Entity
@Table(name="platos")
public class PlatoEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigo;
	private String nombre;
	private float precio;
	
	@OneToMany
	@JoinColumn(name="codProducto")
	private List<ProductoEntity> productoPlato;
	
	public PlatoEntity(){}

	public PlatoEntity(Integer codigo, String nombre, float precio, List<ProductoEntity> productoPlato) {
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

	public List<ProductoEntity> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<ProductoEntity> productoPlato) {
		this.productoPlato = productoPlato;
	}

}
