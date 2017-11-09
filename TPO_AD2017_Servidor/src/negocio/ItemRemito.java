package negocio;

public class ItemRemito {
	
	private Integer cantidad;
	private Producto producto;  /*CONSULTAR*/
	private Integer codItemRemito;
	
	public ItemRemito(){}

	public ItemRemito(Integer cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCodItemRemito() {
		return codItemRemito;
	}

	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}
	
	
	
	
}
