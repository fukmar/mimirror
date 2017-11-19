package negocio;

import java.util.Date;

import dao.ReservaDAO;
import dto.ReservaDTO;
import entities.ReservaEntity;

public class Reserva 
{
	private Integer codReserva;
	private String nombre;
	private Date fechayHora;
	//private List<MesaDTO> mesas;
	
	public Reserva() {}
	
	public Reserva(Integer codReserva, String nombre, Date fechayHora) {
		super();
		this.codReserva = codReserva;
		this.nombre = nombre;
		this.fechayHora = fechayHora;
	}

	public Integer getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(Integer codReserva) {
		this.codReserva = codReserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechayHora() {
		return fechayHora;
	}

	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
	}

	
	//GRABAR RESERVA
	
	public void save() 
	{
		ReservaDAO.getInstancia().save(this);
	}
	public ReservaEntity toEntity() 
	{
		ReservaEntity r=new ReservaEntity();
		r.setCodReserva(codReserva);
		r.setFechayHora(fechayHora);
		r.setNombre(nombre);
		return r;
	}

	public ReservaDTO toDTO() 
	{
		ReservaDTO r=new ReservaDTO();
		r.setCodReserva(codReserva);
		r.setNombre(nombre);
		r.setFechayHora(fechayHora);
		return r;
	}
}
