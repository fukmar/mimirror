package entities;

import javax.persistence.*;


@Entity
@Table(name="itemsOrdenDeCompra")
public class ItemOrdenDeCompraEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codItemOrdenDeCompra;
	
	
	private Integer cantidad;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productos")
	private ProductoEntity producto;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ordenDeCompra")
	private OrdenDeCompraEntity ordenDeCompra;

	
	
	public ItemOrdenDeCompraEntity(){
		super();
	}
	
	

	public ItemOrdenDeCompraEntity(Integer codItemOrdenDeCompra,
			Integer cantidad, ProductoEntity producto,
			OrdenDeCompraEntity ordenDeCompra) {
		super();
		this.codItemOrdenDeCompra = codItemOrdenDeCompra;
		this.cantidad = cantidad;
		this.producto = producto;
		this.ordenDeCompra = ordenDeCompra;
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


	public OrdenDeCompraEntity getordenDeCompra() {
		return ordenDeCompra;
	}


	public void setordenDeCompra(OrdenDeCompraEntity ordenDeCompra) {
		this.ordenDeCompra = ordenDeCompra;
	}
	


	
}
