package dto;

import java.io.Serializable;
import java.util.List;

public class DepositoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4076114728695091338L;
	private Integer codDeposito;
	private List<ProductoDTO> productos;
	private List<SolicitudInsumoDTO> solicitudes;
	private List<RemitoDTO> remitos;
	
	public DepositoDTO(){}

	public DepositoDTO(List<ProductoDTO> productos, List<SolicitudInsumoDTO> solicitudes, List<RemitoDTO> remitos) {
		super();
		this.productos = productos;
		this.solicitudes = solicitudes;
		this.remitos = remitos;
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}

	public List<SolicitudInsumoDTO> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudInsumoDTO> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public List<RemitoDTO> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<RemitoDTO> remitos) {
		this.remitos = remitos;
	}

	@Override
	public String toString() {
		return "DepositoDTO [productos=" + productos + ", solicitudes=" + solicitudes + ", remitos=" + remitos + "]";
	}

	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}
	
	
}
