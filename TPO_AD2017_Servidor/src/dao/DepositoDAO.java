package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.DepositoEntity;
import entities.SectorEntity;
import hibernate.HibernateUtil;
import negocio.Deposito;
import negocio.Sector;

public class DepositoDAO 
{
	private static DepositoDAO instancia=null;
	private static SessionFactory sf=null;
	
	public static DepositoDAO getInstancia() 
	{
		if(instancia==null)
		{
			instancia=new DepositoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public List<Deposito> getDepositos()
	{
		Session session=sf.openSession();
		List<Deposito> depositos=new ArrayList<Deposito>();
		List<DepositoEntity>resu=session.createQuery("from DepositoEntity").list();
		for(DepositoEntity s:resu)
		{
			depositos.add(s.toNegocio());
		}
		session.close();
		return depositos;
	}
}
