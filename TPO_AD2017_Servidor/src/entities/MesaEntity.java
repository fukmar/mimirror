package entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.Comanda;



@Entity
@Table(name="mesas")
public class MesaEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Integer codMesa;
	private  Integer cantidadPersonas;
	private  Integer capacidad;
	private  Integer estado;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codComanda")
	private  ComandaEntity comanda;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codMozo")
	private MozoEntity mozo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codSector")
	private SectorEntity sector;
	
	public MesaEntity(){}
	

	public MesaEntity(Integer cantidadPersonas, Integer capacidad, Integer estado,
			ComandaEntity comanda, MozoEntity mozo, SectorEntity sector) {
		super();
		
		this.cantidadPersonas = cantidadPersonas;
		this.capacidad = capacidad;
		this.estado = estado;
		this.comanda = comanda;
		this.mozo = mozo;
		this.sector = sector;
	}


	public Integer getCodMesa() {
		return codMesa;
	}


	public void setCodMesa(Integer codMesa) {
		this.codMesa = codMesa;
	}



	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}


	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}


	public Integer getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}



	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}





	public ComandaEntity getComanda() {
		return comanda;
	}





	public void setComanda(ComandaEntity comanda) {
		this.comanda = comanda;
	}





	public MozoEntity getMozo() {
		return mozo;
	}





	public void setMozo(MozoEntity mozo) {
		this.mozo = mozo;
	}





	public SectorEntity getSector() {
		return sector;
	}





	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}


	
}

