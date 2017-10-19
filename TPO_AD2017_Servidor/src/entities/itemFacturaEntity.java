package entities;


public class itemFacturaEntity {
	@OneToOne 
	@JoinColumn(name="") // Verificar varios puntos.  No deberìa tener atributo cantidad si lo trae de la comanda que ya lo tiene. esta bien que el subtotal provenga desde la comanda? si es asì no tiene sentido el atrib cantidad.  No tiene sentido incluirlo
	// esta clase solo deberìa tener ItemComanda. ItemComanda tiene el Plato y cantidad, el precio serìa un subtotal que hace el sistema(precioxcant) quizas es mejor llamar al atrib de otra manera. 
	private ItemComandaEntity itemcomanda;
	private Integer cantidad;
	public itemFacturaEntity(ItemComandaEntity itemcomanda, Integer cantidad) {
		super();
		this.itemcomanda = itemcomanda;
		this.cantidad = cantidad;
	}
	public itemFacturaEntity() {
		super();
	}
	public ItemComandaEntity getItemcomanda() {
		return itemcomanda;
	}
	public void setItemcomanda(ItemComandaEntity itemcomanda) {
		this.itemcomanda = itemcomanda;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
}
