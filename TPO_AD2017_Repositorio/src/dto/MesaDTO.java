package dto;

import java.io.Serializable;

public class MesaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3372136721217454040L;

		private  Integer codMesa;
		private  Integer cantidadPersonas;
		private  Integer capacidad;
		private  Integer estado;
		private  ComandaDTO comanda;
		private MozoDTO mozo;
		private SectorDTO sector;
		
		public MesaDTO(){}
		
		public MesaDTO(Integer codMesa, Integer cantidadPersonas, Integer capacidad, Integer estado, ComandaDTO comanda,
				MozoDTO mozo, SectorDTO sector) {
			super();
			this.codMesa = codMesa;
			this.cantidadPersonas = cantidadPersonas;
			this.capacidad = capacidad;
			this.estado = estado;
			this.comanda = comanda;
			this.mozo = mozo;
			this.sector = sector;
		}

		public Integer getCodMesa() {
			return codMesa;
		}

		public void setCodMesa(Integer codMesa) {
			this.codMesa = codMesa;
		}

		public Integer getCantidadPersonas() {
			return cantidadPersonas;
		}

		public void setCantidadPersonas(Integer cantidadPersonas) {
			this.cantidadPersonas = cantidadPersonas;
		}

		public Integer getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(Integer capacidad) {
			this.capacidad = capacidad;
		}

		public Integer getEstado() {
			return estado;
		}

		public void setEstado(Integer estado) {
			this.estado = estado;
		}

		public ComandaDTO getComanda() {
			return comanda;
		}

		public void setComanda(ComandaDTO comanda) {
			this.comanda = comanda;
		}

		public MozoDTO getMozo() {
			return mozo;
		}

		public void setMozo(MozoDTO mozo) {
			this.mozo = mozo;
		}

		public SectorDTO getSector() {
			return sector;
		}

		public void setSector(SectorDTO sector) {
			this.sector = sector;
		}
		
		
		
		
	


}
