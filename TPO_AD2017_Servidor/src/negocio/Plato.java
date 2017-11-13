package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import dto.PlatoDTO;
import entities.CartaEntity;
import entities.ElaboradoEntity;



public class Plato 
{
	private Integer codigo;
	private String nombre;
	private float precio;
	private List<Elaborado> productoPlato;
    private Carta carta;
	
	
	public Plato(){}

	public Plato(String nombre, float precio, List<Elaborado> productoPlato) {
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

	public List<Elaborado> getProductoPlato() {
		return productoPlato;
	}

	public void setProductoPlato(List<Elaborado> productoPlato) {
		this.productoPlato = productoPlato;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	
	public PlatoDTO toDTO()
	{
		PlatoDTO p=new PlatoDTO();
		p.setCodigo(codigo);
		p.setNombre(nombre);
		p.setPrecio(precio);
		List<Elaborado> elab=new ArrayList<Elaborado>();
		/*for(Elaborado pp: productoPlato )
		{
			elab.add(pp.toDTO());
		}
		p.setProductoPlato(elab);*/
		return p;
	}

}
