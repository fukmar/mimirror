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
	private List<MateriaPrima> materiaprima;
	private List<Remito> remitos;
	
	

	public Deposito(){}
	
	public Deposito(List<MateriaPrima> materiaprima, 
			List<Remito> remitos) {
		super();
		this.materiaprima = materiaprima;
		this.remitos = remitos;
	}

	public List<Remito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<Remito> remitos) {
		this.remitos = remitos;
	}

	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}
	
	
	public List<MateriaPrima> getMateriaprima() {
		return materiaprima;
	}

	public void setMateriaprima(List<MateriaPrima> materiaprima) {
		this.materiaprima = materiaprima;
	}

	
	//CON DATOS
	public DepositoDTO toDTO() 
	{
		
		List<MateriaPrimaDTO> listaMP=new ArrayList<MateriaPrimaDTO>();
		for(MateriaPrima m:this.getMateriaprima()) 
		{
			listaMP.add(m.toDTO());
		}
		
		List<RemitoDTO> remitoss = new ArrayList<RemitoDTO>();
		for(Remito remitEn: this.remitos) {
			remitoss.add(remitEn.toDTO());
		}
		
		DepositoDTO d=new DepositoDTO(this.codDeposito, listaMP, remitoss);
		return d;
	}
	
	
	//SOLO CODIGO DEL DEPOSITO
	public DepositoDTO toDTO2() 
	{
		
		List<MateriaPrimaDTO> listaMP=null;
		
		
		List<RemitoDTO> remitoss =null;
	
		DepositoDTO d=new DepositoDTO(this.codDeposito, listaMP, remitoss);
		return d;
	}


	public DepositoEntity toEntity() {
		
		
		List<MateriaPrimaEntity> materias = new ArrayList<MateriaPrimaEntity>();
		for(MateriaPrima materiaprima:this.materiaprima ) {
			materias.add(materiaprima.toEntity());
		}
		
		List<RemitoEntity> remitos = new ArrayList<RemitoEntity>();
		for(Remito remitEn: this.remitos) {
			remitos.add(remitEn.toEntity());
		}
		
		
		DepositoEntity depEn=new DepositoEntity(materias, remitos);
			
		return depEn;
	}
	
	
}
