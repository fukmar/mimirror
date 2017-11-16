package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MateriaPrimaEntity;
import entities.PlatoEntity;
import entities.UnidadEntity;
import enumns.CategoriaPlato;
import hibernate.HibernateUtil;
import negocio.MateriaPrima;
import negocio.Plato;

public class MateriaPrimaDAO
{
	private static MateriaPrimaDAO instancia;
	private static SessionFactory sf=null;
	
	private MateriaPrimaDAO(){}
	
	public static MateriaPrimaDAO getInstance(){
		if(instancia == null)
		{
			instancia = new MateriaPrimaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(MateriaPrima material){

	MateriaPrimaEntity mp = this.toEntity(material);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(mp);
	session.getTransaction().commit();
	session.close();
	}
	
	public List<MateriaPrima> getMateriales()
	{
		Session session=sf.openSession();
		List<MateriaPrima> mp=new ArrayList<MateriaPrima>();
 		@SuppressWarnings("unchecked")
		List<MateriaPrimaEntity> resu=session.createQuery("from MateriaPrimaEntity").list();
		for(MateriaPrimaEntity p:resu) 
		{
			mp.add(p.toNegocio());
		}
		session.close();
		return mp;
	}
	public MateriaPrima getPlatoPorId(Integer material_id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		MateriaPrimaEntity mp =(MateriaPrimaEntity) session.get(MateriaPrimaEntity.class,material_id); 
		session.close();
		return mp.toNegocio();
	}
	public MateriaPrima getMaterialpornombre(String nombre)
	{
		Session session=sf.openSession();
		Query query=session.createQuery("from MateriaPrimaEntity mp where mp.descripcion like ? ");
 		query.setString(0,nombre);
		MateriaPrimaEntity resu=(MateriaPrimaEntity) query.uniqueResult();
		session.close();
		return resu.toNegocio();
	}
	

	//FALTA
	private MateriaPrimaEntity toEntity(MateriaPrima material) {	
		return null;

	}
	
}

