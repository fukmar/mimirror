package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.RemitoEntity;
import hibernate.HibernateUtil;
import negocio.Remito;


public class RemitoDAO {

	private static RemitoDAO instancia;
	
	private RemitoDAO(){}
	
	public static RemitoDAO getInstance(){
		if(instancia == null)
			instancia = new RemitoDAO();
		return instancia;
	}
	
	public void save(RemitoDAO remito){

	RemitoDAO rem = this.toEntity(remito);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(rem);
	session.getTransaction().commit();
	session.close();
	}
	
	
	//FALTA
	private RemitoDAO toEntity(RemitoDAO remito) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
