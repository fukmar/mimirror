package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enumns.MedioDePago;



public class FacturaDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer codFactura;
	private Date fecha;
	private float importe;
	private MedioDePago medioPago;
	private MesaDTO mesa;
	private MozoDTO mozo;
	private CajaDTO caja;
	
	public FacturaDTO(){}

	

	public FacturaDTO(Date fecha, float importe,MedioDePago medioPago, MesaDTO mesa, MozoDTO mozo,CajaDTO caja) {
		super();
		this.fecha = fecha;
		this.importe = importe;
		this.medioPago = medioPago;
		this.mesa = mesa;
		this.mozo = mozo;
		this.caja=caja;
	}

	public Integer getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(Integer codFactura) {
		this.codFactura = codFactura;
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public CajaDTO getCaja() {
		return caja;
	}



	public void setCaja(CajaDTO caja) {
		this.caja = caja;
	}



	@Override
	public String toString() {
		return "FacturaDTO [codFactura=" + codFactura + ", fecha=" + fecha + ", importe=" + importe + ", medioPago="
				+ medioPago + ", mesa=" + mesa + ", mozo=" + mozo + ", caja=" + caja + "]";
	}



	

	
	
	
	
}
