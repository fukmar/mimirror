package dto;

import java.io.Serializable;


public class ItemOrdenDeCompraDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codItemOrdenDeCompra;
	private Integer cantidad;
	private ProductoDTO producto;
	
	
	public ItemOrdenDeCompraDTO (){}


	public ItemOrdenDeCompraDTO(Integer codItemOrdenDeCompra,
			Integer cantidad, ProductoDTO producto) {
		super();
		this.codItemOrdenDeCompra = codItemOrdenDeCompra;
		this.cantidad = cantidad;
		this.producto = producto;
	}


	public Integer getCodItemOrdenDeCompra() {
		return codItemOrdenDeCompra;
	}


	public void setCodItemOrdenDeCompra(Integer codItemOrdenDeCompra) {
		this.codItemOrdenDeCompra = codItemOrdenDeCompra;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public ProductoDTO getProducto() {
		return producto;
	}


	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	
	


}
