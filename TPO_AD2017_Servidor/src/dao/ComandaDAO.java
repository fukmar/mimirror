package dao;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.ItemComandaEntity;
import entities.PlatoEntity;
import hibernate.HibernateUtil;

public class ComandaDAO {

	
private static ComandaDAO instancia;
	
	private ComandaDAO(){}
	
	public static ComandaDAO getInstance(){
		if(instancia == null)
			instancia = new ComandaDAO();
		return instancia;
	}
	
	public void save(ComandaDAO comanda){

	ComandaEntity ee = this.toEntity(comanda);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ee);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private ComandaEntity toEntity(ComandaDAO comanda) {	
		return null;

	}
	
	@SuppressWarnings("unchecked")
	public List <ItemComandaEntity> OtenerItemComanda(int codigoComanda) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String senten = " FROM ItemComanda WHERE codComanda = ?";
		List <ItemComandaEntity> items = session.createQuery(senten).setInteger(0, codigoComanda).list();
		session.getTransaction().commit();
		return items;
	}
	public ComandaEntity obtenerComanda(int codComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String senten = " FROM ComandaEntity WHERE codComanda = ?";
		ComandaEntity comanda = (ComandaEntity) session.createQuery(senten).setInteger(0, codComanda).uniqueResult();
		session.getTransaction().commit();
		return comanda;
	}
	public List <ComandaEntity> obtenerComandasAbiertasxMesa(int codMesa){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<ComandaEntity> comandas = session.createQuery("from ComandaEntity c where c.mesa.codMesa=? and c.estado=0").setInteger(0, codMesa).list();
		session.getTransaction().commit();
		return comandas;
	}
	
  
}
