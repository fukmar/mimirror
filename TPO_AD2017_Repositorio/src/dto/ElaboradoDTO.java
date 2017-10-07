package dto;

import java.io.Serializable;
import java.util.List;

public class ElaboradoDTO extends ProductoDTO implements Serializable{
	
	private float precioVenta;
	private int porcentajeGanancia;
	private UnidadDTO unidad;
	private List<ProductoDTO>componentes;
	
	public ElaboradoDTO(){}

	public ElaboradoDTO(float precioVenta, int porcentajeGanancia, UnidadDTO unidad, List<ProductoDTO> componentes) {
		super();
		this.precioVenta = precioVenta;
		this.porcentajeGanancia = porcentajeGanancia;
		this.unidad = unidad;
		this.componentes = componentes;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(int porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
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
		return "ElaboradoDTO [precioVenta=" + precioVenta + ", porcentajeGanancia=" + porcentajeGanancia + ", unidad="
				+ unidad + ", componentes=" + componentes + "]";
	}
	
	
}
