package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import negocio.AreaRestaurant;
import negocio.Deposito;
import negocio.Ingrediente;
import negocio.MateriaPrima;
import negocio.SolicitudDiaria;
import negocio.SolicitudIndividual;
import negocio.SolicitudInsumo;
@Entity
@Table(name="SolicitudesDiarias")
public class SolicitudDiariaEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="codsolicitudDiaria")
	private Integer codsolicitudDiaria;

	@ManyToOne
    @JoinColumn(name="codDeposito", nullable=false)
	protected DepositoEntity deposito;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="codsolicitudDiaria", nullable = true)
	private List<SolicitudIndividualEntity> solicitudes;
	
	
	
	public SolicitudDiariaEntity() {
		// TODO Auto-generated constructor stub
	}
	public SolicitudDiariaEntity( DepositoEntity deposito) {
		super();
		this.deposito = deposito;
	}

	public Integer getCodsolicitudDiaria() {
		return codsolicitudDiaria;
	}



	public void setCodsolicitudDiaria(Integer codsolicitudDiaria) {
		this.codsolicitudDiaria = codsolicitudDiaria;
	}



	public DepositoEntity getDeposito() {
		return deposito;
	}



	public void setDeposito(DepositoEntity deposito) {
		this.deposito = deposito;
	}

	public List<SolicitudIndividualEntity> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<SolicitudIndividualEntity> solicitudes) {
		this.solicitudes = solicitudes;
	}
	public SolicitudDiaria toNegocio() {
		SolicitudDiaria s=new SolicitudDiaria();
		s.setCodsolicitudDiaria(codsolicitudDiaria);
		s.setDeposito(deposito.toNegocio());
		List<SolicitudIndividual> solicitudesnegocio=new ArrayList <SolicitudIndividual>();
		for(SolicitudIndividualEntity si:solicitudes)
		{
			solicitudesnegocio.add(si.toNegocio());
		}
		s.setSolicitudes(solicitudesnegocio);
		return s;
	}	
}
