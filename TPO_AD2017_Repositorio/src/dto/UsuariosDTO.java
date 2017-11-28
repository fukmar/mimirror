package dto;

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

public class UsuariosDTO {

	private String login;
	private String password;
	private String nombre;
	private String apellido;

	private AreaRestaurantDTO area;
	
	
	public UsuariosDTO() {
		super();
	}
	public UsuariosDTO(String login, String password, String nombre, String apellido, AreaRestaurantDTO area) {
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
	public AreaRestaurantDTO getArea() {
		return area;
	}
	public void setArea(AreaRestaurantDTO area) {
		this.area = area;
	}
	
	
	
}
