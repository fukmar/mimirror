package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import negocio.Elaborado;
import negocio.Plato;
import negocio.SemiElaborado;

@Entity
@Table(name="semielaborados")
public class SemiElaboradoEntity extends ProductoEntity 
{
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="almacenadoComo", nullable = false)
	private UnidadEntity unidad;
		
	public SemiElaboradoEntity (){}
	
	public SemiElaboradoEntity(String tipo, String calidad, String descripcion,
			Integer cantidad, Date caducidad, UnidadEntity unidad) {
		super(tipo, calidad, descripcion, cantidad, caducidad);
		this.unidad = unidad;
	}


	public UnidadEntity getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadEntity unidad) {
		this.unidad = unidad;
	}
	public SemiElaborado toNegocio() 
	{
		SemiElaborado s=new SemiElaborado();
		s.setCaducidad(caducidad);
		s.setCalidad(calidad);
		s.setCantidad(cantidad);
		s.setDescripcion(descripcion);
		s.setNumero(getNumero());
		s.setTipo(tipo);
		s.setUnidad(unidad.toNegocio());
		return s;
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
