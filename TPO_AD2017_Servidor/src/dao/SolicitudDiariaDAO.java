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

public class SolicitudDiariaDAO
{
	private static SolicitudDiariaDAO instancia;
	private static SessionFactory sf=null;
	
	private SolicitudDiariaDAO(){}
	
	public static SolicitudDiariaDAO getInstance(){
		if(instancia == null)
		{
			instancia = new SolicitudDiariaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(SolicitudDiaria solicitud){

	SolicitudDiariaEntity sol = solicitud.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(sol);
	session.getTransaction().commit();
	session.close();
	}
	public List<SolicitudDiaria> getsolicitudesDiarias()
	{
		Session session=sf.openSession();
		List<SolicitudDiaria> listado=new ArrayList<SolicitudDiaria>();
 		@SuppressWarnings("unchecked")
		List<SolicitudDiariaEntity> resu=session.createQuery("from SolicitudDiariaEntity sol where sol.solicitudes is not empty").list();
		for(SolicitudDiariaEntity si:resu) 
		{
			listado.add(si.toNegocio());
		}
		session.close();
		return listado;
	}


	 

	
}

