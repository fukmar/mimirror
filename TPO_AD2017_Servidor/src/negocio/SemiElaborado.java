package negocio;

import java.io.Serializable;
import java.util.List;


public class SemiElaborado extends Producto
{
		private List<MateriaPrima> materiales;
		private Unidad unidad;
		

		public SemiElaborado(){}

		public SemiElaborado(List<MateriaPrima> materiales,Unidad unidad ) {
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
