package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.SolicitudIndividualEntity;
import entities.PlatoEntity;
import entities.UnidadEntity;
import enumns.CategoriaPlato;
import enumns.EstadoSolicitud;
import hibernate.HibernateUtil;
import negocio.SolicitudIndividual;
import negocio.Plato;

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
		SolicitudIndividualEntity solicitud=(SolicitudIndividualEntity) session.createQuery("from SolicitudIndividualEntity where codigo=?").setInteger(0, solicitud_id).uniqueResult();
		session.close();
		return solicitud.toNegocio();
	}


	public void updateEstadoSolicitudIndividual(SolicitudIndividual solicitud,EstadoSolicitud estado)
	{
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from SolicitudIndividualEntity solicitud where solicitud.codsolicitudIndividual= ? ");
 		query.setFloat(0,solicitud.getCodsolicitudIndividual());
		SolicitudIndividualEntity solicitudentity=(SolicitudIndividualEntity) query.uniqueResult();
		solicitudentity.setEstado(estado);
		session.update(solicitudentity);
		session.getTransaction().commit();
		session.close();
	}
	
}

