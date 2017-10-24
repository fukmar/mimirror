package entities;

import javax.persistence.*;

import negocio.Producto;

@Entity
@Table(name="itemRemitos")
public class ItemRemitoEntity {

	@Id
	@Column(name="codItemRemito")
	private Integer codItemRemito;
	private Integer cantidad;
	@OneToOne
	@JoinColumn(name="codProducto")  
	private ProductoEntity producto;  
		
	public ItemRemitoEntity(){}

	public ItemRemitoEntity(Integer cantidad, ProductoEntity producto, Integer codItemRemito) {
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

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public Integer getCodItemRemito() {
		return codItemRemito;
	}

	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}
}
