package negocio;

import entities.ItemOrdenDeCompraEntity;

public class ItemOrdenDeCompra {
	
		private Integer codItemOrdenDeCompra;
		private Integer cantidad;
		private Producto producto;
		
		
		public ItemOrdenDeCompra (){}


		public ItemOrdenDeCompra(Integer codItemOrdenDeCompra,
				Integer cantidad, Producto producto) {
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


		public Producto getProducto() {
			return producto;
		}


		public void setProducto(Producto producto) {
			this.producto = producto;
		}


	
		
		
		

}
