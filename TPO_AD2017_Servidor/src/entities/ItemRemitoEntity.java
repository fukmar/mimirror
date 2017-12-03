package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import enumns.EstadoRemito;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.ItemRemito;
import negocio.Plato;
import negocio.Producto;
import negocio.Remito;
import negocio.SolicitudIndividual;

@Entity
@Table(name="itemsRemito")
public class ItemRemitoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codItemRemito")
	private Integer codItemRemito;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private MateriaPrimaEntity materiaprima;
	
	private Float cantidad;
	private EstadoRemito estadoremito;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="codRemito", nullable=false)
    private RemitoEntity remito;
	
	
	public ItemRemitoEntity(){}
	


	public ItemRemitoEntity(MateriaPrimaEntity materiaprima, Float cantidad, EstadoRemito estadoremito,
			RemitoEntity remito) {
		super();
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.estadoremito = estadoremito;
		this.remito = remito;
		
	}


	public MateriaPrimaEntity getMateriaprima() {
		return materiaprima;
	}


	public void setMateriaprima(MateriaPrimaEntity materiaprima) {
		this.materiaprima = materiaprima;
	}


	public EstadoRemito getEstadoremito() {
		return estadoremito;
	}

	public void setEstadoremito(EstadoRemito estadoremito) {
		this.estadoremito = estadoremito;
	}

	public RemitoEntity getRemito() {
		return remito;
	}

	public void setRemito(RemitoEntity remito) {
		this.remito = remito;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCodItemRemito() {
		return codItemRemito;
	}

	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}

	
	public ItemRemitoEntity(Float cantidad) {
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
		item.setMateriaprima(materiaprima.toNegocio());

		return item;
	}

	
	
}
