package dto;

import java.io.Serializable;

public class SolicitudDiariaDTO implements Serializable
{

	private static final long serialVersionUID = -6622299816393218449L;
	private Integer codsolicitudDiaria;
	protected DepositoDTO deposito;
	
	public SolicitudDiariaDTO() {
		super();
	}

	public SolicitudDiariaDTO(Integer codsolicitudDiaria, DepositoDTO deposito) {
		super();
		this.codsolicitudDiaria = codsolicitudDiaria;
		this.deposito = deposito;
	}

	public Integer getCodsolicitudDiaria() {
		return codsolicitudDiaria;
	}

	public void setCodsolicitudDiaria(Integer codsolicitudDiaria) {
		this.codsolicitudDiaria = codsolicitudDiaria;
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
