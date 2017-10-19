package negocio;

import java.util.List;

import dto.ProductoDTO;
import entities.RemitoEntity;
import entities.SolicitudInsumoEntity;

public class Deposito {

	private Integer codDeposito;
	private List<ProductoDTO> productos;
	private List<SolicitudInsumoEntity> solicitudes;
	private List<RemitoEntity> remitos;
	
	public Deposito(List<ProductoDTO> productos, List<SolicitudInsumoEntity> solicitudes, List<RemitoEntity> remitos) {
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

	public List<SolicitudInsumoEntity> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudInsumoEntity> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public List<RemitoEntity> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<RemitoEntity> remitos) {
		this.remitos = remitos;
	}

	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}
	
	
	
	
}
