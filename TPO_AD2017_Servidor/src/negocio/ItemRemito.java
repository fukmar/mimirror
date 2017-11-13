package negocio;



public class ItemRemito {
	
	private Integer codItemRemito;
	private Integer cantidad;
	private Remito remito;
	 
	 public ItemRemito(){}

		public ItemRemito(Integer cantidad) 
		{
			super();
			this.cantidad = cantidad;
			//this.codItemRemito = codItemRemito;
		}
	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
	}


	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	public Integer getCodItemRemito() {
		return codItemRemito;
	}

	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}
	
	
	
}
