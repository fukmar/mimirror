package negocio;

import java.util.List;

import dto.ComandaDTO;
import dto.FacturaDTO;
import enumns.AreaRest;

public class Caja extends AreaRestaurant
{
	private List<Comanda> comandas;
	private List<Factura> facturas;
	
	public Caja(){}

	
	
	public Caja(Integer codArea, AreaRest area, List<Comanda> comandas, List<Factura> facturas) {
		super(codArea, area);
		this.comandas = comandas;
		this.facturas = facturas;
	}

	public Caja(List<Comanda> comandas, List<Factura> facturas) {
		super();
		this.comandas = comandas;
		this.facturas = facturas;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}
