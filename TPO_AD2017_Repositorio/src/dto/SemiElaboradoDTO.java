package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SemiElaboradoDTO extends ProductoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5026854482006058537L;
	private List<MateriaPrimaDTO> materiales;
	private UnidadDTO unidadAlmacenamiento;
	

	public SemiElaboradoDTO(){}

	
	public SemiElaboradoDTO(Integer numero, String tipo, String calidad, String descripcion, PlanDeProduccionDTO pdp,
			Integer cantidad, Date caducidad, List<MateriaPrimaDTO> materiales, UnidadDTO unidadAlmacenamiento) {
		super(numero, tipo, calidad, descripcion, pdp, cantidad, caducidad);
		this.materiales = materiales;
		this.unidadAlmacenamiento = unidadAlmacenamiento;
	}

	public UnidadDTO getUnidad() {
		return unidadAlmacenamiento;
	}

	public void setUnidad(UnidadDTO unidad) {
		this.unidadAlmacenamiento = unidad;
	}

	public List<MateriaPrimaDTO> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<MateriaPrimaDTO> materiales) {
		this.materiales = materiales;
	}

	@Override
	public String toString() {
		return "SemiElaboradoDTO [ unidad=" + unidadAlmacenamiento + ", materiales="
				+ materiales + "]";
	}
	
	
}
