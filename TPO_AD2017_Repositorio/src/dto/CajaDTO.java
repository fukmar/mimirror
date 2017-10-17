package dto;

import java.io.Serializable;
import java.util.List;

public class CajaDTO extends AreaRestaurantDTO implements Serializable
{
	private List<ComandaDTO> comandas;
	private List<FacturaDTO> facturas;
	
	public CajaDTO(){}

	public CajaDTO(List<ComandaDTO> comandas, List<FacturaDTO> facturas) {
		super();
		this.comandas = comandas;
		this.facturas = facturas;
	}

	public List<ComandaDTO> getComandas() {
		return comandas;
	}

	public void setComandas(List<ComandaDTO> comandas) {
		this.comandas = comandas;
	}

	public List<FacturaDTO> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaDTO> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "CajaDTO [comandas=" + comandas + ", facturas=" + facturas + "]";
	}
	
	
}
