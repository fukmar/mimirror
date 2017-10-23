package dto;

import java.io.Serializable;
import java.util.List;




import enumns.AreaRest;

public class BarraDTO extends AreaRestaurantDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4385868703455307705L;
	private List<ProductoDTO> estimadoDiario;
	public BarraDTO(){
		
	}

	public BarraDTO(Integer codArea, AreaRest area, List<ProductoDTO> estimadoDiario) {
		super(codArea, area);
		this.estimadoDiario = estimadoDiario;
	}

	public List<ProductoDTO> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<ProductoDTO> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	
	
	
	
	
	
}
