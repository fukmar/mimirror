package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.OrdenDeCompraEntity;
import hibernate.HibernateUtil;
import negocio.OrdenDeCompra;

public class OrdenDeCompraDAO {

	private static OrdenDeCompraDAO instancia;
	
	private OrdenDeCompraDAO(){}
	
	public static OrdenDeCompraDAO getInstance(){
		if(instancia == null)
			instancia = new OrdenDeCompraDAO();
		return instancia;
	}
	
	public void save(OrdenDeCompraDAO ordenDeCompra){

	OrdenDeCompraDAO orDeCom = this.toEntity(ordenDeCompra);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(orDeCom);
	session.getTransaction().commit();
	session.close();
	}

	
	//FALTA
	private OrdenDeCompraDAO toEntity(OrdenDeCompraDAO ordenDeCompra) {
		// TODO Auto-generated method stub
		return null;
	}
}
