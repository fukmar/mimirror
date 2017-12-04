package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPlanProduccionEntity;
import entities.ItemRemitoEntity;
import entities.RemitoEntity;
import hibernate.HibernateUtil;
import negocio.ItemPlanProduccion;
import negocio.ItemRemito;
import negocio.Remito;

public class ItemPlanDeProduccionDAO {
	
	private static ItemPlanDeProduccionDAO instancia;
	
	private ItemPlanDeProduccionDAO(){}
	  
	public static ItemPlanDeProduccionDAO getInstance(){
		if(instancia == null)
			instancia = new ItemPlanDeProduccionDAO();
		return instancia;
	}
	
	public void save(ItemPlanProduccion itemplan){

	ItemPlanProduccionEntity itemplanenti = itemplan.toEntity(); //pasado a entity cz
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(itemplanenti);
	session.getTransaction().commit();
	session.close();
	}


}
