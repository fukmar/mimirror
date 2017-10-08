package dto;

import java.io.Serializable;
import java.util.List;

public class ElaboradoDTO extends ProductoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float precioVenta;
	private UnidadDTO unidad;
	private List<ProductoDTO>componentes;
	
	public ElaboradoDTO(){}

	public ElaboradoDTO(float precioVenta, int porcentajeGanancia, UnidadDTO unidad, List<ProductoDTO> componentes) {
		super();
		this.precioVenta = precioVenta;
		this.unidad = unidad;
		this.componentes = componentes;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
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
		return "ElaboradoDTO [precioVenta=" + precioVenta + ", porcentajeGanancia=" + ", unidad="
				+ unidad + ", componentes=" + componentes + "]";
	}
	
	
}
