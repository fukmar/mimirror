package negocio;

import dao.MesaDAO;
import dto.MesaDTO;
import entities.MesaEntity;
import entities.SectorEntity;

public class Mesa {
	private  Integer codMesa;
	private  Integer cantidadPersonas;
	private  Integer capacidad;
	private  Integer estado;
	private Mozo mozo;
	private Sector sector;
	private  Integer combinada=0;
	private Integer combinador=0;
	private Integer activa=0;
	
	public Mesa(){}
	
	public Mesa(Integer cantidadPersonas, Integer capacidad, Integer estado,Mozo mozo,Sector sector) 
	{
		super();
		
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMesa == null) ? 0 : codMesa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (codMesa == null) {
			if (other.codMesa != null)
				return false;
		} else if (!codMesa.equals(other.codMesa))
			return false;
		return true;
	}

	public MesaEntity toEntity()
{
		MesaEntity m=new MesaEntity();
		m.setCombinada(combinada);
		m.setCodMesa(codMesa);
		m.setCantidadPersonas(cantidadPersonas);
		m.setCapacidad(capacidad);
		m.setEstado(estado);
		m.setCombinador(combinador);
		m.setActiva(activa);
		m.setMozo(mozo.toEntity());
		m.setSector(sector.toEntity());
		return m;
	}

	public MesaDTO toDTO() 
	{ 
		MesaDTO m=new MesaDTO();
		m.setCombinada(combinada);
		m.setCombinador(combinador);
		m.setActiva(activa);
		m.setCodMesa(codMesa);
		m.setEstado(estado);
		m.setCantidadPersonas(cantidadPersonas);
		m.setCapacidad(capacidad);
		m.setMozo(mozo.toDTO());
		m.setSector(sector.toDTO()); //nahueloide
		return m;
	}
	public void save()
	{
		MesaDAO.getInstance().save(this);
	}

}

