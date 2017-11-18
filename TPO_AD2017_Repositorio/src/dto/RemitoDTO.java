package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class RemitoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3189135135137783008L;
	private Integer codRemito;
	private Integer codigoProveedor;
	private Date fecha;
    private DepositoDTO deposito;
	private List<ItemRemitoDTO> itemsRemito;
	
		
	public RemitoDTO(){}
		
	public RemitoDTO(Integer codigoProveedor, Date fecha,
			List<ItemRemitoDTO> itemsRemito
			) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.itemsRemito = itemsRemito;
		//this.ordendeCompra = ordendeCompra;
	}
	
	public DepositoDTO getDeposito() {
		return deposito;
	}

	public void setDeposito(DepositoDTO deposito) {
		this.deposito = deposito;
	}
	public List<ItemRemitoDTO> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemitoDTO> itemsRemito) {
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
