package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import negocio.Elaborado;
import negocio.SemiElaborado;

@Entity
@Table(name="elaborados")
public class ElaboradoEntity extends ProductoEntity 
{
	
	@ManyToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private UnidadEntity unidad;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE) //cz
	@JoinTable(name="compuestode",
	joinColumns=@JoinColumn(name="codProductoE",referencedColumnName="codProducto"),
	inverseJoinColumns=@JoinColumn(name="codProductoSM",referencedColumnName="codProducto"))
	private List<SemiElaboradoEntity> componentes;
	
	public ElaboradoEntity(){}
	

	public ElaboradoEntity(String tipo, String calidad, String descripcion, PlanDeProduccionEntity pdp,
			Integer cantidad, Date caducidad, UnidadEntity unidad, List<SemiElaboradoEntity> componentes) {
		super(tipo, calidad, descripcion, cantidad, caducidad);
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


	public Elaborado toNegocio() 
	{
		Elaborado e=new Elaborado();
		e.setNumero(getNumero());
		e.setCaducidad(caducidad);
		e.setCalidad(calidad);
		e.setDescripcion(descripcion);
		e.setTipo(tipo);
		e.setUnidad(unidad.toNegocio());
		List <SemiElaborado> semisnegocio=new ArrayList <SemiElaborado>();
		for(SemiElaboradoEntity semi:this.getComponentes())
		{
			semisnegocio.add(semi.toNegocio());
		}
		e.setComponentes(semisnegocio);
		return e;
	}
}
