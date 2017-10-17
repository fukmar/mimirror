package negocio;

import java.util.Date;
import java.util.List;

import dto.ComandaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.itemFacturaDTO;
import enumns.MedioDePago;

public class Factura 
{
	private Integer codFactura;
	private Comanda comanda;
	private Date fecha;
	private float importe;
	private MedioDePago medioPago;
	private List<itemFactura> itemFactura;
	private Mesa mesa;
	private Mozo mozo;
	
	public Factura(){}

	public Factura(Integer codFactura, Comanda comanda, Date fecha, float importe, MedioDePago medioPago,
			List<itemFactura> itemFactura, Mesa mesa, Mozo mozo) {
		super();
		this.codFactura = codFactura;
		this.comanda = comanda;
		this.fecha = fecha;
		this.importe = importe;
		this.medioPago = medioPago;
		this.itemFactura = itemFactura;
		this.mesa = mesa;
		this.mozo = mozo;
	}

	public Integer getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(Integer codFactura) {
		this.codFactura = codFactura;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public MedioDePago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioDePago medioPago) {
		this.medioPago = medioPago;
	}

	public List<itemFactura> getItemFactura() {
		return itemFactura;
	}

	public void setItemFactura(List<itemFactura> itemFactura) {
		this.itemFactura = itemFactura;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}
}
