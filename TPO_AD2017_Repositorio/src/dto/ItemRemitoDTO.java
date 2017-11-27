package dto;

import java.io.Serializable;
import java.util.List;

import enumns.EstadoRemito;



public class ItemRemitoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8398478230128292011L;
	private Integer codItemRemito;
	private Integer cantidad;
	private RemitoDTO remito;
	private EstadoRemito estadoremito;
	private MateriaPrimaDTO materiaprima;
	private List<SolicitudIndividualDTO> solicitudes;

	
	public ItemRemitoDTO(Integer codItemRemito, Integer cantidad, EstadoRemito estadoremito,
			MateriaPrimaDTO materiaprima, List<SolicitudIndividualDTO> solicitudes) {
		super();
		this.codItemRemito = codItemRemito;
		this.cantidad = cantidad;
		this.estadoremito = estadoremito;
		this.materiaprima = materiaprima;
		this.solicitudes = solicitudes;
	}
	

	public ItemRemitoDTO(Integer cantidad, RemitoDTO remito, EstadoRemito estadoremito,
			MateriaPrimaDTO materiaprima, List<SolicitudIndividualDTO> solicitudes) {
		super();
		this.cantidad = cantidad;
		this.remito = remito;
		this.estadoremito = estadoremito;
		this.materiaprima = materiaprima;
		this.solicitudes = solicitudes;
	}


	public ItemRemitoDTO(){}

		public ItemRemitoDTO(Integer cantidad) 
		{
			super();
			this.cantidad = cantidad;
			//this.codItemRemito = codItemRemito;
		}
		
	public List<SolicitudIndividualDTO> getSolicitudes() {
			return solicitudes;
		}


		public void setSolicitudes(List<SolicitudIndividualDTO> solicitudes) {
			this.solicitudes = solicitudes;
		}


	public RemitoDTO getRemito() {
		return remito;
	}

	public void setRemito(RemitoDTO remito) {
		this.remito = remito;
	}


	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	public Integer getCodItemRemito() {
		return codItemRemito;
	}

	public void setCodItemRemito(Integer codItemRemito) {
		this.codItemRemito = codItemRemito;
	}

	
	public EstadoRemito getEstadoremito() {
		return estadoremito;
	}

	public void setEstadoremito(EstadoRemito estadoremito) {
		this.estadoremito = estadoremito;
	}


	public MateriaPrimaDTO getMateriaprima() {
		return materiaprima;
	}


	public void setMateriaprima(MateriaPrimaDTO materiaprima) {
		this.materiaprima = materiaprima;
	}
	

	
}
