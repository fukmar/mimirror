package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import dto.ComandaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.ItemFacturaDTO;
import enumns.*;
import negocio.Factura;

@Entity
@Table(name="facturas")
public class FacturaEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codFactura")
	private Integer codFactura;
	
	
	private Date fecha;
	private double importe;
	
	@Enumerated(EnumType.STRING)
	private MedioDePago medioPago;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="codMesa")
	private MesaEntity mesa;
	
	
	public FacturaEntity(){}

	

	public FacturaEntity(Integer codFactura,Date fecha, double importe,MedioDePago medioPago, MesaEntity mesa) {
		super();
		this.codFactura=codFactura;
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


	public MesaEntity getMesa() {
		return mesa;
	}

	public void setMesa(MesaEntity mesa) {
		this.mesa = mesa;
	} 

	public Factura toNegocio() {
		Factura f=new Factura();
		f.setCodFactura(codFactura);
		f.setFecha(fecha);
		f.setImporte(importe); 
		f.setMedioPago(medioPago);
		f.setMesa(mesa.toNegocio());
		return f;
	}
	
}
