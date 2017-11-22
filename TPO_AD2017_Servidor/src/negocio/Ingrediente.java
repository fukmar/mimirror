package negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import entities.*;

public class Ingrediente {

	private Integer codigocomponente;
	private MateriaPrima materiaprima;
	private Integer cantidad;
	private SemiElaborado platosemielaborado;
	
	
	//Constructores
	
	public Ingrediente() {
		super();
	}
	public Ingrediente(Integer codigocomponente, MateriaPrima materiaprima, Integer cantidad,
			SemiElaborado platosemielaborado) {
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
	public MateriaPrima getMateriaprima() {
		return materiaprima;
	}
	public void setMateriaprima(MateriaPrima materiaprima) {
		this.materiaprima = materiaprima;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public SemiElaborado getPlatosemielaborado() {
		return platosemielaborado;
	}
	public void setPlatosemielaborado(SemiElaborado platosemielaborado) {
		this.platosemielaborado = platosemielaborado;
	}

	public IngredienteEntity toEntity() {
		IngredienteEntity i=new IngredienteEntity();
		i.setCantidad(cantidad);
		i.setCodigocomponente(codigocomponente);
		i.setMateriaprima(materiaprima.toEntity());
		i.setPlatosemielaborado(platosemielaborado.toEntitySemi());
		return i;
	}

}
