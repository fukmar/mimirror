package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class ElaboradoDTO extends ProductoDTO implements Serializable{

	private static final long serialVersionUID = -5892097441474909853L;
	
	private UnidadDTO unidad;
	private List<SemiElaboradoDTO> componentes;
	private PlanDeProduccionDTO plan;
	
	public ElaboradoDTO(){}
	

	public ElaboradoDTO(String tipo, String calidad, String descripcion,
			Integer cantidad, Date caducidad, UnidadDTO unidad, List<SemiElaboradoDTO> componentes) {
		super(tipo, calidad, descripcion,  cantidad, caducidad);
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


	public PlanDeProduccionDTO getPlan() {
		return plan;
	}


	public void setPlan(PlanDeProduccionDTO plan) {
		this.plan = plan;
	}
	
	
}
