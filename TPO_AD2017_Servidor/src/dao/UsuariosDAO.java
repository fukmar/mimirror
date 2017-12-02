package dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MateriaPrimaEntity;
import entities.PlanDeProduccionEntity;
import entities.PlatoEntity;
import entities.UnidadEntity;
import entities.UsuariosEntity;
import enumns.AreaRest;
import enumns.CategoriaPlato;
import enumns.Estado;
import hibernate.HibernateUtil;
import negocio.AreaRestaurant;
import negocio.Elaborado;
import negocio.Ingrediente;
import negocio.Plato;
import negocio.SemiElaborado;
import negocio.Usuarios;

public class UsuariosDAO
{
	private static UsuariosDAO instancia;
	private static SessionFactory sf=null;
	
	private UsuariosDAO(){}
	
	public static UsuariosDAO getInstance(){
		if(instancia == null)
		{
			instancia = new UsuariosDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(Usuarios user){

	UsuariosEntity userent = user.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(userent);
	session.getTransaction().commit();
	session.close();
	}
	
	public List<Usuarios> getUsuarios()
	{
		Session session=sf.openSession();
		List<Usuarios> listaUsuarios=new ArrayList<Usuarios>();
 		@SuppressWarnings("unchecked")
		List<UsuariosEntity> resu=session.createQuery("from UsuariosEntity").list();
		for(UsuariosEntity u:resu) 
		{
			listaUsuarios.add(u.toNegocio());
		}
		session.close();
		return listaUsuarios;
	}
	public Usuarios getUserPorLogin(String login) 
	{
		Usuarios user=new Usuarios();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuariosEntity resu =(UsuariosEntity) session.createQuery("from UsuariosEntity u where u.login=?").setString(0, login).uniqueResult();
		session.close();
		if (resu!=null)
			return resu.toNegocio();
		else 
			return null;
	}
	public List<Usuarios> getUsersbyArea(String area)
	{
		Session session=sf.openSession();
		List<Usuarios> listausuarios=new ArrayList<Usuarios>();
		AreaRest arearest=arearestaurantfromString(area);
		Query query=session.createQuery("from UsuariosEntity u where u.area.area=?");
 		query.setParameter(0,arearest);
 		@SuppressWarnings("unchecked")
		List<UsuariosEntity> resu=query.list();
		for(UsuariosEntity u:resu) 
		{
			listausuarios.add(u.toNegocio());
		}
		session.close();
		return listausuarios;
	}
	
	public boolean validarPassword(String login, String password)
	{
		Usuarios user= UsuariosDAO.getInstance().getUserPorLogin(login);
		if (user==null)
			return false;
		else 
		{
	 		String passwordcorrecto=UsuariosDAO.getInstance().getUserPorLogin(login).getPassword();
	 		if (password==passwordcorrecto)
	 			return true;
	 		else
	 			return false;
		}
	}
	private AreaRest arearestaurantfromString(String area)
	{
		return AreaRest.valueOf(area);
	}
	
}

