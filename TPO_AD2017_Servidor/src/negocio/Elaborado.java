package negocio;

import java.util.Date;
import java.util.List;

import dto.ElaboradoDTO;
import entities.PlanDeProduccionEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;



public class Elaborado extends Producto
{
	private static final long serialVersionUID = 1L;
	private Unidad unidad;
	private List<SemiElaborado> componentes;

	
	public Elaborado(){}

	public Elaborado(String tipo, String calidad, String descripcion, PlanDeProduccion pdp,
			Integer cantidad, Date caducidad, Unidad unidad, List<SemiElaborado> componentes) {
		super(tipo, calidad, descripcion, pdp, cantidad, caducidad);
		this.unidad = unidad;
		this.componentes = componentes;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public List<SemiElaborado> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<SemiElaborado> componentes) {
		this.componentes = componentes;
	}

	

	/*public Elaborado toDTO() 
	{
		ElaboradoDTO e=new ElaboradoDTO();
		e.set
		return null;
	}*/

}
