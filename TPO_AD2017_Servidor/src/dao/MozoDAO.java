package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import entities.MozoEntity;
import hibernate.HibernateUtil;
import negocio.Mozo;

public class MozoDAO 
{
	private static MozoDAO instancia=null;
	private static SessionFactory sf=null;
	
	public static MozoDAO getInstancia() 
	{
		if(instancia==null)
		{
			instancia=new MozoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(Mozo mozo) 
	{
		MozoEntity mozoE=mozo.toEntity();
		Session session=sf.openSession();
		Transaction tran=session.beginTransaction();
		session.save(mozoE);
		tran.commit();
		session.close();
	}
	
	public List<Mozo> getMozos() 
	{
		List<Mozo> mozosN=new ArrayList<Mozo>();
		Session session=sf.openSession();
		List<MozoEntity> resu=session.createQuery("from MozoEntity").list();
		session.close();
		for(MozoEntity m:resu)
		{
			mozosN.add(m.toNegocio());
		}
		return mozosN;
	}
	
	
	public Mozo getMozosByCod(Integer codMozo) 
	{
		Mozo mozo=new Mozo();
		Session session=sf.openSession();
		MozoEntity resu=(MozoEntity) session.createQuery("from MozoEntity m where m.dni=?").setInteger(0, codMozo).uniqueResult();
		session.close();
		mozo=resu.toNegocio();
		return mozo;
	}
	
	public Mozo getMozosByApe(String apellido) 
	{
		Mozo mozo=new Mozo();
		Session session=sf.openSession();
		MozoEntity resu=(MozoEntity) session.createQuery("from MozoEntity m where m.apellido=?").setString(0, apellido).uniqueResult();
		session.close();
		mozo=resu.toNegocio();
		return mozo;
	}
	
	public List<String[]> ResultadoComisiones (/*Date FechaDesde,Date FechaHasta*/)
	{
		List<String[]> rta = new ArrayList<String[]>();
		try{
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			List<Object[]> objetos = s.createQuery("select m.dni, "
					+ "m.nombre,m.apellido, m.porcentajeComision * f.importe/100 "
					+ "from FacturaEntity f join f.mozo m "
					).list();
			s.getTransaction().commit();
			for (Object[] aux : objetos)
				rta.add(new String[]{aux[0].toString(), aux[1].toString(), aux[2].toString(),aux[3].toString()});
		} catch (Exception e){
			System.out.println("error en ResultadoDAO: " + e.getMessage());
		}
		return rta;
	}
	public List<String[]> ResultadoComisiones (Date FechaDesde,Date FechaHasta)
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-YYYY");
		String fromDate=null;
		String toDate=null;
		fromDate=sf.format(FechaDesde);
		toDate=sf.format(FechaHasta);
		List<String[]> rta = new ArrayList<String[]>();
		try{
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			List<Object[]> objetos = s.createQuery("select m.dni, "
					+ "m.nombre,m.apellido, m.porcentajeComision * f.importe/100 "
					+ "from FacturaEntity f join f.mozo m where f.fecha between ? and ?"
					).setString(0, fromDate).setString(1, toDate).list();
			
			s.getTransaction().commit();
			for (Object[] aux : objetos)
				rta.add(new String[]{aux[0].toString(), aux[1].toString(), aux[2].toString(),aux[3].toString()});
		} catch (Exception e){
			System.out.println("error en ResultadoDAO: " + e.getMessage());
		}
		return rta;
	}
}
