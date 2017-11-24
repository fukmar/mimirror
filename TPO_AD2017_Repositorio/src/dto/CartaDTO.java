package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enumns.Temporada;

public class CartaDTO implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1891945402043915702L;
	private Integer codigoCarta;
	private Date vigencia;
	private Temporada temporada;
	private List<PlatoDTO> itemCarta;
	
	public CartaDTO(){}

	public CartaDTO(Date vigencia, Temporada temporada, List<PlatoDTO> itemCarta) {
		super();
		this.vigencia = vigencia;
		this.temporada = temporada;
		this.itemCarta = itemCarta;
	}

	public Integer getCodigoCarta() {
		return codigoCarta;
	}

	public void setCodigoCarta(Integer codigoCarta) {
		this.codigoCarta = codigoCarta;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public List<PlatoDTO> getItemCarta() {
		return itemCarta;
	}

	public void setItemCarta(List<PlatoDTO> itemCarta) {
		this.itemCarta = itemCarta;
	}

	@Override
	public String toString() {
		return "CartaDTO [codigoCarta=" + codigoCarta + ", vigencia=" + vigencia + ", temporada=" + temporada
				+ ", itemCarta=" + itemCarta + "]";
	}
	
	
}
