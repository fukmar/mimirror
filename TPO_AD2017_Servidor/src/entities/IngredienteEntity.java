package entities;

import java.util.ArrayList;
import java.util.List;

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

import negocio.Elaborado;
import negocio.Ingrediente;
import negocio.Plato;

@Entity
@Table(name="ingredientes")
public class IngredienteEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codItemReceta")
	private Integer codigocomponente;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private MateriaPrimaEntity materiaprima;
	
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name="codigoSemielaborado")
	private SemiElaboradoEntity platosemielaborado;
	
	
	//Constructores
	public IngredienteEntity() {
		super();
	}

	public IngredienteEntity(MateriaPrimaEntity materiaprima, Integer cantidad,
			SemiElaboradoEntity platosemielaborado) {
		super();
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
		this.platosemielaborado = platosemielaborado;
	}
	public IngredienteEntity(MateriaPrimaEntity materiaprima, Integer cantidad) {
		super();
		this.materiaprima = materiaprima;
		this.cantidad = cantidad;
	}

	//Getters y Setters



	public MateriaPrimaEntity getMateriaprima() {
		return materiaprima;
	}

	public void setMateriaprima(MateriaPrimaEntity materiaprima) {
		this.materiaprima = materiaprima;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCodigocomponente() {
		return codigocomponente;
	}

	public void setCodigocomponente(Integer codigocomponente) {
		this.codigocomponente = codigocomponente;
	}

	public SemiElaboradoEntity getPlatosemielaborado() {
		return platosemielaborado;
	}

	public void setPlatosemielaborado(SemiElaboradoEntity platosemielaborado) {
		this.platosemielaborado = platosemielaborado;
	}

	public Ingrediente toNegocio() {
		Ingrediente i=new Ingrediente();
		i.setCantidad(cantidad);
		i.setCodigocomponente(codigocomponente);
		i.setMateriaprima(materiaprima.toNegocio());
		i.setPlatosemielaborado(platosemielaborado.toNegocio());
		return i;
	}
	
}
