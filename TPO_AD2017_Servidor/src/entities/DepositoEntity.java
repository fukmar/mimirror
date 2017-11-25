package entities;

import java.util.ArrayList;
import java.util.List;
import negocio.*;
import javax.persistence.*;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="deposito")
public class DepositoEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codDeposito;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="deposito", cascade = CascadeType.ALL)
	private List<MateriaPrimaEntity> materiaprima;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="deposito", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)//ceci
	private List<RemitoEntity> remitos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="deposito", cascade = CascadeType.ALL)
	private List<OrdenDeCompraEntity> ordenDeCompra;
	

	
	public DepositoEntity(){}
	
	public DepositoEntity(Integer codDeposito) {
		super();
		this.codDeposito = codDeposito;
	}

	public DepositoEntity(Integer codDeposito, List<MateriaPrimaEntity> materiaprima, List<RemitoEntity> remitos,
			List<OrdenDeCompraEntity> ordenDeCompra) {
		super();
		this.codDeposito = codDeposito;
		this.materiaprima = materiaprima;
		this.remitos = remitos;
		this.ordenDeCompra = ordenDeCompra;
	}

	public DepositoEntity(List<MateriaPrimaEntity> materiaprima,
			List<RemitoEntity> remitos) {
		super();
	this.materiaprima = materiaprima;
	this.remitos = remitos;
	}
	public List<MateriaPrimaEntity> getMateriaprima() {
		return materiaprima;
	}

	public void setMateriaprima(List<MateriaPrimaEntity> materiaprima) {
		this.materiaprima = materiaprima;
	}


	public List<OrdenDeCompraEntity> getOrdenDeCompra() {
		return ordenDeCompra;
	}

	public void setOrdenDeCompra(List<OrdenDeCompraEntity> ordenDeCompra) {
		this.ordenDeCompra = ordenDeCompra;
	}



	public List<RemitoEntity> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<RemitoEntity> remitos) {
		this.remitos = remitos;
	}

	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}
	
	public Deposito toNegocio()
	{
		
	List<MateriaPrima> materias = new ArrayList<MateriaPrima>();
		for(MateriaPrimaEntity materiaprima:this.materiaprima ) 
		{
			materias.add(materiaprima.toNegocio());
		}
		List<Remito> remitos = new ArrayList<Remito>();
		for(RemitoEntity remitEn: this.remitos) 
		{
			remitos.add(remitEn.toNegocio());
		}
		
		Deposito dep =new Deposito();
		dep.setCodDeposito(codDeposito);
		dep.setMateriaprima(materias);
		dep.setRemitos(remitos);
		return dep;
	}
	
	
	
	
}
