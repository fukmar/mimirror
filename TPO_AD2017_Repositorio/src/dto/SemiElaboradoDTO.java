package dto;

import java.io.Serializable;
import java.util.List;


public class SemiElaboradoDTO extends ProductoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5026854482006058537L;
	private List<MateriaPrimaDTO> materiales;
	private UnidadDTO unidadAlmacenamiento;
	

	public SemiElaboradoDTO(){}

	public SemiElaboradoDTO(List<MateriaPrimaDTO> materiales,UnidadDTO unidad ) {
		super();
		this.unidadAlmacenamiento = unidad;
		this.materiales = materiales;
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
