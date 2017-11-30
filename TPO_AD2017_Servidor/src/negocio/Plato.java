package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import dto.ElaboradoDTO;
import dto.PlatoDTO;
import entities.CartaEntity;
import entities.ElaboradoEntity;
import entities.PlatoEntity;
import enumns.AreaRest;
import enumns.CategoriaPlato;



public class Plato 
{
	private Integer codPlato;
	private String nombre;
	private float precio;
	private List<Elaborado> productoPlato;
    private Carta carta;
    private CategoriaPlato categoria;
    private AreaRest area;
	
	public Plato(){}


	public Plato(String nombre, float precio, AreaRest area, List<Elaborado> productoPlato/*, Carta carta*/,
			CategoriaPlato categoria) {
		super();
		this.nombre = nombre;
		this.area=area;
		this.precio = precio;
		this.productoPlato = productoPlato;
		//this.carta = carta;
		this.categoria = categoria;
	}


	public AreaRest getArea() {
		return area;
	}


	public void setArea(AreaRest area) {
		this.area = area;
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
	
	

	public CategoriaPlato getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaPlato categoria) {
		this.categoria = categoria;
	}


	public PlatoEntity toEntity() 
	{
		PlatoEntity p=new PlatoEntity();
		p.setCodigo(codPlato);
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setArea(area);
		p.setCarta(carta.toEntity());
		p.setCategoria(categoria);
		List<ElaboradoEntity> productos=new ArrayList<ElaboradoEntity>();
		for(Elaborado e:this.productoPlato ) 
		{
			productos.add(e.toEntity());
		}
		p.setProductoPlato(productos);
		return p;
	}
	
	public PlatoDTO toDTO() 
	{
		PlatoDTO p=new PlatoDTO();
		p.setCodigo(codPlato);
		p.setNombre(nombre);
		p.setArea(area);
		p.setPrecio(precio);
		p.setCategoria(categoria);
		List<ElaboradoDTO> productos=new ArrayList<ElaboradoDTO>();
		for(Elaborado e:this.productoPlato ) 
		{
			productos.add(e.toDTO());
		}
		p.setProductoPlato(productos);
		p.setCarta(carta.toDTO());
		return p;
	}


}
