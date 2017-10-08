package negocio;

import java.io.Serializable;
import java.util.List;


public class SemiElaborado extends Producto
{
		private Unidad unidad;
		private List<MateriaPrima> materiales;

		public SemiElaborado(){}

		public SemiElaborado(Unidad unidad, List<MateriaPrima> materiales) {
			super();
			this.unidad = unidad;
			this.materiales = materiales;
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
