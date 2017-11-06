package entities;

import java.util.List;


import javax.persistence.*;


@Entity
@Table(name="platos")
public class PlatoEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codPlato")
	private Integer codigo;
	private String nombre;
	private float precio;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="platoCompuestoDe",
	joinColumns=@JoinColumn(name="codPlato",referencedColumnName="codPlato"),
	inverseJoinColumns=@JoinColumn(name="codProducto",referencedColumnName="codProducto"))
	private List<ElaboradoEntity> productoPlato;
	
	public PlatoEntity(){}

	public PlatoEntity(String nombre, float precio, List<ElaboradoEntity> productoPlato) {
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

	public List<ElaboradoEntity> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<ElaboradoEntity> productoPlato) {
		this.productoPlato = productoPlato;
	}

}
