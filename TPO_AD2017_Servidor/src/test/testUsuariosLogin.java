package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.UsuariosDAO;
import enumns.AreaRest;
import hibernate.HibernateUtil;
import negocio.Usuarios;

public class testUsuariosLogin {

	public static void main(String[] args) 
	{
		
	Usuarios usu = new Usuarios("admin","admin","N","G",AreaRest.Administracion);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(usu.toEntity());
	session.getTransaction().commit();
	
	//UsuariosDAO.getInstance().delete("ceci");
	}
}
