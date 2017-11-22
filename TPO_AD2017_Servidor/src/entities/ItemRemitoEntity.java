package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import enumns.EstadoItemRemito;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.ItemRemito;
import negocio.Plato;
import negocio.Producto;
import negocio.Remito;

@Entity
@Table(name="itemsRemito")
public class ItemRemitoEntity {

	@Id
	@Column(name="codItemRemito")
	private Integer codItemRemito;
	
	
	private Integer cantidad;
	private EstadoItemRemito estadoremito;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="codRemito", nullable=false)
    private RemitoEntity remito;
	
	
	
	public ItemRemitoEntity(){}
	
	
	public ItemRemitoEntity(Integer codItemRemito, Integer cantidad, EstadoItemRemito estadoremito,
			RemitoEntity remito) {
		super();
		this.codItemRemito = codItemRemito;
		this.cantidad = cantidad;
		this.estadoremito = estadoremito;
		this.remito = remito;
	}

	
	
	public EstadoItemRemito getEstadoremito() {
		return estadoremito;
	}

	public void setEstadoremito(EstadoItemRemito estadoremito) {
		this.estadoremito = estadoremito;
	}

	public RemitoEntity getRemito() {
		return remito;
	}

	public void setRemito(RemitoEntity remito) {
		this.remito = remito;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	public Integer getCodItemRemito() {
		return codItemRemito;
	}

	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}

	
	public ItemRemitoEntity(Integer cantidad) {
		super();
		this.cantidad = cantidad;
	
		//this.codItemRemito = codItemRemito;
	}
	
	

	public ItemRemito toNegocio() 
	{
		ItemRemito item=new ItemRemito();
		item.setCodItemRemito(codItemRemito);
		item.setCantidad(cantidad);
		item.setEstadoremito(estadoremito);
		item.setRemito(remito.toNegocio());
		return item;
	}

	
	
}
