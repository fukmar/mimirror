package entities;

import javax.persistence.*;


@Entity
@Table(name="itemsOrdenDeCompra")
public class ItemOrdenDeCompraEntity {
	@Id
	@Column(name="codItemOrdenDeCompra")
	private Integer codItemOrdenDeCompra;
	private Integer cantidad;
	@OneToOne
	@JoinColumn(name="productos")
	private ProductoEntity producto;
	
	
	public ItemOrdenDeCompraEntity (){}


	public ItemOrdenDeCompraEntity(Integer codItemOrdenDeCompra,
			Integer cantidad, ProductoEntity producto) {
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


	public ProductoEntity getProducto() {
		return producto;
	}


	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}
}
