package negocio;

import dto.LocalDTO;
import entities.LocalEntity;

public class Local 
{
	private Integer codigoLocal;
	private String direccion;
	private String barrio;
	private Deposito deposito;
	
	//Un local tiene varias areas
	
	public Local(){}


	public Local(String direccion, String barrio, Deposito deposito) {
		super();
		
		this.deposito = deposito;
		this.direccion = direccion;
		this.barrio = barrio;

	}


	public Integer getCodigoLocal() {
		return codigoLocal;
	}


	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getBarrio() {
		return barrio;
	}


	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}


	
	public Deposito getDeposito() {
		return deposito;
	}


	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}


	public LocalEntity toEntity()
{
		LocalEntity l=new LocalEntity();
		l.setCodigoLocal(codigoLocal);
		l.setDireccion(direccion);
		l.setBarrio(barrio);
		l.setDeposito(this.deposito.toEntity());
		return l;
	}


	public LocalDTO toDTO() 
	{
		LocalDTO l=new LocalDTO();
		l.setCodigoLocal(codigoLocal);
		l.setBarrio(barrio);
		l.setDireccion(direccion);
		l.setDeposito(deposito.toDTO());
		return l;
	}

}
