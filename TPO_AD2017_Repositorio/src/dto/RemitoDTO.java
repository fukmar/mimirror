package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RemitoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3189135135137783008L;
	private List<ItemRemitoDTO> itemsRemito;
	private Integer codigoProveedor;
	private OrdenDeCompraDTO ordenesDeCompra;
	private Date fecha;
	
	public RemitoDTO(){}
	
	public RemitoDTO(List<ItemRemitoDTO> itemsRemito, Integer codigoProveedor, OrdenDeCompraDTO ordenesDeCompra,
			Date fecha) {
		super();
		this.itemsRemito = itemsRemito;
		this.codigoProveedor = codigoProveedor;
		this.ordenesDeCompra = ordenesDeCompra;
		this.fecha = fecha;
	}

	public List<ItemRemitoDTO> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemitoDTO> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}

	public Integer getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(Integer codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public OrdenDeCompraDTO getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenesDeCompra(OrdenDeCompraDTO ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
