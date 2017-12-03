package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.RemitoDAO;
import dto.ItemRemitoDTO;
import dto.RemitoDTO;
import entities.*;
import enumns.EstadoRemito;


public class Remito 
{
	private Integer codRemito;
	private Integer codigoProveedor;
	private Date fecha;
    private Deposito deposito;
	private List<ItemRemito> itemsRemito;
	private EstadoRemito estado;
		
	public Remito(){}
		
	public Remito(Integer codigoProveedor, Date fecha, Deposito deposito, List<ItemRemito> itemsRemito,
			EstadoRemito estado) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.deposito = deposito;
		this.itemsRemito = itemsRemito;
		this.estado = estado;
	}
	
	public Remito(Integer codigoProveedor, Date fecha, Deposito deposito, 
			EstadoRemito estado) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.deposito = deposito;
		this.estado = estado;
	}

	public Remito(Integer codigoProveedor, Date fecha) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
	
	}
	public EstadoRemito getEstado() {
		return estado;
	}

	public void setEstado(EstadoRemito estado) {
		this.estado = estado;
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
	
	public RemitoEntity toEntity() {
		List<ItemRemitoEntity> items = new ArrayList<ItemRemitoEntity>();
		
		/*for(ItemRemito itemnegocio: this.itemsRemito) {
			items.add(itemnegocio.toEntity());
		}*/
		RemitoEntity remit= new RemitoEntity();
		remit.setCodigoProveedor(codigoProveedor);
		remit.setFecha(fecha);
	//	remit.setItemsRemito(items);
		remit.setEstado(estado);
		remit.setCodRemito(codRemito);
		remit.setDeposito(deposito.toEntity());
		return remit;
	}
	
	public RemitoDTO toDTO() {
		
		//List<ItemRemitoDTO> items= new ArrayList<ItemRemitoDTO>();
		//for(ItemRemito i:this.itemsRemito) {
		//	items.add(i.toDTO());
		//}
		
		RemitoDTO remit=new RemitoDTO();
		remit.setCodigoProveedor(codigoProveedor);
		remit.setCodRemito(codRemito);
		remit.setDeposito(deposito.toDTO());
		remit.setFecha(fecha);
		//remit.setItemsRemito(items);
		remit.setEstado(estado);
		return remit;
	}

	public void save() 
	{
		RemitoDAO.getInstance().save(this);
		
	}
	
}
