package negocio;

import java.util.Date;
import java.util.List;

public class OrdenDeCompra {
	
	private Integer codOrdenDeCompra;
	private Integer codigoProveedor;
	private String nombreProv;
	private Date fecha;
	private AreaRestaurant areaRestaurant;
	private List<ItemOrdenDeCompra> productos;
	private Integer minimoDiasVencim;
	private String calidadEsperada;
	
	public OrdenDeCompra(){}

	public OrdenDeCompra(Integer codOrdenDeCompra, Integer codigoProveedor,
			String nombreProv, Date fecha, AreaRestaurant areaRestaurant,
			List<ItemOrdenDeCompra> productos, Integer minimoDiasVencim,
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

	public AreaRestaurant getAreaRestaurant() {
		return areaRestaurant;
	}

	public void setAreaRestaurant(AreaRestaurant areaRestaurant) {
		this.areaRestaurant = areaRestaurant;
	}

	public List<ItemOrdenDeCompra> getProductos() {
		return productos;
	}

	public void setProductos(List<ItemOrdenDeCompra> productos) {
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
