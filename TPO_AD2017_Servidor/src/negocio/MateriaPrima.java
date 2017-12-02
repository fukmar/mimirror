package negocio;

import dao.MateriaPrimaDAO;
import dto.MateriaPrimaDTO;
import dto.UnidadDTO;
import entities.DepositoEntity;
import entities.MateriaPrimaEntity;
import entities.UnidadEntity;

public class MateriaPrima 
{
	private Integer codigo;
	private String descripcion;
	private Unidad unidadUso;
	private Float cantidad;
	private Deposito deposito;
	private Integer estadescontado=0;
	
	public MateriaPrima(){}

	public MateriaPrima(String descripcion, Unidad unidadUso, Float cantidad,Deposito deposito) {
	super();

	this.descripcion = descripcion;
	this.unidadUso = unidadUso;
	this.setCantidad(cantidad);
	this.deposito=deposito;
}

	public Integer getEstadescontado() {
		return estadescontado;
	}

	public void setEstadescontado(Integer estadescontado) {
		this.estadescontado = estadescontado;
	}

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


	public Unidad getUnidadUso() {
		return unidadUso;
	}

	public void setUnidadUso(Unidad unidadUso) {
		this.unidadUso = unidadUso;
	}



	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	
	public MateriaPrimaEntity toEntity() {
		MateriaPrimaEntity materia= new MateriaPrimaEntity();
		materia.setCantidad(cantidad);
		materia.setCodigo(codigo);
		System.out.println(deposito);
		materia.setDeposito(deposito.toEntity());
		System.out.println(materia.getDeposito());
		materia.setDescripcion(descripcion);
		materia.setUnidadUso(unidadUso.toEntity());
		materia.setEstadescontado(estadescontado);
		return materia;
		
	}
	public MateriaPrimaDTO toDTO()
	{
		MateriaPrimaDTO m=new MateriaPrimaDTO();
		m.setCodigo(codigo);
		m.setDescripcion(descripcion);
		m.setUnidadUso(unidadUso.toDTO());
		m.setDeposito(deposito.toDTO());
		m.setEstadescontado(estadescontado);
		return m;
	}
	
	public void save() {
		MateriaPrimaDAO.getInstance().save(this);
	}
	
}
