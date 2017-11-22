package entities;

import java.util.ArrayList;
import java.util.List;
import negocio.*;
import javax.persistence.*;

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
	private List<SolicitudInsumoEntity> solicitudes;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="deposito", cascade = CascadeType.ALL)
	private List<RemitoEntity> remitos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="deposito", cascade = CascadeType.ALL)
	private List<OrdenDeCompraEntity> ordenDeCompra;
	
	public List<MateriaPrimaEntity> getMateriaprima() {
		return materiaprima;
	}

	public void setMateriaprima(List<MateriaPrimaEntity> materiaprima) {
		this.materiaprima = materiaprima;
	}

	
	public DepositoEntity(){}
	
	public DepositoEntity(List<MateriaPrimaEntity> materiaprima, List<SolicitudInsumoEntity> solicitudes,
			List<RemitoEntity> remitos) {
		super();
		this.materiaprima = materiaprima;
		this.solicitudes = solicitudes;
		this.remitos = remitos;
	}


	public List<SolicitudInsumoEntity> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudInsumoEntity> solicitudes) {
		this.solicitudes = solicitudes;
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
	
	public Deposito toNegocio() {
		
		List<MateriaPrima> materias = new ArrayList<MateriaPrima>();
		for(MateriaPrimaEntity materiaprima:this.materiaprima ) {
			materias.add(materiaprima.toNegocio());
		}
		
		List<Remito> remitos = new ArrayList<Remito>();
		for(RemitoEntity remitEn: this.remitos) {
			remitos.add(remitEn.toNegocio());
		}
		
		List<SolicitudInsumo> solicitudes=new ArrayList<SolicitudInsumo>();
		for(SolicitudInsumoEntity solEn: this.getSolicitudes()) {
			solicitudes.add(solEn.toNegocio());
		}
		
		Deposito deposito =new Deposito(materias, solicitudes, remitos);
		return deposito;
	}
	
	
	
	
}
