package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PlatoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Plato;

public class PlatoDAO
{
	private static PlatoDAO instancia;
	private static SessionFactory sf=null;
	
	private PlatoDAO(){}
	
	public static PlatoDAO getInstance(){
		if(instancia == null)
		{
			instancia = new PlatoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(Plato plato){

	PlatoEntity pe = this.toEntity(plato);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(pe);
	session.getTransaction().commit();
	session.close();
	}
	
	public List<Plato> getPlatos()
	{
		Session session=sf.openSession();
		List<Plato> listaPlatos=new ArrayList<Plato>();
		List<PlatoEntity> resu=session.createCriteria("from PlatoEntity").list();
		for(PlatoEntity p:resu)
		{
			listaPlatos.add(p.toNegocio());
		}
		session.close();
		return listaPlatos;
	}
	//FALTA
	private PlatoEntity toEntity(Plato plato) {	
		return null;

	}
	
}

