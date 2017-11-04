package negocio;

import java.util.Date;
import java.util.List;



public class Elaborado extends Producto
{
	private static final long serialVersionUID = 1L;
	private List<Producto>componentes;

	private Unidad unidad;
	
	
	public Elaborado(){}

	public Elaborado(String tipo, String calidad, String descripcion, PlanDeProduccion pdp,
			Integer cantidad, Date caducidad, List<Producto> componentes, Unidad unidad) {
		super(tipo, calidad, descripcion, pdp, cantidad, caducidad);
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
