package entities;

import java.util.Date;

import javax.persistence.*;

import negocio.AreaRestaurant;
import negocio.*;


@Entity
//@Table(name="solicitudinsumo")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class SolicitudInsumoEntity {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codSolicitud")
	protected Integer codSolicitudInsumo;
	protected Integer cantidadAPedir;
	
	@OneToOne
	@JoinColumn(name="codMaterial")
	protected MateriaPrimaEntity materiaPrima; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codarea")
	protected AreaRestaurantEntity area;
	protected String responsable;
	protected Integer lote;
	protected Date fechaCompra;
	protected Date fechaVencimiento;
	protected String motivo;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="codDeposito", nullable=false)
	protected DepositoEntity deposito;

	

	public SolicitudInsumoEntity(){
	}
	
	

	public SolicitudInsumoEntity(Integer codSolicitudInsumo,Integer cantidadAPedir, MateriaPrimaEntity materiaPrima,
			AreaRestaurantEntity area, String responsable, Integer lote, Date fechaCompra, Date fechaVencimiento,
			String motivo) {
	
		this.codSolicitudInsumo=codSolicitudInsumo;
		this.cantidadAPedir = cantidadAPedir;
		this.materiaPrima = materiaPrima;
		this.area = area;
		this.responsable = responsable;
		this.lote = lote;
		this.fechaCompra = fechaCompra;
		this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
	}


	
	
	public Integer getCodSolicitudInsumo() {
		return codSolicitudInsumo;
	}

	public void setCodSolicitudInsumo(Integer codSolicitudInsumo) {
		this.codSolicitudInsumo = codSolicitudInsumo;
	}

	public Integer getCantidadAPedir() {
		return cantidadAPedir;
	}

	public void setCantidadAPedir(Integer cantidadAPedir) {
		this.cantidadAPedir = cantidadAPedir;
	}

	public MateriaPrimaEntity getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrimaEntity materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public AreaRestaurantEntity getArea() {
		return area;
	}

	public void setArea(AreaRestaurantEntity area) {
		this.area = area;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public DepositoEntity getDeposito() {
		return deposito;
	}



	public void setDeposito(DepositoEntity deposito) {
		this.deposito = deposito;
	}

	public abstract SolicitudInsumo toNegocio();
	
}
