package dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.ItemComandaEntity;
import entities.PlatoEntity;
import enumns.Estado;
import hibernate.HibernateUtil;
import negocio.Comanda;

public class ComandaDAO {

	
private static ComandaDAO instancia;
private static SessionFactory sf=null;
	
	private ComandaDAO(){}
	
	public static ComandaDAO getInstance()
	{
		if(instancia == null)
		{
			instancia = new ComandaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(Comanda comanda){

	ComandaEntity ee = comanda.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ee);
	session.getTransaction().commit();
	session.close();
	}
	

	//FALTA
	/*private ComandaEntity toEntity(ComandaDAO comanda) 
	{	
		return null;

	}*/
	
	//LISTAR TODAS LAS COMANDAS
	
	public List<Comanda> getComandas()
	{
		Session session=sf.openSession();
		List<Comanda> listaCom=new ArrayList<>();
		List<ComandaEntity> resu=session.createQuery("from ComandaEntity").list();
		for(ComandaEntity c:resu) 
		{
			listaCom.add(c.toNegocio());
		}
		session.close();
		return listaCom;
	}
	
	
	@SuppressWarnings("unchecked")
	public List <ItemComandaEntity> OtenerItemComanda(int codigoComanda) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String senten = " FROM ItemComanda WHERE codComanda = ?";
		List <ItemComandaEntity> items = session.createQuery(senten).setInteger(0, codigoComanda).list();
		session.getTransaction().commit();
		session.close();
		return items;
	}
	
	public ComandaEntity obtenerComanda(int codComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String senten = " FROM ComandaEntity WHERE codComanda = ?";
		ComandaEntity comanda = (ComandaEntity) session.createQuery(senten).setInteger(0, codComanda).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return comanda;
	}
	
	public List <ComandaEntity> obtenerComandasAbiertasxMesa(int codMesa){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<ComandaEntity> comandas = session.createQuery("from ComandaEntity c where c.mesa.codMesa=? and c.estado=0").setInteger(0, codMesa).list();
		session.getTransaction().commit();
		session.close();
		return comandas;
	}
	public ComandaEntity cerrarComanda(int codComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String senten = " FROM ComandaEntity WHERE codComanda = ?";
		ComandaEntity comanda = (ComandaEntity) session.createQuery(senten).setInteger(0, codComanda).uniqueResult();
		comanda.setEstado(Estado.Terminado);
		session.getTransaction().commit();
		session.close();
		return comanda;
	}
	
  
}
