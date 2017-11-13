package negocio;

import java.util.Date;
import java.util.List;

import dto.PlatoDTO;
import enumns.Temporada;

public class Carta 
{
	private Integer codigoCarta;
	private Date vigencia;
	private Temporada temporada;
	private List<Plato> itemCarta;
	
	public Carta(){}

	public Carta(Date vigencia, Temporada temporada, List<Plato> itemCarta) {
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

	public List<Plato> getItemCarta() {
		return itemCarta;
	}

	public void setItemCarta(List<Plato> itemCarta) {
		this.itemCarta = itemCarta;
	}

}
