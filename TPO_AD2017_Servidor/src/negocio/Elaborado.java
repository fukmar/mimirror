package negocio;

import java.util.List;

import dto.ProductoDTO;
import dto.UnidadDTO;

public class Elaborado 
{
	private float precioVenta;
	private int porcentajeGanancia;
	private Unidad unidad;
	private List<Producto>componentes;
	
	public Elaborado(){}

	public Elaborado(float precioVenta, int porcentajeGanancia, Unidad unidad, List<Producto> componentes) {
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

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public List<Producto> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Producto> componentes) {
		this.componentes = componentes;
	}

}
