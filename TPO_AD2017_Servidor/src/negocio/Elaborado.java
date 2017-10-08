package negocio;

import java.util.List;


public class Elaborado extends Producto
{
	private float precioVenta;
	private Unidad unidad;
	private List<Producto>componentes;
	
	public Elaborado(){}

	public Elaborado(float precioVenta,Unidad unidad, List<Producto> componentes) {
		super();
		this.precioVenta = precioVenta;
		this.unidad = unidad;
		this.componentes = componentes;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
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
