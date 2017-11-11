package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="remitos")
public class RemitoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codRemito")
	private Integer codRemito;
	private Integer codigoProveedor;
	private Date fecha;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy="remito", cascade = CascadeType.ALL)
	private List<ItemRemitoEntity> itemsRemito;
/*	@OneToOne
	@JoinColumn(name="codOrdenDeCompra")
	private OrdenDeCompraEntity ordendeCompra;
	para probar el onetomany la saco un rato*/	
		
	public RemitoEntity(){}
		
	public RemitoEntity(Integer codigoProveedor, Date fecha,
			List<ItemRemitoEntity> itemsRemito
			) {
		super();
		this.codigoProveedor = codigoProveedor;
		this.fecha = fecha;
		this.itemsRemito = itemsRemito;
		//this.ordendeCompra = ordendeCompra;
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
/*
	public OrdenDeCompraEntity getOrdendeCompra() {
		return ordendeCompra;
	}

	public void setOrdendeCompra(OrdenDeCompraEntity ordendeCompra) {
		this.ordendeCompra = ordendeCompra;
	}
	*/	
	public Integer getCodRemito() {
		return codRemito;
	}

	public void setCodRemito(Integer codRemito) {
		this.codRemito = codRemito;
	}	

}
