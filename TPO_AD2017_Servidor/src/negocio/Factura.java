package negocio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dao.FacturaDAO;
import dto.ComandaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import entities.CajaEntity;
import entities.FacturaEntity;
import entities.MesaEntity;
import entities.MozoEntity;
import dto.ItemFacturaDTO;
import enumns.MedioDePago;

public class Factura 
{
	private Integer codFactura;
	private Date fecha;
	private double importe;
	private MedioDePago medioPago;
	private Mesa mesa;
	private Mozo mozo;
	private Caja caja;
	
	
	public Factura(){}


	public Factura(Date fecha, double importe,MedioDePago medioPago, Mesa mesa, Mozo mozo,Caja caja) {
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



	public Caja getCaja() {
		return caja;
	}



	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	//GUARDAR Factura
	public void save() 
	{
		FacturaDAO.getInstance().save(this);
	}

	public FacturaEntity toEntity() 
	
	{
		FacturaEntity f=new FacturaEntity();
		f.setCodFactura(codFactura);
		f.setFecha(fecha);
		f.setImporte(importe);
		f.setMedioPago(medioPago);
		f.setMesa(mesa.toEntity());
		f.setMozo(mozo.toEntity());
		f.setCaja(caja.toEntity());
		return f;
	}
	
}
