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
	
	public Double calcularMonto(int nroFact){
		Session session = sf.openSession();
		Double monto = (Double)session.createQuery("SELECT SUM(itc.precio_monto*itp.cantidad) FROM ItemFactura itf JOIN itf.factura fac JOIN itf.item_pedido itp JOIN itp.item_carta itc WHERE fac.factura_id=? AND itp.item_no_facturar_ind=false").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		return monto;
	}
	
	public void addItemsFactura(Item_Factura item){
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(item);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	

	public void actualizarFactura(Factura fac){
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(fac);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	

	public Double getMontoPagos(int nroFact){
		Session session = sf.openSession();
		Double monto = (Double)session.createQuery("SELECT SUM(p.monto_total) FROM Factura f JOIN f.pagos p WHERE f.factura_id=?").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		return monto;
	}
	
	public FacturaEntity getFacturaxComanda(int idComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		FacturaEntity factura= (FacturaEntity)session.createQuery("SELECT f FROM Factura f where f.).setInteger(0,pedidoID).setFirstResult(0).setMaxResults(1).uniqueResult();
		return factura;
	}
	
	public float getLiquidacionesUnMozoDia(Date d, int idMozo){
		//liquidacion de un mozo
		Session session = sf.openSession();
		Query q;
		float liq; 
		String theQuery= "select SUM(f.monto_total*m.comision) from Factura f "
				+ "JOIN Mozo m ON f.factura_mozo = m.mozo_id "
				+ "WHERE f.factura_mozo = :idmozo"
				+ "AND f.fecha_factura_dt = :date";

		q=session.createQuery(theQuery);
		q.setParameter("idmozo", idMozo);
		q.setDate("date", d);
		liq = (int)q.uniqueResult();
		session.close();

		return liq;
	}
	
	/*public List <Liquidacion_Comision_Mozo> getLiquidacionDiaComisiones(Date d){
		//liquidacion de todos los mozos
		List <Mozo> todosMozos = new LinkedList <Mozo>();
		todosMozos= LocationDAO.getInstancia().getMozos();
>>>>>>> .r189
		
		return null;
	}*/

	public void grabarLiquidaciones(Liquidacion_Comision_Mozo liqui){				
		Session session = sf.openSession();
		
		session.persist(liqui);
				
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getItems(int nro) {
		Session session = sf.openSession();
		List<Object[]> items = (List<Object[]>) session.createQuery("SELECT pla.name, it.cant_plato, car.precio_monto, itp.item_no_facturar_ind FROM Factura fac JOIN fac.items it JOIN it.item_plato pla JOIN it.item_pedido itp JOIN itp.item_carta car WHERE fac.factura_id =?").setInteger(0,nro).list();
		session.close();
		return items;
	}
	
		
}

	
}
