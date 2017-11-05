package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.FacturaEntity;
import hibernate.HibernateUtil;


public class FacturaDAO {

	
private static FacturaDAO instancia;
	
	private FacturaDAO(){}
	
	public static FacturaDAO getInstance(){
		if(instancia == null)
			instancia = new FacturaDAO();
		return instancia;
	}
	
	public void save(FacturaDAO factura){

	FacturaEntity fact = this.toEntity(factura);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(fact);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private FacturaEntity toEntity(FacturaDAO factura) {	
		return null;

	}
	
	public void calcularTotal(FacturaEntity factura, float precio) {
			SessionFactory t = HibernateUtil.getSessionFactory();
			Session session = t.openSession();
			session.beginTransaction();
			String senten = "UPDATE Factura SET precioTotal = ? WHERE nroFactura = ?";
			session.beginTransaction();
			session.createQuery(senten).setFloat(0, precio).setInteger(1, factura.getCodFactura()).executeUpdate();;
			session.getTransaction().commit();
			session.close();
	}
}
