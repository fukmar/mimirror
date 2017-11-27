package entities;
import java.util.Date;

import javax.persistence.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class ProductoEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="codProducto")
	private Integer codigoProd;
	
	protected String tipo;
	protected String calidad;
	protected String descripcion;
	
	protected Integer cantidad;
	protected Date caducidad;
	
	
	public ProductoEntity(){}
	
	


	public ProductoEntity(String tipo, String calidad, String descripcion, 
			Integer cantidad, Date caducidad) {
		super();
		
		this.tipo = tipo;
		this.calidad = calidad;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.caducidad = caducidad;
	}


	public Integer getNumero() {
		return codigoProd;
	}
	public void setNumero(Integer numero) {
		this.codigoProd = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getCalidad() {
		return calidad;
	}




	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}


	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	public Date getCaducidad() {
		return caducidad;
	}




	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

/*


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((codigoProd == null) ? 0 : codigoProd.hashCode());
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
		ProductoEntity other = (ProductoEntity) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (codigoProd == null) {
			if (other.codigoProd != null)
				return false;
		} else if (!codigoProd.equals(other.codigoProd))
			return false;
		return true;
	}*/
}
