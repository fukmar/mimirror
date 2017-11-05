package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PlatoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Plato;

public class PlatoDAO {

	
private static PlatoDAO instancia;
	
	private PlatoDAO(){}
	
	public static PlatoDAO getInstance(){
		if(instancia == null)
			instancia = new PlatoDAO();
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
	
	//FALTA
	private PlatoEntity toEntity(Plato plato) {	
		return null;

	}
	
}

