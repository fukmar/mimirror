package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.LocalEntity;
import hibernate.HibernateUtil;
import negocio.Local;

public class LocalDAO
{

	private static LocalDAO instancia=null;
	private static SessionFactory sf=null;
	
	public static LocalDAO getInstancia() 
	{
		if(instancia==null)
		{
			instancia=new LocalDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	
	public List<Local> getLocales()
	{
		List<Local> locales=new ArrayList<Local>();
		Session session=sf.openSession();
		List<LocalEntity> resu=session.createQuery("from LocalEntity").list();
		session.close();
		for(LocalEntity l: resu)
		{
			locales.add(l.toNegocio());
		}
		return locales;
	}
}
