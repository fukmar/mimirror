package negocio;

import java.util.Date;
import java.util.List;


public class Remito 
{
	private Integer codRemito;
	private Integer codigoProveedor;
	private Date fecha;
    private Deposito deposito;
	private List<ItemRemito> itemsRemito;
	
		
	public Remito(){}
		
	public Remito(Integer codigoProveedor, Date fecha,
			List<ItemRemito> itemsRemito
			) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.itemsRemito = itemsRemito;
		//this.ordendeCompra = ordendeCompra;
	}
	
	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
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

	public Integer getCodRemito() {
		return codRemito;
	}

	public void setCodRemito(Integer codRemito) {
		this.codRemito = codRemito;
	}	
	
}
