package dto;

import java.io.Serializable;

import enumns.EstadoItemRemito;


public class ItemRemitoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8398478230128292011L;

	
	private Integer cantidad;
	private ProductoDTO producto;  /*CONSULTAR*/
	private Integer codItemRemito;
	private EstadoItemRemito estadoremito;
	
	public ItemRemitoDTO(Integer cantidad, ProductoDTO producto, Integer codItemRemito, EstadoItemRemito estadoremito) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.codItemRemito = codItemRemito;
		this.estadoremito = estadoremito;
	}

	public EstadoItemRemito getEstadoremito() {
		return estadoremito;
	}

	public void setEstadoremito(EstadoItemRemito estadoremito) {
		this.estadoremito = estadoremito;
	}

	public ItemRemitoDTO(){}

	public ItemRemitoDTO(Integer cantidad, ProductoDTO producto, Integer codItemRemito) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.codItemRemito = codItemRemito;
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

	public Integer getCodItemRemito() {
		return codItemRemito;
	}

	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}
	
	
	
	
}
