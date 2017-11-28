package entities;

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

import negocio.Usuarios;

@Entity
@Table(name="Usuarios")
public class UsuariosEntity {
	@Id
	@Column(name="login")
	private String login;
	private String password;
	private String nombre;
	private String apellido;
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="codArea")
	private AreaRestaurantEntity area;
	
	
	public UsuariosEntity() {
		super();
	}
	public UsuariosEntity(String login, String password, String nombre, String apellido, AreaRestaurantEntity area) {
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
	public AreaRestaurantEntity getArea() {
		return area;
	}
	public void setArea(AreaRestaurantEntity area) {
		this.area = area;
	}
	public Usuarios toNegocio()
	{
		Usuarios u=new Usuarios();
		u.setApellido(apellido);
		u.setArea(area.toNegocio());
		u.setLogin(login);
		u.setNombre(nombre);
		u.setPassword(password);
		return u;
	}
	
	
	
}
