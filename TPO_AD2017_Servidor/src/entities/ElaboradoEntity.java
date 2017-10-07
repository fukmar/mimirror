package entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="elaborados")
public class ElaboradoEntity extends ProductoEntity 
{
	
	private float precioVenta;
	private int porcentajeGanancia;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private UnidadEntity unidad;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="compuestoDe",
	joinColumns=@JoinColumn(name="codProductoE",referencedColumnName="codProducto"),
	inverseJoinColumns=@JoinColumn(name="codProductoSM",referencedColumnName="codProducto"))
	private List<ProductoEntity>componentes;
	
	public ElaboradoEntity(){}
	
	
	public ElaboradoEntity(float precioVenta, int porcentajeGanancia, UnidadEntity unidad,
			List<ProductoEntity> componentes) {
		super();
		this.precioVenta = precioVenta;
		this.porcentajeGanancia = porcentajeGanancia;
		this.unidad = unidad;
		this.componentes = componentes;
	}


	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public void setPorcentajeGanancia(int porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
	public UnidadEntity getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadEntity unidad) {
		this.unidad = unidad;
	}
	public List<ProductoEntity> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<ProductoEntity> componentes) {
		this.componentes = componentes;
	}
}
