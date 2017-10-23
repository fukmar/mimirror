package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class OrdenDeCompraDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8448652617966217298L;

	
	
	private Integer codOrdenDeCompra;
	private Integer codigoProveedor;
	private String nombreProv;
	private Date fecha;
	private AreaRestaurantDTO areaRestaurant;
	private List<ItemOrdenDeCompraDTO> productos;
	private Integer minimoDiasVencim;
	private String calidadEsperada;
	
	public OrdenDeCompraDTO(){}

	public OrdenDeCompraDTO(Integer codOrdenDeCompra, Integer codigoProveedor,
			String nombreProv, Date fecha, AreaRestaurantDTO areaRestaurant,
			List<ItemOrdenDeCompraDTO> productos, Integer minimoDiasVencim,
			String caldiadEsperada) {
		super();
		this.codOrdenDeCompra = codOrdenDeCompra;
		this.codigoProveedor = codigoProveedor;
		this.nombreProv = nombreProv;
		this.fecha = fecha;
		this.areaRestaurant = areaRestaurant;
		this.productos = productos;
		this.minimoDiasVencim = minimoDiasVencim;
		this.calidadEsperada = caldiadEsperada;
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

	public AreaRestaurantDTO getAreaRestaurant() {
		return areaRestaurant;
	}

	public void setAreaRestaurant(AreaRestaurantDTO areaRestaurant) {
		this.areaRestaurant = areaRestaurant;
	}

	public List<ItemOrdenDeCompraDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ItemOrdenDeCompraDTO> productos) {
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

	public void setCaldiadEsperada(String caldiadEsperada) {
		this.calidadEsperada = caldiadEsperada;
	}
	
}
