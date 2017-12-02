package negocio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dao.UsuariosDAO;
import dto.UsuariosDTO;
import entities.UsuariosEntity;
import enumns.AreaRest;

public class Usuarios {

	private String login;
	private String password;
	private String nombre;
	private String apellido;
	private Enum<AreaRest> area;
	
	
	public Usuarios() {
		super();
	}
	public Usuarios(String login, String password, String nombre, String apellido, Enum<AreaRest> area) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.area = area;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Enum<AreaRest> getArea() {
		return area;
	}
	
	public void setArea(Enum<AreaRest>  area2) {
		this.area = area2;
	}
	
	
	/*public void setArea(AreaRest area) {
		this.area = area;
	}*/
	
	public UsuariosEntity toEntity()
	{
		UsuariosEntity u=new UsuariosEntity();
		u.setApellido(apellido);
		u.setArea(area);
		u.setLogin(login);
		u.setNombre(nombre);
		u.setPassword(password);
		return u;
	}
	
	public UsuariosDTO toDTO()
	{
		UsuariosDTO u=new UsuariosDTO();
		u.setApellido(apellido);
		u.setArea(area);
		u.setLogin(login);
		u.setNombre(nombre);
		u.setPassword(password);
		return u;
	}
	public void save() 
	{
		UsuariosDAO.getInstance().save(this);
		
	}
	
	
	
}
