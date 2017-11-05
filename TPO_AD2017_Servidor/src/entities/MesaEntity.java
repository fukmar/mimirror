package entities;

import negocio.Comanda;
import negocio.Mozo;
import negocio.Sector;
import javax.persistence.*;

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
	private  Comanda comanda;
	
	@ManyToOne
	private Mozo mozo;
	
	@OneToOne
	@JoinColumn(name="codSector")
	private Sector sector;
	
	public MesaEntity(){}
	
	public MesaEntity(Integer codMesa, Integer cantidadPersonas, Integer capacidad, Integer estado, Comanda comanda,
			Mozo mozo, Sector sector) {
		super();
		this.codMesa = codMesa;
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

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
	
	
}

