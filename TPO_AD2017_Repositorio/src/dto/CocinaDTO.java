package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enumns.AreaRest;


public class CocinaDTO extends AreaRestaurantDTO implements Serializable
{

	private List<PlatoDTO> platos;
	private Date horasPrepInternas;
	private List<SemiElaboradoDTO> semiElaborados;
	private List<ProductoDTO> estimadoDiario;
	
	public CocinaDTO(){
	}
	
	
	public CocinaDTO(Integer codArea, AreaRest area, List<PlatoDTO> platos,
			Date horasPrepInternas, List<SemiElaboradoDTO> semiElaborados,
			List<ProductoDTO> estimadoDiario,LocalDTO local) {
		super(codArea, area,local);
		this.platos = platos;
		this.horasPrepInternas = horasPrepInternas;
		this.semiElaborados = semiElaborados;
		this.estimadoDiario = estimadoDiario;
	}
	
	public List<PlatoDTO> getPlatos() {
		return platos;
	}

	public void setPlatos(List<PlatoDTO> platos) {
		this.platos = platos;
	}

	public Date getHorasPrepInternas() {
		return horasPrepInternas;
	}

	public void setHorasPrepInternas(Date horasPrepInternas) {
		this.horasPrepInternas = horasPrepInternas;
	}

	public List<SemiElaboradoDTO> getSemiElaborados() {
		return semiElaborados;
	}

	public void setSemiElaborados(List<SemiElaboradoDTO> semiElaborados) {
		this.semiElaborados = semiElaborados;
	}

	public List<ProductoDTO> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<ProductoDTO> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}

}
