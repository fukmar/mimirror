package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class ElaboradoDTO extends ProductoDTO implements Serializable{

	private static final long serialVersionUID = -5892097441474909853L;
	
	private UnidadDTO unidad;
	private List<SemiElaboradoDTO> componentes;
	
	public ElaboradoDTO(){}
	

	public ElaboradoDTO(String tipo, String calidad, String descripcion, PlanDeProduccionDTO pdp,
			Integer cantidad, Date caducidad, UnidadDTO unidad, List<SemiElaboradoDTO> componentes) {
		super(tipo, calidad, descripcion, pdp, cantidad, caducidad);
		this.unidad = unidad;
		this.componentes = componentes;
	}


	public UnidadDTO getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadDTO unidad) {
		this.unidad = unidad;
	}
	public List<SemiElaboradoDTO> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<SemiElaboradoDTO> componentes) {
		this.componentes = componentes;
	}
	
}
