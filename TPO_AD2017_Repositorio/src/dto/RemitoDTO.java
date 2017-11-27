package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enumns.EstadoRemito;


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
	private EstadoRemito estado;
		
	public RemitoDTO(){}
	
	public RemitoDTO(Integer codigoProveedor, Date fecha, DepositoDTO deposito, List<ItemRemitoDTO> itemsRemito,
			EstadoRemito estado) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.deposito = deposito;
		this.itemsRemito = itemsRemito;
		this.estado = estado;
	}


	public EstadoRemito getEstado() {
		return estado;
	}

	public void setEstado(EstadoRemito estado) {
		this.estado = estado;
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
