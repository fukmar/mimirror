package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemOrdenDeCompraEntity;
import entities.OrdenDeCompraEntity;
import hibernate.HibernateUtil;
import negocio.ItemOrdenDeCompra;
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
	
	public void save (ItemOrdenDeCompra itemOrDeCom){ //cz guarda negocio, esto no me gusta pero no se puede hacer el to Entity porque Producto es abastracta y no se puede instanciar
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(itemOrDeCom);
		session.getTransaction().commit();
		session.close();
	}

	
	//FALTA
	/*private ItemOrdenDeCompraDAO toEntity(ItemOrdenDeCompraDAO itemOrDeCom) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
