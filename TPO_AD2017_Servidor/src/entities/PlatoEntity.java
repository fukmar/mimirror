package entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

import negocio.Elaborado;
import negocio.Plato;


@Entity
@Table(name="platos")
public class PlatoEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codPlato")
	private Integer codigo;
	private String nombre;
	private float precio;
	
	public CartaEntity getCarta() {
		return carta;
	}

	public void setCarta(CartaEntity carta) {
		this.carta = carta;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="platocompuestode",
	joinColumns=@JoinColumn(name="codPlato",referencedColumnName="codPlato"),
	inverseJoinColumns=@JoinColumn(name="codProducto",referencedColumnName="codProducto"))
	private List<ElaboradoEntity> productoPlato;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="codCarta", nullable=false)
    private CartaEntity carta;
	
	
	public PlatoEntity(){}

	public PlatoEntity(String nombre, float precio, List<ElaboradoEntity> productoPlato) {
		super();
	
		this.nombre = nombre;
		this.precio = precio;
		this.productoPlato = productoPlato;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		p.setCodigo(1);
		p.setNombre("pp");
		p.setPrecio(1f);
		List<Elaborado> elab=new ArrayList<Elaborado>();
		/*for(ElaboradoEntity pp: productoPlato )
		{
			elab.add(pp.toNegocio());
		}
		p.setProductoPlato(elab);*/
		return p;
	}

}
