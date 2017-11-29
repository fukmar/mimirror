package negocio;

import java.util.ArrayList;
import java.util.List;

import dto.MesaDTO;
import dto.SectorDTO;
import entities.MesaEntity;
import entities.SectorEntity;


public class Sector 
{
	private Integer codSector;
	private String descripcion;
	private Salon salon;
	private List<Mesa> mesas ;
	
	
	public Sector(){}

	public Sector(String descripcion,Salon salon)
	{
		super();
		
		this.descripcion = descripcion;
		this.salon=salon;
	}
	

	public Sector(String descripcion, Salon salon, List<Mesa> mesas) {
		super();
		this.descripcion = descripcion;
		this.salon = salon;
		this.mesas = mesas;
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

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public SectorDTO toDTO() 
	{
		SectorDTO s=new SectorDTO();
		s.setCodSector(codSector);
		s.setDescripcion(descripcion);
		s.setSalon(salon.toDTO());
		List <MesaDTO> mesasdto=new ArrayList <MesaDTO>();
		for (Mesa m : mesas)
		{
			mesasdto.add(m.toDTO());
		}
		s.setMesas(mesasdto);
		return s;
	}

	public SectorEntity toEntity() 
	{
		SectorEntity s=new SectorEntity();
		s.setCodSector(codSector);
		s.setDescripcion(descripcion);
		s.setSalon(salon.toEntity());
		return s;
	}
}
