package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import enumns.CalidadEsperada;

@Entity
@Table(name="ordenesDeCompra")
public class OrdenDeCompraEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codOrdenDeCompra")
	private Integer codOrdenDeCompra;
	
	
	private Integer codigoProveedor;
	
	@Column(name="nombreProveedor")
	private String nombreProv;
	
	private Date fecha;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="areaRestaurant")
	private AreaRestaurantEntity areaRestaurant;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="ordenDeCompra", cascade=CascadeType.ALL)
	private List<ItemOrdenDeCompraEntity> productos;
	
	private Integer minimoDiasVencim;
	
	@Enumerated(EnumType.STRING)
	private CalidadEsperada calidadEsperada;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="codDeposito", nullable=false)
    private DepositoEntity deposito;
	
	
	public OrdenDeCompraEntity(){}


	public OrdenDeCompraEntity(Integer codOrdenDeCompra,
			Integer codigoProveedor, String nombreProv, Date fecha,
			AreaRestaurantEntity areaRestaurant,
			List<ItemOrdenDeCompraEntity> productos, Integer minimoDiasVencim,
			CalidadEsperada calidadEsperada) {
		super();
		this.codOrdenDeCompra = codOrdenDeCompra;
		this.codigoProveedor = codigoProveedor;
		this.nombreProv = nombreProv;
		this.fecha = fecha;
		this.areaRestaurant = areaRestaurant;
		this.productos = productos;
		this.minimoDiasVencim = minimoDiasVencim;
		this.calidadEsperada = calidadEsperada;
	}


	public Integer getCodOrdenDeCompra() {
		return codOrdenDeCompra;
	}


	public void setCodOrdenDeCompra(Integer codOrdenDeCompra) {
		this.codOrdenDeCompra = codOrdenDeCompra;
	}


	public Integer getCodigoProveedor() {
		return codigoProveedor;
	}


	public void setCodigoProveedor(Integer codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}


	public String getNombreProv() {
		return nombreProv;
	}


	public void setNombreProv(String nombreProv) {
		this.nombreProv = nombreProv;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public AreaRestaurantEntity getAreaRestaurant() {
		return areaRestaurant;
	}


	public void setAreaRestaurant(AreaRestaurantEntity areaRestaurant) {
		this.areaRestaurant = areaRestaurant;
	}


	public List<ItemOrdenDeCompraEntity> getProductos() {
		return productos;
	}


	public void setProductos(List<ItemOrdenDeCompraEntity> productos) {
		this.productos = productos;
	}


	public Integer getMinimoDiasVencim() {
		return minimoDiasVencim;
	}


	public void setMinimoDiasVencim(Integer minimoDiasVencim) {
		this.minimoDiasVencim = minimoDiasVencim;
	}


	public CalidadEsperada getCalidadEsperada() {
		return calidadEsperada;
	}


	public void setCalidadEsperada(CalidadEsperada calidadEsperada) {
		this.calidadEsperada = calidadEsperada;
	}


	

	
	
}
