package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import dto.DepositoDTO;
import dto.MateriaPrimaDTO;
import dto.RemitoDTO;
import entities.DepositoEntity;
import entities.MateriaPrimaEntity;
import entities.RemitoEntity;
import entities.SolicitudInsumoEntity;



public class Deposito 
{
	private Integer codDeposito;
	
	public Deposito(){}
	

	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}
	
	
	
	//CON DATOS
	public DepositoDTO toDTO() 
	{
		DepositoDTO d=new DepositoDTO();
		d.setCodDeposito(codDeposito);
		return d;
	}
	
	public DepositoEntity toEntity() {
		
		
		DepositoEntity d=new DepositoEntity();
		d.setCodDeposito(codDeposito);	
		return d;
	}
	
	
}
