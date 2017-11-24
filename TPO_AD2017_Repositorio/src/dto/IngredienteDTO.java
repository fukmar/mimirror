package dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import enumns.CategoriaPlato;





public class IngredienteDTO implements Serializable
{


	private Integer codigocomponente;
	private MateriaPrimaDTO materiaprima;
	private Integer cantidad;
	private SemiElaboradoDTO platosemielaborado;
	
	
	//Constructores
	
	public IngredienteDTO() {
		super();
	}
	public IngredienteDTO(Integer codigocomponente, MateriaPrimaDTO materiaprima, Integer cantidad,SemiElaboradoDTO platosemielaborado) 
	{
		super();
		this.codigocomponente = codigocomponente;
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.platosemielaborado = platosemielaborado;
	}


	//Getters y Setters
	
	public Integer getCodigocomponente() {
		return codigocomponente;
	}
	public void setCodigocomponente(Integer codigocomponente) {
		this.codigocomponente = codigocomponente;
	}
	public MateriaPrimaDTO getMateriaprima() {
		return materiaprima;
	}
	public void setMateriaprima(MateriaPrimaDTO materiaprima) {
		this.materiaprima = materiaprima;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public SemiElaboradoDTO getPlatosemielaborado() {
		return platosemielaborado;
	}
	public void setPlatosemielaborado(SemiElaboradoDTO platosemielaborado) {
		this.platosemielaborado = platosemielaborado;
	}

	@Override
	public String toString() {
		return "IngredienteDTO [codigo=" + codigocomponente + ", materiaprima=" + materiaprima + ", cantidad=" + cantidad +", semielaborado=" + platosemielaborado +"]";
	}

	
}
