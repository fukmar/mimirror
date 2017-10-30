package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.OrdenDeCompraEntity;
import hibernate.hbt;
import negocio.OrdenDeCompra;

public class ItemOrdenDeCompraDAO {
	
	private static ItemOrdenDeCompraDAO instancia;
	
	private ItemOrdenDeCompraDAO(){}
	
	public static ItemOrdenDeCompraDAO getInstance(){
		if(instancia == null){
			instancia= new ItemOrdenDeCompraDAO();
		}
		
		return instancia;
	}
	
	public void save (ItemOrdenDeCompraDAO itemOrDeCom){
		
		ItemOrdenDeCompraDAO iodc = this.toEntity(itemOrDeCom);
		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(iodc);
		session.getTransaction().commit();
		session.close();
	}

	
	//FALTA
	private ItemOrdenDeCompraDAO toEntity(ItemOrdenDeCompraDAO itemOrDeCom) {
		// TODO Auto-generated method stub
		return null;
	}

}
