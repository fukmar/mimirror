package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	public double getTotalFacturadoCaja (Date FechaDesde,Date FechaHasta)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-YYYY");
		String fromDate=null;
		String toDate=null;
		fromDate=sf.format(FechaDesde);
		toDate=sf.format(FechaHasta);
		if (s.createQuery("select sum(f.importe) from FacturaEntity f where f.fecha between ? and ?").setString(0, fromDate).setString(1, toDate).uniqueResult() == null) {
		return 0;
		}else
		{
		double total=(double) s.createQuery("select sum(f.importe) from FacturaEntity f where f.fecha between ? and ?").setString(0, fromDate).setString(1, toDate).uniqueResult();
		
		return total;
		}
	}
}


