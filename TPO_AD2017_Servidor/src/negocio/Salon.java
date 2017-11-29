package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dto.SalonDTO;
import dto.SectorDTO;
import entities.LocalEntity;
import entities.SalonEntity;
import entities.SectorEntity;
import enumns.AreaRest;

public class Salon 
{

	protected Integer codSalon;
	private String nombreSalon;
	protected Local local;
	private List<Sector> sectores;
	
	public Salon(){}

	public Salon(String nombreSalon, Local local, List<Sector> sectores) {
		super();
		this.nombreSalon = nombreSalon;
		this.local = local;
		this.sectores = sectores;
	}



	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}

	public Integer getCodSalon() {
		return codSalon;
	}


	public void setCodSalon(Integer codSalon) {
		this.codSalon = codSalon;
	}


	public String getNombreSalon() {
		return nombreSalon;
	}


	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}


	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}


	public SalonEntity toEntity() 
	{
		SalonEntity s=new SalonEntity();
		s.setCodSalon(codSalon);
		s.setLocal(local.toEntity());
		s.setNombreSalon(nombreSalon);
		List <SectorEntity> sectoresentity=new ArrayList<SectorEntity>();
		for (Sector sectornegocio:sectores)
		{
			sectoresentity.add(sectornegocio.toEntity());
		}
		s.setSectores(sectoresentity);
		return s;
	}


	public SalonDTO toDTO() 
	{
		SalonDTO s=new SalonDTO();
		s.setCodSalon(codSalon);
		s.setLocal(local.toDTO());
		s.setNombreSalon(nombreSalon);
		List <SectorDTO> sectoresdto=new ArrayList<SectorDTO>();
		for (Sector sectornegocio:sectores)
		{
			sectoresdto.add(sectornegocio.toDTO());
		}
		s.setSectores(sectoresdto);
		return s;
	}


	
}
