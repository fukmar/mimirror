package negocio;

import java.util.Date;
import java.util.List;

public class Remito {
	
	private List<ItemRemito> itemsRemito;
	private Integer codigoProveedor;
	private Date fecha;
	private OrdenDeCompra ordendeCompra;
	private Integer codRemito;
	
	
	public Remito(){}
	
	public Remito(List<ItemRemito> itemsRemito, Integer codigoProveedor,
			Date fecha, OrdenDeCompra ordendeCompra, Integer codRemito) {
		super();
		this.itemsRemito = itemsRemito;
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.ordendeCompra = ordendeCompra;
		this.codRemito= codRemito;
	}

	public List<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemito> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}

	public Integer getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(Integer codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public OrdenDeCompra getOrdendeCompra() {
		return ordendeCompra;
	}

	public void setOrdendeCompra(OrdenDeCompra ordendeCompra) {
		this.ordendeCompra = ordendeCompra;
	}

	public Integer getCodRemito() {
		return codRemito;
	}

	public void setCodRemito(Integer codRemito) {
		this.codRemito = codRemito;
	}
	
	
}
