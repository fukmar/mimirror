package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemRemitoEntity;
import entities.PlatoEntity;
import entities.RemitoEntity;
import hibernate.HibernateUtil;
import negocio.ItemRemito;
import negocio.Plato;
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
	public List<ItemRemito> getItemsRemitos()
	{
		List<ItemRemito> listaItemRemitos=new ArrayList<ItemRemito>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
 		@SuppressWarnings("unchecked")
		List<ItemRemitoEntity> itemsRemito=session.createQuery("from ItemRemitoEntity").list();
		for(ItemRemitoEntity item:itemsRemito) 
		{
			listaItemRemitos.add(item.toNegocio());
		}
		session.close();
		return listaItemRemitos;
	}

	public RemitoEntity toEntity(Remito remito){ //COMPLETAR
		RemitoEntity remitoentity=new RemitoEntity();
    return remitoentity;
	}
	
	
	//FALTA
	private RemitoDAO toEntity(RemitoDAO remito) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
