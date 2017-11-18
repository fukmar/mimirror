package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.CajaEntity;
import hibernate.HibernateUtil;
import negocio.Caja;

public class CajaDAO 
{
	private static CajaDAO instancia=null;
	private static SessionFactory sf=null;
	
	public static CajaDAO getInstancia() 
	{
		if(instancia==null)
		{
			instancia=new CajaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	//Este es un DAO chotisimo, despues veo si lo mejoro
	//Tednria sentido si hubiera muchas cajas, que no es nuestro caso
	
	public Caja getCajaByCod(Integer codArea)
	{
		Session session=sf.openSession();
		Caja caja=new Caja ();
		CajaEntity resu=(CajaEntity) session.createQuery("from CajaEntity c where c.codArea=?").setInteger(0,codArea).uniqueResult();
		session.close();
		caja=resu.toNegocio();
		return caja;
	}
}


