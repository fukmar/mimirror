package negocio;

import java.io.Serializable;
import java.util.List;

import dto.MateriaPrimaDTO;
import dto.ProductoDTO;
import dto.UnidadDTO;

public class SemiElaborado extends Producto
{

		private double costoProduccion;
		private Unidad unidad;
		private List<MateriaPrima> materiales;

		public SemiElaborado(){}

		public SemiElaborado(double costoProduccion, Unidad unidad, List<MateriaPrima> materiales) {
			super();
			this.costoProduccion = costoProduccion;
			this.unidad = unidad;
			this.materiales = materiales;
		}

		public double getCostoProduccion() {
			return costoProduccion;
		}

		public void setCostoProduccion(double costoProduccion) {
			this.costoProduccion = costoProduccion;
		}

		public Unidad getUnidad() {
			return unidad;
		}

		public void setUnidad(Unidad unidad) {
			this.unidad = unidad;
		}

		public List<MateriaPrima> getMateriales() {
			return materiales;
		}

		public void setMateriales(List<MateriaPrima> materiales) {
			this.materiales = materiales;
		}

}
