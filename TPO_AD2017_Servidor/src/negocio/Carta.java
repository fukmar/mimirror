package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.CartaDTO;
import dto.PlatoDTO;
import entities.CartaEntity;
import entities.PlatoEntity;
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
	
	public CartaEntity toEntity()
	{
		CartaEntity cartaentity=new CartaEntity();
		cartaentity.setCodigoCarta(codigoCarta);
		/*List <PlatoEntity> platosentity=new ArrayList <PlatoEntity>();
		for (Plato pentity:itemCarta)
		{
			platosentity.add(pentity.toEntity());
		} mismo que abajo... en las conversiones no hace falta*/
		cartaentity.setTemporada(temporada);
		cartaentity.setVigencia(vigencia);
		return cartaentity;
	}
	public CartaDTO toDTO()
	{
		CartaDTO cartadto=new CartaDTO();
		cartadto.setCodigoCarta(codigoCarta);
		cartadto.setTemporada(temporada);
		cartadto.setVigencia(vigencia);
		/*List <PlatoDTO> platosdto=new ArrayList <PlatoDTO>();
		for (Plato pl:itemCarta)
		{
			platosdto.add(pl.toDTO());
		} no lo necesitamos y hace que pinche plato cuando pasa carta a dto nahuelito*/
		
		return cartadto;
	}
	

}
