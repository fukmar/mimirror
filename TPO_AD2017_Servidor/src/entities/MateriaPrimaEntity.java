package entities;
import javax.persistence.*;

import negocio.MateriaPrima;
import negocio.Plato;

@Entity
@Table(name="materiales")
public class MateriaPrimaEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codMaterial")
	private Integer codMaterial;
	
	private String descripcion;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="uniUso")
	private UnidadEntity unidadUso;
	private Float cantidad;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="codDeposito")
    private DepositoEntity deposito;
	


	public MateriaPrimaEntity( String descripcion, UnidadEntity unidadUso, Float cantidad,
			DepositoEntity deposito) {
		super();
		this.descripcion = descripcion;
		this.unidadUso = unidadUso;
		this.cantidad = cantidad;
		this.deposito = deposito;
	}


	public DepositoEntity getDeposito() {
		return deposito;
	}


	public void setDeposito(DepositoEntity deposito) {
		this.deposito = deposito;
	}


	public MateriaPrimaEntity() {}
	
	



	public Integer getCodigo() {
		return codMaterial;
	}
	public void setCodigo(Integer codigo) {
		this.codMaterial = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/*public UnidadEntity getUnidadCompra() {
		return unidadCompra;
	}
	public void setUnidadCompra(UnidadEntity unidadCompra) {
		this.unidadCompra = unidadCompra;
	}*/
	public UnidadEntity getUnidadUso() {
		return unidadUso;
	}
	public void setUnidadUso(UnidadEntity unidadUso) {
		this.unidadUso = unidadUso;
	}
	public Float getCantidad() {
		return cantidad;
	}


	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMaterial == null) ? 0 : codMaterial.hashCode());
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
		MateriaPrimaEntity other = (MateriaPrimaEntity) obj;
		if (codMaterial == null) {
			if (other.codMaterial != null)
				return false;
		} else if (!codMaterial.equals(other.codMaterial))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}


	public MateriaPrima toNegocio() 
	{
		MateriaPrima m=new MateriaPrima();
		m.setCantidad(cantidad);
		m.setCodigo(codMaterial);
		m.setDescripcion(descripcion);
		m.setDeposito(deposito.toNegocio());
		m.setUnidadUso(unidadUso.toNegocio());
		return m;
	}

}
