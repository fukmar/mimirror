package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SemiElaboradoDTO extends ProductoDTO implements Serializable{

	private List<MateriaPrimaDTO> materiales;
	private UnidadDTO unidad;
			
	public SemiElaboradoDTO (){}
	
	
	public SemiElaboradoDTO(String tipo, String calidad, String descripcion,PlanDeProduccionDTO pdp, Integer cantidad, Date caducidad, List<MateriaPrimaDTO> materiales,UnidadDTO unidad) 
	{
		super(tipo, calidad, descripcion, pdp, cantidad, caducidad);
		this.materiales = materiales;
		this.unidad = unidad;
	
	}


	public void setMateriales(List<MateriaPrimaDTO> materiales) {
		this.materiales = materiales;
	}

	public UnidadDTO getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadDTO unidad) {
		this.unidad = unidad;
	}
	public List<MateriaPrimaDTO> getMateriales() {
		return materiales;
	}
	public void setMateriales(ArrayList<MateriaPrimaDTO> materiales) {
		this.materiales = materiales;
	}


	@Override
	public String toString() {
		return "SemiElaboradoDTO [materiales=" + materiales + ", unidad=" + unidad + "]";
	}
	
	
}
