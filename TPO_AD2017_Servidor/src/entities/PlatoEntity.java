package entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import enumns.AreaRest;
import enumns.CategoriaPlato;
import negocio.Elaborado;
import negocio.Plato;
import negocio.SemiElaborado;


@Entity
@Table(name="platos")
public class PlatoEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codPlato")
	private Integer codPlato;
	private String nombre;
	private float precio;
	private CategoriaPlato categoria;
	private AreaRest area;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)  //cz
	@JoinTable(name="platocompuestode",
	joinColumns=@JoinColumn(name="codPlato",referencedColumnName="codPlato"),
	inverseJoinColumns=@JoinColumn(name="codProducto",referencedColumnName="codProducto"))
	private List<ElaboradoEntity> productoPlato;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="codCarta")
    private CartaEntity carta;
	
	/*	public PlatoEntity(Integer codigo, String nombre, float precio, CategoriaPlato categoria,
	List<ElaboradoEntity> productoPlato, CartaEntity carta) {
super();
this.codigo = codigo;
this.nombre = nombre;
this.precio = precio;
this.categoria = categoria;
this.productoPlato = productoPlato;
this.carta = carta;
}*/

public PlatoEntity(String nombre, float precio,AreaRest area, CategoriaPlato categoria, List<ElaboradoEntity> productoPlato/*,
	CartaEntity carta*/) {
super();
this.nombre = nombre;
this.precio = precio;
this.categoria = categoria;
this.productoPlato = productoPlato;
//this.carta = carta;
this.area=area;
}

public PlatoEntity(){}


public AreaRest getArea() {
	return area;
}

public void setArea(AreaRest area) {
	this.area = area;
}

public CategoriaPlato getCategoria() {
return categoria;
}

public void setCategoria(CategoriaPlato categoria) {
this.categoria = categoria;
}

public CartaEntity getCarta() {
return carta;
}

public void setCarta(CartaEntity carta) {
this.carta = carta;
}


	public Integer getCodigo() {
		return codPlato;
	}

	public void setCodigo(Integer codigo) {
		this.codPlato = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<ElaboradoEntity> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<ElaboradoEntity> productoPlato) {
		this.productoPlato = productoPlato;
	}

	
	
	public Plato toNegocio() 
	{
		Plato p=new Plato();
		p.setCodigo(codPlato);
		p.setNombre(nombre);
		p.setPrecio(precio); 
		p.setArea(area);
		p.setCarta(carta.toNegocio());
		List<Elaborado> elab=new ArrayList<Elaborado>();
		for(ElaboradoEntity e: this.getProductoPlato() )
		{
			elab.add(e.toNegocio());
		}
		p.setProductoPlato(elab);
		p.setCategoria(categoria);
		return p;
	}

}
