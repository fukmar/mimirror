package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ordenesDeCompra")
public class OrdenDeCompraEntity {
	@Id
	@Column(name="codOrdenDeCompra")
	private Integer codOrdenDeCompra;
	private Integer codigoProveedor;
	private String nombreProv;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name="areaRestaurant")
	private AreaRestaurantEntity areaRestaurant;
	@OneToMany
	@JoinColumn(name="productos")
	private List<ItemOrdenDeCompraEntity> productos;
	private Integer minimoDiasVencim;
	private String calidadEsperada;
	
	public OrdenDeCompraEntity(){}

	public OrdenDeCompraEntity(Integer codOrdenDeCompra, Integer codigoProveedor,
			String nombreProv, Date fecha, AreaRestaurantEntity areaRestaurant,
			List<ItemOrdenDeCompraEntity> productos, Integer minimoDiasVencim,
			String calidadEsperada) {
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

	public String getCalidadEsperada() {
		return calidadEsperada;
	}

	public void setCalidadEsperada(String calidadEsperada) {
		this.calidadEsperada = calidadEsperada;
	}
	
	
}