package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ElaboradoDTO extends ProductoDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5892097441474909853L;
	private List<ProductoDTO>componentes;
	private UnidadDTO unidad;
	
	
	public ElaboradoDTO(){}

	
	public ElaboradoDTO(Integer numero, String tipo, String calidad, String descripcion, PlanDeProduccionDTO pdp,
			Integer cantidad, Date caducidad, List<ProductoDTO> componentes, UnidadDTO unidad) {
		super(numero, tipo, calidad, descripcion, pdp, cantidad, caducidad);
		this.componentes = componentes;
		this.unidad = unidad;
	}


	public UnidadDTO getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadDTO unidad) {
		this.unidad = unidad;
	}

	public List<ProductoDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ProductoDTO> componentes) {
		this.componentes = componentes;
	}

	@Override
	public String toString() {
		return "ElaboradoDTO [componentes=" + componentes + ", unidad=" + unidad + "]";
	}

	
	
}
