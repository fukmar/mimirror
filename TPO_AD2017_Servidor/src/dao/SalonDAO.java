package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.SalonEntity;
import hibernate.HibernateUtil;
import negocio.Salon;

public class SalonDAO 
{
	private static SalonDAO instancia=null;
	private static SessionFactory sf=null;
	
	public static SalonDAO getInstancia() 
	{
		if(instancia==null) 
		{
			instancia=new SalonDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public List<Salon> getSalones()
	{
		Session session=sf.openSession();
		List<Salon> salones=new ArrayList<Salon>();
		List<SalonEntity> resu=session.createQuery("from SalonEntity").list();
		session.close();
		for(SalonEntity s:resu)
		{
			salones.add(s.toNegocio());
		}
		return salones;
	}
	
	
}
