package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import entities.ReservaEntity;
import hibernate.HibernateUtil;
import negocio.Reserva;

public class ReservaDAO 
{
	private static ReservaDAO instancia=null;
	private static SessionFactory sf=null;
	
	public static ReservaDAO getInstancia() 
	{
		if(instancia==null)
		{
			instancia=new ReservaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	
	public void save(Reserva reserva) 
	{
		Session session=sf.openSession();
		ReservaEntity r=reserva.toEntity();
		Transaction tran=session.beginTransaction();
		session.save(r);
		tran.commit();
		session.close();
	}
	
	
	public List<Reserva> getReservas()
	{
		Session session=sf.openSession();
		List<Reserva> listaRes=new ArrayList<Reserva>();
		List<ReservaEntity> resu=session.createQuery("from ReservaEntity").list();
		session.close();
		for(ReservaEntity r: resu) 
		{
			listaRes.add(r.toNegocio());
		}
		return listaRes;
	}
}
