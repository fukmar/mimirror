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
	@JoinColumn(name="codMozo")
	private MozoEntity mozo;
	
	public MesaEntity(){}
	

	public MesaEntity(Integer cantidadPersonas, Integer capacidad, Integer estado, MozoEntity mozo) {
		super();
		
		this.cantidadPersonas = cantidadPersonas;
		this.capacidad = capacidad;
		this.estado = estado;
		
		this.mozo = mozo;
		
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




	public MozoEntity getMozo() {
		return mozo;
	}





	public void setMozo(MozoEntity mozo) {
		this.mozo = mozo;
	}



	
}

