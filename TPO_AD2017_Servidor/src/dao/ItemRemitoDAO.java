package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemRemitoEntity;
import entities.RemitoEntity;
import hibernate.HibernateUtil;
import negocio.ItemRemito;
import negocio.Remito;

public class ItemRemitoDAO {
	
	private static ItemRemitoDAO instancia;
	
	private ItemRemitoDAO(){}
	
	public static ItemRemitoDAO getInstance(){
		if(instancia == null)
			instancia = new ItemRemitoDAO();
		return instancia;
	}
	
	public void save(ItemRemito itemRemito){

	ItemRemitoEntity item = itemRemito.toEntity(); //pasado a entity cz
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(item);
	session.getTransaction().commit();
	session.close();
	}

	/*public ItemRemitoEntity toEntity(ItemRemito itemremito){
		ItemRemitoEntity item=new ItemRemitoEntity();
		return item;
	}*/
	
	
	
}
