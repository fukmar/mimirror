package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="semiElaborados")
public class SemiElaboradoEntity extends ProductoEntity 
{
	@Column(name="costo")
	private double costoProduccion;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="almacenadoComo", nullable = false)
	private UnidadEntity unidad;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="materialSemi",
	joinColumns=@JoinColumn(name="codProducto",referencedColumnName="codProducto"),
	inverseJoinColumns=@JoinColumn(name="codMaterial",referencedColumnName="codMaterial")
	)
	private List<MateriaPrimaEntity> materiales;
	
	@ManyToMany(mappedBy="componentes")
	private List<ElaboradoEntity> productos;
	
	public SemiElaboradoEntity (){}
	
	
	public SemiElaboradoEntity(double costoProduccion, UnidadEntity unidad, List<MateriaPrimaEntity> materiales) {
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
	
	@Override
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
	}
}
