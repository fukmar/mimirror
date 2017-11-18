package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="semielaborados")
public class SemiElaboradoEntity extends ProductoEntity 
{

	@OneToMany
	@JoinColumn(name="codItemReceta")
	private List<IngredienteEntity> receta;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="almacenadoComo", nullable = false)
	private UnidadEntity unidad;
		
	public SemiElaboradoEntity (){}
	
	
	public SemiElaboradoEntity(String tipo, String calidad, String descripcion,
			PlanDeProduccionEntity pdp, Integer cantidad, Date caducidad, List<MateriaPrimaEntity> materiales,
			UnidadEntity unidad) {
		super(tipo, calidad, descripcion, pdp, cantidad, caducidad);
		this.unidad = unidad;
	
	}

	public List<IngredienteEntity> getReceta() {
		return receta;
	}


	public void setReceta(List<IngredienteEntity> receta) {
		this.receta = receta;
	}


	public UnidadEntity getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadEntity unidad) {
		this.unidad = unidad;
	}
	
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(costoProduccion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SemiElaboradoEntity other = (SemiElaboradoEntity) obj;
		if (Double.doubleToLongBits(costoProduccion) != Double
				.doubleToLongBits(other.costoProduccion))
			return false;
		return true;
	}*/
}
