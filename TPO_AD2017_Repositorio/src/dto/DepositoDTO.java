package dto;

import java.io.Serializable;
import java.util.List;


public class DepositoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4076114728695091338L;
	private Integer codDeposito;
	private List<MateriaPrimaDTO> materiaprima;
	private List<SolicitudInsumoDTO> solicitudes;
	private List<RemitoDTO> remitos;
	
	public DepositoDTO(){}

	
	public DepositoDTO(/*Integer codDeposito, */List<MateriaPrimaDTO> materiaprima, List<SolicitudInsumoDTO> solicitudes,
			List<RemitoDTO> remitos) {
		super();
		//this.codDeposito = codDeposito;
		this.materiaprima = materiaprima;
		this.solicitudes = solicitudes;
		this.remitos = remitos;
	}


	

	public List<MateriaPrimaDTO> getMateriaprima() {
		return materiaprima;
	}


	public void setMateriaprima(List<MateriaPrimaDTO> materiaprima) {
		this.materiaprima = materiaprima;
	}


	public List<SolicitudInsumoDTO> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudInsumoDTO> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public List<RemitoDTO> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<RemitoDTO> remitos) {
		this.remitos = remitos;
	}

	
	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}


	@Override
	public String toString() {
		return "DepositoDTO [codDeposito=" + codDeposito + ", materiaprima=" + materiaprima + ", solicitudes="
				+ solicitudes + ", remitos=" + remitos + "]";
	}
	
	
}
