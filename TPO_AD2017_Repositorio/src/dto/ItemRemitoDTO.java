package dto;

import java.io.Serializable;

import enumns.EstadoItemRemito;



public class ItemRemitoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8398478230128292011L;
	private Integer codItemRemito;
	private Integer cantidad;
	private RemitoDTO remito;
	private EstadoItemRemito estadoremito;
	private MateriaPrimaDTO materiaprima;
	 
	 public ItemRemitoDTO(Integer codItemRemito, Integer cantidad, RemitoDTO remito, EstadoItemRemito estadoremito,MateriaPrimaDTO materiaprima) {
		super();
		this.codItemRemito = codItemRemito;
		this.cantidad = cantidad;
		this.remito = remito;
		this.estadoremito = estadoremito;
		this.materiaprima=materiaprima;
	}

	
	public ItemRemitoDTO(){}

		public ItemRemitoDTO(Integer cantidad) 
		{
			super();
			this.cantidad = cantidad;
			//this.codItemRemito = codItemRemito;
		}
		
	public RemitoDTO getRemito() {
		return remito;
	}

	public void setRemito(RemitoDTO remito) {
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

	
	public EstadoItemRemito getEstadoremito() {
		return estadoremito;
	}

	public void setEstadoremito(EstadoItemRemito estadoremito) {
		this.estadoremito = estadoremito;
	}


	public MateriaPrimaDTO getMateriaprima() {
		return materiaprima;
	}


	public void setMateriaprima(MateriaPrimaDTO materiaprima) {
		this.materiaprima = materiaprima;
	}
	

	
}
