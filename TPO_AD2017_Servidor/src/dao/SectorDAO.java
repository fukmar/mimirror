package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.MozoDTO;
import entities.SectorEntity;
import hibernate.HibernateUtil;
import negocio.Sector;

public class SectorDAO 
{
	private static SectorDAO instancia=null;
	private static SessionFactory sf=null;
	
	private static SectorDAO getInstancia() 
	{
		if(instancia==null)
		{
			instancia=new SectorDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	
	public Sector getSectorByCod(Integer codSector) 
	{
		Sector sector=new Sector();
		Session session=sf.openSession();
		SectorEntity resu=(SectorEntity) session.createQuery("from SectorEntity s where s.codSector=?").setInteger(0, codSector).list();
		session.close();
		sector=resu.toNegocio();
		return sector;
	}
	
	
}
