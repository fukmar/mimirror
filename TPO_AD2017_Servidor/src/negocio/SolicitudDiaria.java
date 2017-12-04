package negocio;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import dao.SolicitudDiariaDAO;
import dao.SolicitudIndividualDAO;
import dto.SolicitudDiariaDTO;
import entities.DepositoEntity;
import entities.SolicitudDiariaEntity;
import entities.SolicitudIndividualEntity;
public class SolicitudDiaria {
	private static final long serialVersionUID = 1L;

	private Integer codsolicitudDiaria;
	protected Deposito deposito;
	private List<SolicitudIndividual> solicitudes;

	
	
	
	public SolicitudDiaria(){	
	}
	
	public SolicitudDiaria(Integer codsolicitudDiaria, Deposito deposito) {
		super();
		this.codsolicitudDiaria = codsolicitudDiaria;
		this.deposito = deposito;
	}


	public SolicitudDiaria(Deposito deposito, List<SolicitudIndividual> solicitudes) {
		super();
		this.deposito = deposito;
		this.solicitudes = solicitudes;
	}

	public Integer getCodsolicitudDiaria() {
		return codsolicitudDiaria;
	}

	public void setCodsolicitudDiaria(Integer codsolicitudDiaria) {
		this.codsolicitudDiaria = codsolicitudDiaria;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<SolicitudIndividual> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudIndividual> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public SolicitudDiariaEntity toEntity() {
	SolicitudDiariaEntity s=new SolicitudDiariaEntity();
	s.setCodsolicitudDiaria(codsolicitudDiaria);
	s.setDeposito(deposito.toEntity());
	List<SolicitudIndividualEntity> solicitudesnegocio=new ArrayList <SolicitudIndividualEntity>();
	for(SolicitudIndividual sn:solicitudes)
	{
		solicitudesnegocio.add(sn.toEntity());
	}
	s.setSolicitudes(solicitudesnegocio);
	return s;
	}
	
	public SolicitudDiariaDTO toDTO() {
		return null;
	}
	
	public void save()
	{
		SolicitudDiariaDAO.getInstance().save(this);
		
	}

}
