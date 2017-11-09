package entities;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtil;
import negocio.Producto;

@Entity
@Table(name="itemRemitos")
public class ItemRemitoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codItemRemito")
	private Integer codItemRemito;
	private Integer cantidad;
	
	
	public RemitoEntity getRemito() {
		return remito;
	}

	public void setRemito(RemitoEntity remito) {
		this.remito = remito;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codRemito", nullable=false)
    private RemitoEntity remito;
		
	public ItemRemitoEntity(){}

	public ItemRemitoEntity(Integer cantidad) {
		super();
		this.cantidad = cantidad;
	
		//this.codItemRemito = codItemRemito;
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

	
	
}
