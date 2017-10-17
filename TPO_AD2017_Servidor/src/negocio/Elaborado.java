package negocio;

import java.util.List;



public class Elaborado extends Producto
{
	private static final long serialVersionUID = 1L;
	private List<Producto>componentes;

	private Unidad unidad;
	
	
	public Elaborado(){}

	public Elaborado(List<Producto> componentes,Unidad unidad) {
		super();
		this.componentes = componentes;
		this.unidad = unidad;
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
