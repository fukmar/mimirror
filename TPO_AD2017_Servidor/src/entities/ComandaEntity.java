package entities;

import java.util.List;

import javax.persistence.*;

import negocio.Comanda;
import negocio.Factura;
import negocio.ItemComanda;
import negocio.Mesa;
import negocio.Mozo;
import entities.FacturaEntity;
import enumns.Estado;

@Entity
@Table(name="comandas")
public class ComandaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codComanda;
	private Estado estado;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dni")
	private MozoEntity mozo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codMesa")
	private MesaEntity mesa;
	
	
	//@ManyToOne(cascade= CascadeType.ALL)
//	@JoinColumn(name="codCaja")
//	private CajaEntity caja;
	
	
	public ComandaEntity(MozoEntity mozo, MesaEntity mesa,/*,CajaEntity caja,*/Estado estado) {
		super();
		this.mozo = mozo;
		this.mesa = mesa;
		//this.caja=caja;
		this.estado=estado;
	}

	public ComandaEntity(){}

	public Integer getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(Integer codComanda) {
		this.codComanda = codComanda;
	}

	
	public MozoEntity getMozo() {
		return mozo;
	}

	public void setMozo(MozoEntity mozo) {
		this.mozo = mozo;
	}

	public MesaEntity getMesa() {
		return mesa;
	}

	public void setMesa(MesaEntity mesa) {
		this.mesa = mesa;
	}

	/*public CajaEntity getCaja() {
		return caja;
	}

	public void setCaja(CajaEntity caja) {
		this.caja = caja;
	}*/

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Comanda toNegocio() 
	{
		Comanda c=new Comanda();
		c.setCodComanda(codComanda);
		c.setMozo(mozo.toNegocio());
		c.setMesa(mesa.toNegocio());
		c.setEstado(estado);
		return c;
	}
	
	


}