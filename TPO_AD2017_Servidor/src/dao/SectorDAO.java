package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dto.MozoDTO;
import entities.SectorEntity;
import hibernate.HibernateUtil;
import negocio.Sector;

public class SectorDAO 
{
	private static SectorDAO instancia=null;
	private static SessionFactory sf=null;
	
	public static SectorDAO getInstancia() 
	{
		if(instancia==null)
		{
			instancia=new SectorDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	
	public void save(Sector sector)
	{
		SectorEntity sectorE=sector.toEntity();
		Session session=sf.openSession();
		Transaction tran=session.beginTransaction();
		session.save(sectorE);
		tran.commit();
		session.close();
	}
	
	public Sector getSectorByCod(Integer codSector) 
	{
		Sector sector=new Sector();
		Session session=sf.openSession();
		SectorEntity resu=(SectorEntity) session.createQuery("from SectorEntity s where s.codSector=?").setInteger(0, codSector).uniqueResult();
		session.close();
		sector=resu.toNegocio();
		return sector;
	}
	
	public List<Sector> getSectores()
	{
		Session session=sf.openSession();
		List<Sector> sectores=new ArrayList<Sector>();
		List<SectorEntity>resu=session.createQuery("from SectorEntity").list();
		for(SectorEntity s:resu)
		{
			sectores.add(s.toNegocio());
		}
		session.close();
		return sectores;
	}
}
