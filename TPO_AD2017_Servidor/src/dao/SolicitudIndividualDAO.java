package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.SolicitudIndividualEntity;
import entities.PlatoEntity;
import entities.SolicitudDiariaEntity;
import entities.UnidadEntity;
import enumns.CategoriaPlato;
import enumns.EstadoItemComanda;
import enumns.EstadoSolicitud;
import hibernate.HibernateUtil;
import negocio.SolicitudIndividual;
import negocio.ItemComanda;
import negocio.Plato;
import negocio.SolicitudDiaria;

public class SolicitudIndividualDAO
{
	private static SolicitudIndividualDAO instancia;
	private static SessionFactory sf=null;
	
	private SolicitudIndividualDAO(){}
	
	public static SolicitudIndividualDAO getInstance(){
		if(instancia == null)
		{
			instancia = new SolicitudIndividualDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(SolicitudIndividual solicitud){

	SolicitudIndividualEntity sol = solicitud.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(sol);
	session.getTransaction().commit();
	session.close();
	}
	
	public List<SolicitudIndividual> getsolicitudes()
	{
		Session session=sf.openSession();
		List<SolicitudIndividual> listado=new ArrayList<SolicitudIndividual>();
 		@SuppressWarnings("unchecked")
		List<SolicitudIndividualEntity> resu=session.createQuery("from SolicitudIndividualEntity").list();
		for(SolicitudIndividualEntity si:resu) 
		{
			listado.add(si.toNegocio());
		}
		session.close();
		return listado;
	}
	public SolicitudIndividual getSolicitudIndividualPorId(Integer solicitud_id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println(solicitud_id);
		SolicitudIndividualEntity solicitud=(SolicitudIndividualEntity) session.createQuery("from SolicitudIndividualEntity where codsolicitudIndividual=?").setInteger(0, solicitud_id).uniqueResult();
		session.close();
		return solicitud.toNegocio();
	}
	public List<SolicitudIndividual> getsolicitudesIndividualesnoDiarias()
	{
		Session session=sf.openSession();
		List<SolicitudIndividual> listado=new ArrayList<SolicitudIndividual>();
 		@SuppressWarnings("unchecked")
		List<SolicitudIndividualEntity> resu=session.createQuery("select sol.solicitudes from SolicitudDiariaEntity sol where sol is null").list();
		for(SolicitudIndividualEntity si:resu) 
		{
			listado.add(si.toNegocio());
		}
		session.close();
		return listado;
	}
	

	 

	
}

