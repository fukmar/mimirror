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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codDeposito;
	
	public DepositoEntity(){}
	
	public DepositoEntity(Integer codDeposito) {
		super();
		this.codDeposito = codDeposito;
	}


	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}
	
	public Deposito toNegocio()
	{
		Deposito d= new Deposito ();
		d.setCodDeposito(codDeposito);
		return d;
	}

	
}
