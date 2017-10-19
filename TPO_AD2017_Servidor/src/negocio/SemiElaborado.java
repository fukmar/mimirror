package negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SemiElaborado extends Producto
{
		private List<MateriaPrima> materiales;
		private Unidad unidad;
		

		public SemiElaborado(){}

		
		public SemiElaborado(Integer numero, String tipo, String calidad, String descripcion, PlanDeProduccion pdp,
				Integer cantidad, Date caducidad, List<MateriaPrima> materiales, Unidad unidad) {
			super(numero, tipo, calidad, descripcion, pdp, cantidad, caducidad);
			this.materiales = materiales;
			this.unidad = unidad;
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
