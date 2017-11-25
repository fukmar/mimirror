package dto;

import java.io.Serializable;
import java.util.List;

public class SolicitudDiariaDTO implements Serializable
{

	private static final long serialVersionUID = -6622299816393218449L;
	private Integer codsolicitudDiaria;
	protected DepositoDTO deposito;
	private List<SolicitudIndividualDTO> solicitudes;
	
	public SolicitudDiariaDTO() {
		super();
	}



	public SolicitudDiariaDTO(DepositoDTO deposito, List<SolicitudIndividualDTO> solicitudes) {
		super();
		this.deposito = deposito;
		this.solicitudes = solicitudes;
	}



	public SolicitudDiariaDTO(Integer codsolicitudDiaria, DepositoDTO deposito,
			List<SolicitudIndividualDTO> solicitudes) {
		super();
		this.codsolicitudDiaria = codsolicitudDiaria;
		this.deposito = deposito;
		this.solicitudes = solicitudes;
	}



	public Integer getCodsolicitudDiaria() {
		return codsolicitudDiaria;
	}

	public void setCodsolicitudDiaria(Integer codsolicitudDiaria) {
		this.codsolicitudDiaria = codsolicitudDiaria;
	}

	public List<SolicitudIndividualDTO> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudIndividualDTO> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public DepositoDTO getDeposito() {
		return deposito;
	}

	public void setDeposito(DepositoDTO deposito) {
		this.deposito = deposito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SolicitudDiariaDTO [codigosolicitud=" + codsolicitudDiaria + ", deposito=" + deposito + "]";
	}
}
