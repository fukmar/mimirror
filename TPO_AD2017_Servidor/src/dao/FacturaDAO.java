package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.FacturaEntity;
import hibernate.hbt;


public class FacturaDAO {

	
private static FacturaDAO instancia;
	
	private FacturaDAO(){}
	
	public static FacturaDAO getInstance(){
		if(instancia == null)
			instancia = new FacturaDAO();
		return instancia;
	}
	
	public void save(FacturaDAO itemcomanda){

	FacturaEntity fact = this.toEntity(itemcomanda);
	SessionFactory sf = hbt.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(fact);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private FacturaEntity toEntity(FacturaDAO itemcomanda) {	
		return null;

	}
	
}
