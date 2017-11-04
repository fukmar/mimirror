package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="elaborados")
public class ElaboradoEntity extends ProductoEntity 
{
	
	@ManyToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private UnidadEntity unidad;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="compuestoDe",
	joinColumns=@JoinColumn(name="codProductoE",referencedColumnName="codProducto"),
	inverseJoinColumns=@JoinColumn(name="codProductoSM",referencedColumnName="codProducto"))
	private List<SemiElaboradoEntity> componentes;
	
	public ElaboradoEntity(){}
	

	public ElaboradoEntity(String tipo, String calidad, String descripcion, PlanDeProduccionEntity pdp,
			Integer cantidad, Date caducidad, UnidadEntity unidad, List<SemiElaboradoEntity> componentes) {
		super(tipo, calidad, descripcion, pdp, cantidad, caducidad);
		this.unidad = unidad;
		this.componentes = componentes;
	}


	public UnidadEntity getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadEntity unidad) {
		this.unidad = unidad;
	}
	public List<SemiElaboradoEntity> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<SemiElaboradoEntity> componentes) {
		this.componentes = componentes;
	}
}
