package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="semiElaborados")
public class SemiElaboradoEntity extends ProductoEntity 
{
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="materialSemi",
	joinColumns=@JoinColumn(name="codProducto",referencedColumnName="codProducto"),
	inverseJoinColumns=@JoinColumn(name="codMaterial",referencedColumnName="codMaterial")
	)
	private List<MateriaPrimaEntity> materiales;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="almacenadoComo", nullable = false)
	private UnidadEntity unidad;
	

	@ManyToMany(mappedBy="componentes")
	private List<ElaboradoEntity> productos;
	
	public SemiElaboradoEntity (){}
	
	
	


	public SemiElaboradoEntity(List<MateriaPrimaEntity> materiales, UnidadEntity unidad,
			List<ElaboradoEntity> productos) {
		super();
		this.materiales = materiales;
		this.unidad = unidad;
		this.productos = productos;
	}





	public List<ElaboradoEntity> getProductos() {
		return productos;
	}





	public void setProductos(List<ElaboradoEntity> productos) {
		this.productos = productos;
	}





	public void setMateriales(List<MateriaPrimaEntity> materiales) {
		this.materiales = materiales;
	}





	public UnidadEntity getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadEntity unidad) {
		this.unidad = unidad;
	}
	public List<MateriaPrimaEntity> getMateriales() {
		return materiales;
	}
	public void setMateriales(ArrayList<MateriaPrimaEntity> materiales) {
		this.materiales = materiales;
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
