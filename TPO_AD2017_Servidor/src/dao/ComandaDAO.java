package dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.ItemComandaEntity;
import hibernate.hbt;

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
	SessionFactory sf = hbt.getSessionFactory();
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
	
	public List <ItemComandaEntity> OtenerItemComanda(int codigoComanda) {
		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String senten = " FROM ItemComanda WHERE id.codigoComanda = ?";
		List <ItemComandaEntity> items = session.createQuery(senten).setInteger(0, codigoComanda).list();
		session.getTransaction().commit();
		return items;
	}
	
}
