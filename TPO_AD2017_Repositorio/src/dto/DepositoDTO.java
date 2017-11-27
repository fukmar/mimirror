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
	
	public DepositoDTO(){}

	
	public DepositoDTO(Integer codDeposito,List<MateriaPrimaDTO> materiaprima, 
			List<RemitoDTO> remitos) {
		super();
		this.codDeposito = codDeposito;
	}


	
	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}


	@Override
	public String toString() {
		return "DepositoDTO [codDeposito=" + codDeposito + "]";
	}
	
	
}
