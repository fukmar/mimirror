package negocio;

public class Mesa {
	private  Integer codMesa;
	private  Integer cantidadPersonas;
	private  Integer capacidad;
	private  Integer estado;

	private Mozo mozo;
	private Sector sector;
	
	public Mesa(){}
	
	public Mesa(Integer cantidadPersonas, Integer capacidad, Integer estado,
			Mozo mozo, Sector sector) {
		super();
		
		this.cantidadPersonas = cantidadPersonas;
		this.capacidad = capacidad;
		this.estado = estado;
		
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

