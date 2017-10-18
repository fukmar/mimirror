package entities;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import dto.PlatoDTO;
import enumns.Temporada;

@Entity
@Table(name="cartas")
public class CartaEntity 
{
	@Id
	@Column(name="codCarta")
	private Integer codigoCarta;
	private Date vigencia;
	private Temporada temporada;
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<PlatoEntity> itemCarta;
	
	public CartaEntity(){}

	public CartaEntity(Integer codigoCarta, Date vigencia, Temporada temporada, List<PlatoEntity> itemCarta) {
		super();
		this.codigoCarta = codigoCarta;
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

	public List<PlatoEntity> getItemCarta() {
		return itemCarta;
	}

	public void setItemCarta(List<PlatoEntity> itemCarta) {
		this.itemCarta = itemCarta;
	}

}
