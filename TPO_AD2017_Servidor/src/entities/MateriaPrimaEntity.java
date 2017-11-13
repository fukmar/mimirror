package entities;
import javax.persistence.*;

import negocio.MateriaPrima;

@Entity
@Table(name="materiales")
public class MateriaPrimaEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codMaterial")
	private Integer codigo;
	
	private String descripcion;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="uniUso")
	private UnidadEntity unidadUso;
	private Float cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="codDeposito", nullable=false)
    private DepositoEntity deposito;
	

		public MateriaPrimaEntity(String descripcion, UnidadEntity unidadUso, Float cantidad) {
		super();
	
		this.descripcion = descripcion;
		this.unidadUso = unidadUso;
		this.setCantidad(cantidad);
	}


	public DepositoEntity getDeposito() {
		return deposito;
	}


	public void setDeposito(DepositoEntity deposito) {
		this.deposito = deposito;
	}


	public MateriaPrimaEntity() {}
	
	



	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
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
		m.setCodigo(codigo);
		m.setDescripcion(descripcion);
		//m.setUnidadCompra(unidadCompra.toNegocio());
		m.setUnidadUso(unidadUso.toNegocio());
		return m;
	}


	public Float getCantidad() {
		return cantidad;
	}


	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
}
