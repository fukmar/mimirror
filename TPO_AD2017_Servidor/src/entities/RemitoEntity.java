package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import enumns.EstadoRemito;
import negocio.*;


@Entity
@Table(name="remitos")
public class RemitoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codRemito")
	private Integer codRemito;
	
	private Integer codigoProveedor;
	private Date fecha;
	private EstadoRemito estado;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codDeposito", nullable=false)
    private DepositoEntity deposito;


	@OneToMany(fetch = FetchType.EAGER, mappedBy="remito", cascade = CascadeType.ALL)
	private List<ItemRemitoEntity> itemsRemito;
	
	
	@OneToOne
	@JoinColumn(name="codOrdenDeCompra")
	private OrdenDeCompraEntity ordendeCompra;
	/*para probar el onetomany la saco un rato*/	
		
	public RemitoEntity(){}
		
	public RemitoEntity(Integer codigoProveedor, Date fecha,
			List<ItemRemitoEntity> itemsRemito,EstadoRemito estado ) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.estado=estado;
		this.fecha = fecha;
		this.itemsRemito = itemsRemito;
		this.ordendeCompra = ordendeCompra;
	}
	
	public RemitoEntity(Integer codigoProveedor, Date fecha) 
	{
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.ordendeCompra = ordendeCompra;
	}
	
	public EstadoRemito getEstado() {
		return estado;
	}

	public void setEstado(EstadoRemito estado) {
		this.estado = estado;
	}

	public List<ItemRemitoEntity> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemitoEntity> itemsRemito) {
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
	

	public OrdenDeCompraEntity getOrdendeCompra() {
		return ordendeCompra;
	}

	public void setOrdendeCompra(OrdenDeCompraEntity ordendeCompra) {
		this.ordendeCompra = ordendeCompra;
	}
	
	
	public Integer getCodRemito() {
		return codRemito;
	}

	public void setCodRemito(Integer codRemito) {
		this.codRemito = codRemito;
	}	

	
	public DepositoEntity getDeposito() {
		return deposito;
	}

	public void setDeposito(DepositoEntity deposito) {
		this.deposito = deposito;
	}
	
	
	public Remito toNegocio() {
		//List<ItemRemito> items = new ArrayList<ItemRemito>();
		//for(ItemRemitoEntity itemEn: itemsRemito) {
		//	items.add(itemEn.toNegocio());
		//}
		Remito r = new Remito();
		r.setCodigoProveedor(codigoProveedor);
		r.setCodRemito(codRemito);
		r.setFecha(fecha);
		//r.setItemsRemito(items);
		r.setEstado(estado);
		return r;
	}
}
