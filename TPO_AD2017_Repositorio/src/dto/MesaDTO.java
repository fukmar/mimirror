package dto;

import java.io.Serializable;

public class MesaDTO implements Serializable
{

	private static final long serialVersionUID = -3372136721217454040L;

	private  Integer codMesa;
	private  Integer cantidadPersonas;
	private  Integer capacidad;
	private  Integer estado;
	private MozoDTO mozo;
	private SectorDTO sector;
	
	public MesaDTO(){}
	

	public MesaDTO(Integer cantidadPersonas, Integer capacidad, Integer estado, MozoDTO mozo,SectorDTO sector) {
		super();
		
		this.cantidadPersonas = cantidadPersonas;
		this.capacidad = capacidad;
		this.estado = estado;
		this.sector=sector;
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




	public MozoDTO getMozo() {
		return mozo;
	}





	public void setMozo(MozoDTO mozo) {
		this.mozo = mozo;
	}

	

	public SectorDTO getSector() {
		return sector;
	}


	public void setSector(SectorDTO sector) {
		this.sector = sector;
	}


	@Override
	public String toString() {
		return "MesaDTO [codMesa=" + codMesa + ", cantidadPersonas=" + cantidadPersonas + ", capacidad=" + capacidad
				+ ", estado=" + estado + ", mozo=" + mozo + ", sector=" + sector + "]";
	}

		
		
		
	


}
