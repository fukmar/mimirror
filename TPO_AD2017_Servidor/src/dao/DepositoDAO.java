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
	
	public Deposito getDepositoByCod(Integer codDeposito) 
	{
		Deposito deposito=new Deposito();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		DepositoEntity depo= (DepositoEntity) session.createQuery("from DepositoEntity c where c.codDeposito=?").setInteger(0, codDeposito).uniqueResult();
		session.close();
		deposito=depo.toNegocio();
		return deposito;
	}
}
