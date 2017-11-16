package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PlatoEntity;
import entities.UnidadEntity;
import enumns.CategoriaPlato;
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
 		//List<PlatoEntity> resu=session.createCriteria("from PlatoEntity").list();
 		@SuppressWarnings("unchecked")
		List<PlatoEntity> resu=session.createQuery("from PlatoEntity").list();
		for(PlatoEntity p:resu) 
		{
			listaPlatos.add(p.toNegocio());
		}
		session.close();
		return listaPlatos;
	}
	public PlatoEntity getPlatoPorId(Integer plato_id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PlatoEntity elPlato =(PlatoEntity) session.get(PlatoEntity.class,plato_id); 
		session.close();
		return elPlato;
	}
	public List<Plato> getPlatosparecidos(String nombre, String categoriaplato)
	{
		Session session=sf.openSession();
		List<Plato> listaPlatos=new ArrayList<Plato>();
		CategoriaPlato categoria=categoriafromString(categoriaplato);
 		//List<PlatoEntity> resu=session.createCriteria("from PlatoEntity").list();
 		@SuppressWarnings("unchecked")
		Query query=session.createQuery("from PlatoEntity p where p.categoria=? and p.nombre like ? ");
 		query.setString(1,"%"+nombre+"%");
 		query.setParameter(0,categoria);
 		@SuppressWarnings("unchecked")
		List<PlatoEntity> resu=query.list();
		for(PlatoEntity p:resu) 
		{
			listaPlatos.add(p.toNegocio());
		}
		session.close();
		return listaPlatos;
	}
	
	private CategoriaPlato categoriafromString(String categoria)
	{
		return CategoriaPlato.valueOf(categoria);
	}
	//FALTA
	private PlatoEntity toEntity(Plato plato) {	
		return null;

	}
	
}

