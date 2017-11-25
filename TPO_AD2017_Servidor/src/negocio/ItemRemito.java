package negocio;

import entities.ItemRemitoEntity;
import entities.MateriaPrimaEntity;
import enumns.EstadoItemRemito;

public class ItemRemito {
	
	private Integer codItemRemito;
	private Integer cantidad;
	private Remito remito;
	private EstadoItemRemito estadoremito;
	private MateriaPrima materiaprima;
	 

	public ItemRemito() {
		super();
	}
	
	
	public ItemRemito(Integer cantidad, Remito remito, EstadoItemRemito estadoremito, MateriaPrima materiaprima) {
		super();
		this.cantidad = cantidad;
		this.remito = remito;
		this.estadoremito = estadoremito;
		this.materiaprima = materiaprima;
	}


	public ItemRemito(Integer codItemRemito, Integer cantidad, Remito remito, EstadoItemRemito estadoremito,
			MateriaPrima materiaprima) {
		super();
		this.codItemRemito = codItemRemito;
		this.cantidad = cantidad;
		this.remito = remito;
		this.estadoremito = estadoremito;
		this.materiaprima = materiaprima;
	}



	public MateriaPrima getMateriaprima() {
		return materiaprima;
	}


	public void setMateriaprima(MateriaPrima materiaprima) {
		this.materiaprima = materiaprima;
	}


	public EstadoItemRemito getEstadoremito() {
		return estadoremito;
	}

	public void setEstadoremito(EstadoItemRemito estadoremito) {
		this.estadoremito = estadoremito;
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
	
	public ItemRemitoEntity toEntity() {
		ItemRemitoEntity item=new ItemRemitoEntity();
		item.setCodItemRemito(codItemRemito);
		item.setCantidad(cantidad);
		item.setEstadoremito(estadoremito);
		item.setRemito(remito.toEntity());
		item.setMateriaprima(materiaprima.toEntity());
		return item;
		
	}
	
	
	
}
