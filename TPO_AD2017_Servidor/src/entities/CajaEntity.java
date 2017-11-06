package entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="cajas")
public class CajaEntity extends AreaRestaurantEntity
{
	@OneToMany
	@JoinColumn(name="codComanda")
	private List<ComandaEntity> comandas;
	
	@OneToMany
	@JoinColumn(name="codFactura")
	private List<FacturaEntity> facturas;
	
	public CajaEntity(){}


	public List<ComandaEntity> getComandas() {
		return comandas;
	}

	public void setComandas(List<ComandaEntity> comandas) {
		this.comandas = comandas;
	}

	public List<FacturaEntity> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaEntity> facturas) {
		this.facturas = facturas;
	}

}
