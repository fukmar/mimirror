package entities;
import javax.persistence.*;

import negocio.Unidad;


@Entity
@Table(name="unidades")
public class UnidadEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codUnidad")
	private Integer codigoUni;
	private String descripcion;
	
	public UnidadEntity() {}
	
	public UnidadEntity(Integer codigo, String descripcion) {
		super();
		this.codigoUni = codigo;
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigoUni;
	}
	public void setCodigo(Integer codigo) {
		this.codigoUni = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoUni == null) ? 0 : codigoUni.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadEntity other = (UnidadEntity) obj;
		if (codigoUni == null) {
			if (other.codigoUni != null)
				return false;
		} else if (!codigoUni.equals(other.codigoUni))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}

	public Unidad toNegocio() 
	{
		Unidad u=new Unidad();
		u.setCodigo(codigoUni);
		u.setDescripcion(descripcion);
		return u;
	}
}
