package dto;

import java.io.Serializable;
import java.util.List;

import enumns.AreaRest;

public class CafeteriaDTO extends AreaRestaurantDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5030887150024686841L;

	private List<ProductoDTO> estimadoDiario;

	public CafeteriaDTO(Integer codArea, AreaRest area,
			List<ProductoDTO> estimadoDiario) {
		super(codArea, area);
		this.estimadoDiario = estimadoDiario;
	}

	public List<ProductoDTO> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<ProductoDTO> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	private CafeteriaDTO(){
		
	}

}
