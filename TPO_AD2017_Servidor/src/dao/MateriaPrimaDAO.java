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

	MateriaPrimaEntity mp = material.toEntity();
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
	
	public MateriaPrima getMateriaPrimaByCod(Integer material_id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		MateriaPrimaEntity mp=(MateriaPrimaEntity) session.createQuery("from MateriaPrimaEntity where codMaterial=?").setInteger(0, material_id).uniqueResult();
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
	public float getCantidadMateriaPrima(MateriaPrima mp)
	{
		Session session=sf.openSession();
		Query query=session.createQuery("select mp.cantidad from MateriaPrimaEntity mp where mp.codMaterial= ? ");
 		query.setFloat(0,mp.getCodigo());
 		float cantidad=0;
		cantidad=(Float) query.uniqueResult();
		session.close();
		return cantidad;
	}
	public void updateCantidadMateriaPrima(MateriaPrima mp,float cantidad)
	{
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from MateriaPrimaEntity mp where mp.codMaterial= ? ");
 		query.setFloat(0,mp.getCodigo());
		MateriaPrimaEntity materia=(MateriaPrimaEntity) query.uniqueResult();
		materia.setCantidad(cantidad);
		session.update(materia);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(MateriaPrima mp) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from MateriaPrimaEntity mp where mp.codMaterial= ? ");
 		query.setFloat(0,mp.getCodigo());
		MateriaPrimaEntity materia=(MateriaPrimaEntity) query.uniqueResult();
		materia.setDescripcion(mp.getDescripcion());
		materia.setCantidad(mp.getCantidad());
		session.update(materia);
		session.getTransaction().commit();
		session.close();
		
	}
	
}

