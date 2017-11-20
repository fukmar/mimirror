package dto;

import java.io.Serializable;
import java.util.List;




import enumns.AreaRest;

public class BarraDTO extends AreaRestaurantDTO implements Serializable
{

	/**
	 * 
	 */
private List<ProductoDTO> estimadoDiario;
	
	public BarraDTO(){
		
	}

	
	public BarraDTO(Integer codArea, AreaRest area,
			List<ProductoDTO> estimadoDiario,LocalDTO local) {
		super(codArea, area,local);
		this.estimadoDiario = estimadoDiario;
	}

	public List<ProductoDTO> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<ProductoDTO> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}
	
	
	
	
	
	
	
}
