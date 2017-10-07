package dto;

import java.io.Serializable;
import java.util.List;


public class SemiElaboradoDTO extends ProductoDTO implements Serializable{

	private double costoProduccion;
	private UnidadDTO unidad;
	private List<MateriaPrimaDTO> materiales;

	public SemiElaboradoDTO(){}

	public SemiElaboradoDTO(double costoProduccion, UnidadDTO unidad, List<MateriaPrimaDTO> materiales) {
		super();
		this.costoProduccion = costoProduccion;
		this.unidad = unidad;
		this.materiales = materiales;
	}

	public double getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(double costoProduccion) {
		this.costoProduccion = costoProduccion;
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

	public void setMateriales(List<MateriaPrimaDTO> materiales) {
		this.materiales = materiales;
	}

	@Override
	public String toString() {
		return "SemiElaboradoDTO [costoProduccion=" + costoProduccion + ", unidad=" + unidad + ", materiales="
				+ materiales + "]";
	}
	
	
}
