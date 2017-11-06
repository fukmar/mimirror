package negocio;

import java.util.List;

import dto.MozoDTO;
import entities.MesaEntity;

public class Sector 
{
	private Integer codSector;
	private String descripcion;
	private List<Mozo> mozo;
	private List<Mesa> mesa;

	public Sector(){}

	public Sector(String descripcion, List<Mozo> mozo, List<Mesa> mesa) {
		super();
	
		this.descripcion = descripcion;
		this.mozo = mozo;
		this.mesa = mesa;
	}

	public Integer getCodSector() {
		return codSector;
	}

	public void setCodSector(Integer codSector) {
		this.codSector = codSector;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Mozo> getMozo() {
		return mozo;
	}

	public void setMozo(List<Mozo> mozo) {
		this.mozo = mozo;
	}
	
	public List<Mesa> getMesa() {
		return mesa;
	}

	public void setMesa(List<Mesa> mesa) {
		this.mesa = mesa;
	}
}
