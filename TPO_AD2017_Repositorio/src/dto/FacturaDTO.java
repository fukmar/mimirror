package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enumns.MedioDePago;

public class FacturaDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5318288962272522660L;
	private Integer codFactura;
	private ComandaDTO comanda;
	private Date fecha;
	private float importe;
	private MedioDePago medioPago;
	private List<ItemFacturaDTO> itemFactura;
	private MesaDTO mesa;
	private MozoDTO mozo;
	
	public FacturaDTO(){}

	public FacturaDTO(Integer codFactura, ComandaDTO comanda, Date fecha, float importe, MedioDePago medioPago,
			List<ItemFacturaDTO> itemFactura, MesaDTO mesa, MozoDTO mozo) {
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

	public ComandaDTO getComanda() {
		return comanda;
	}

	public void setComanda(ComandaDTO comanda) {
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

	public List<ItemFacturaDTO> getItemFactura() {
		return itemFactura;
	}

	public void setItemFactura(List<ItemFacturaDTO> itemFactura) {
		this.itemFactura = itemFactura;
	}

	public MesaDTO getMesa() {
		return mesa;
	}

	public void setMesa(MesaDTO mesa) {
		this.mesa = mesa;
	}

	public MozoDTO getMozo() {
		return mozo;
	}

	public void setMozo(MozoDTO mozo) {
		this.mozo = mozo;
	}

	@Override
	public String toString() {
		return "FacturaDTO [codFactura=" + codFactura + ", comanda=" + comanda + ", fecha=" + fecha + ", importe="
				+ importe + ", medioPago=" + medioPago + ", itemFactura=" + itemFactura + ", mesa=" + mesa + ", mozo="
				+ mozo + "]";
	}
	
	
	
}
