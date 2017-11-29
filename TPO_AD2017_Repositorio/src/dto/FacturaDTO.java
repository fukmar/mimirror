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
	private double importe;
	private MedioDePago medioPago;
	private MesaDTO mesa;
	
	public FacturaDTO(){}

	

	public FacturaDTO(Date fecha, double importe,MedioDePago medioPago, MesaDTO mesa) {
		super();
		this.fecha = fecha;
		this.importe = importe;
		this.medioPago = medioPago;
		this.mesa = mesa;
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

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "FacturaDTO [codFactura=" + codFactura + ", fecha=" + fecha + ", importe=" + importe + ", medioPago="
				+ medioPago + ", mesa=" + mesa +"]";
	}	
	
}
