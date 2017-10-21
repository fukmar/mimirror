package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import hibernate.hbt;

public class ComandaDAO {

	
private static ComandaDAO instancia;
	
	private ComandaDAO(){}
	
	public static ComandaDAO getInstance(){
		if(instancia == null)
			instancia = new ComandaDAO();
		return instancia;
	}
	
	public void save(ComandaDAO itemcomanda){

	ComandaEntity ee = this.toEntity(itemcomanda);
	SessionFactory sf = hbt.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ee);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private ComandaEntity toEntity(ComandaDAO itemcomanda) {	
		return null;

	}
	
}
