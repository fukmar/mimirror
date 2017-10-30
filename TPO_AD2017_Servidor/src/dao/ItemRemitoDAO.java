package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemRemitoEntity;
import hibernate.hbt;
import negocio.ItemRemito;

public class ItemRemitoDAO {
	
	private static ItemRemitoDAO instancia;
	
	private ItemRemitoDAO(){}
	
	public static ItemRemitoDAO getInstance(){
		if(instancia == null)
			instancia = new ItemRemitoDAO();
		return instancia;
	}
	
	public void save(ItemRemitoDAO itemRemito){

	ItemRemitoDAO ir = this.toEntity(itemRemito);
	SessionFactory sf = hbt.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ir);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private ItemRemitoDAO toEntity(ItemRemitoDAO itemRemito) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
