package negocio;

import enumns.EstadoItemRemito;

public class ItemRemito {
	
	private Integer codItemRemito;
	private Integer cantidad;
	private Remito remito;
	private EstadoItemRemito estadoremito;
	 
	 public ItemRemito(Integer codItemRemito, Integer cantidad, Remito remito, EstadoItemRemito estadoremito) {
		super();
		this.codItemRemito = codItemRemito;
		this.cantidad = cantidad;
		this.remito = remito;
		this.estadoremito = estadoremito;
	}

	public EstadoItemRemito getEstadoremito() {
		return estadoremito;
	}

	public void setEstadoremito(EstadoItemRemito estadoremito) {
		this.estadoremito = estadoremito;
	}

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

	public ItemRemito toNegocio() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
