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
import entities.DepositoEntity;
import entities.MateriaPrimaEntity;
import entities.RemitoEntity;
import entities.SolicitudInsumoEntity;



public class Deposito 
{
	private Integer codDeposito;
	private List<MateriaPrima> materiaprima;
	private List<SolicitudInsumo> solicitudes;
	private List<Remito> remitos;
	
	

	public Deposito(){}
	
	public Deposito(List<MateriaPrima> materiaprima, List<SolicitudInsumo> solicitudes,
			List<Remito> remitos) {
		super();
		this.materiaprima = materiaprima;
		this.solicitudes = solicitudes;
		this.remitos = remitos;
	}


	public List<SolicitudInsumo> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudInsumo> solicitudes) {
		this.solicitudes = solicitudes;
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

	public DepositoDTO toDTO() 
	{
		DepositoDTO d=new DepositoDTO();
		d.setCodDeposito(codDeposito);
		List<MateriaPrima> listaMP=new ArrayList<MateriaPrima>();
		/*for(MateriaPrima m:listaMP) 
		{
			listaMP.add(m.toDTO());
		}*/
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
		
		List<SolicitudInsumoEntity> solicitudes=new ArrayList<SolicitudInsumoEntity>();
		for(SolicitudInsumo solEn: this.getSolicitudes()) {
			solicitudes.add(solEn.toEntity());
		}
		
		
		DepositoEntity depEn=new DepositoEntity(materias, solicitudes, remitos);
			
		return depEn;
	}
	
	
}
