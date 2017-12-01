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
	private  Integer combinada=0;
	private Integer combinador=0;
	private Integer activa=0;
	public MesaDTO(){}
	

	public MesaDTO(Integer codmesa,Integer cantidadPersonas, Integer capacidad, Integer estado, MozoDTO mozo,SectorDTO sector) {
		super();
		this.codMesa=codmesa; //lo acabo de agregar CZ
		this.cantidadPersonas = cantidadPersonas;
		this.capacidad = capacidad;
		this.estado = estado;
		this.sector=sector;
		this.mozo = mozo;
		
	}


	public Integer getActiva() {
		return activa;
	}


	public void setActiva(Integer activa) {
		this.activa = activa;
	}


	public Integer getCombinador() {
		return combinador;
	}


	public void setCombinador(Integer combinador) {
		this.combinador = combinador;
	}


	public Integer getCombinada() {
		return combinada;
	}


	public void setCombinada(Integer combinada) {
		this.combinada = combinada;
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
				+ ", estado=" + estado + ", mozo=" + mozo.getApellido() + ", sector=" + sector.getDescripcion() + "]";
	}

		
		
		
	


}
