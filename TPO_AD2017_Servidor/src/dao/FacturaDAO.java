package dao;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.FacturaEntity;
import entities.ItemComandaEntity;
import entities.ItemFacturaEntity;
import enumns.Estado;
import hibernate.HibernateUtil;
import negocio.Comanda;
import negocio.Factura;
import negocio.ItemComanda;
import negocio.ItemFactura;


public class FacturaDAO
{
	private static FacturaDAO instancia=null;
	private static SessionFactory sf=null;
	
	private FacturaDAO(){}
	
	public static FacturaDAO getInstance()
	{
		if(instancia == null) 
		{
			instancia = new FacturaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
			
		return instancia;
	}
	
	public void save(Factura factura)
	{
		FacturaEntity fact = factura.toEntity();
		//System.out.println(fact);
		Session session=sf.openSession();
		Transaction tran=session.beginTransaction();
		session.save(fact);
		tran.commit();
		session.close();
	}


	
	public void actualizarTotalFactura(int nroFact){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Double totalfactura = (Double)session.createQuery("SELECT SUM(itf.subtotal) FROM ItemFacturaEntity itf join itf.factura fac WHERE fac.codFactura=?").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		Factura factura=new Factura();
		factura=FacturaDAO.getInstance().obtenerFacturaByCod(nroFact);
		factura.setImporte(totalfactura);
		session.merge(factura);
		session.getTransaction().commit();
		session.close();
	}
	
	///CZ
	/*public void actualizarTotalFactura2(int nroFact){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Double totalfactura = (Double)session.createQuery("SELECT SUM(itf.subtotal) FROM ItemFacturaEntity itf join itf.factura fac WHERE fac.codFactura=?").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		FacturaEntity factura=new FacturaEntity();
		Factura facturaN=FacturaDAO.getInstance().obtenerFacturaByNro2(nroFact);
		factura=facturaN.toEntity();
		factura.setImporte(totalfactura);
		session.merge(factura);
		session.getTransaction().commit();
		session.close();
	}*/
	
	public Factura obtenerFacturaByCod(Integer codFactura){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		FacturaEntity factura=new FacturaEntity();
		factura = (FacturaEntity)session.createQuery("FROM FacturaEntity fac WHERE fac.codFactura=?").setInteger(0,codFactura).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return factura.toNegocio();
	}
	
	
	///CZ
	  	/*public Factura obtenerFacturaByNro2(int nroFact){
		Factura factura=new Factura();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		FacturaEntity resu = (FacturaEntity)session.createQuery("FROM FacturaEntity fac WHERE fac.codFactura=?").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		factura=resu.toNegocio();
		return factura;
	}*/
	
	public void addItemsFactura(ItemFactura item){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(item);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	//esto tiene que recibir Factura (negocio)

	public void cerrarFactura(Factura f){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		//Obtengo los item comandas y los transformo a item factura.  Miro de la mesa de la factura cuales son las comandas que no fueron facturadas.
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Estado estado=estadocomandafromString("EnProceso");
		List <ItemComandaEntity> itemscomandas=session.createQuery("from ItemComandaEntity i where i.comanda.mesa.codMesa=? and i.comanda.estado=?").setInteger(0,f.getMesa().getCodMesa()).setParameter(1, estado).list();
		session.getTransaction().commit();
		session.close();
		double totalfactura=0;
		for (ItemComandaEntity i :itemscomandas){
			SessionFactory sf2 = HibernateUtil.getSessionFactory();
			Session session2 = sf2.openSession();
			session2.beginTransaction();
			ItemFacturaEntity item=new ItemFacturaEntity();
			item.setFactura(f.toEntity());
			item.setItemcomanda(i);
			item.setSubtotal(i.getCantidad()*i.getPlato().getPrecio());
			totalfactura=totalfactura+item.getSubtotal();
			session2.merge(item);
			session2.getTransaction().commit();
			session2.close();
		}
		//Actualizo el valor de la factura final
		SessionFactory sf3 = HibernateUtil.getSessionFactory();
		Session session3 = sf.openSession();
		session3.beginTransaction();
		f.setImporte(totalfactura);
		session3.update(f.toEntity());
		session3.getTransaction().commit();
		session3.close();
		SessionFactory sf4 = HibernateUtil.getSessionFactory();
		//Actualizo estados comanda
		Session session4 = sf4.openSession();
		session4.beginTransaction();
		estado=estadocomandafromString("EnProceso");
		List <ComandaEntity> comandas=session4.createQuery("from ComandaEntity c where c.mesa.codMesa=? and c.estado=?").setInteger(0,f.getMesa().getCodMesa()).setParameter(1, estado).list();
		for (ComandaEntity c:comandas)
		{
			SessionFactory sf5 = HibernateUtil.getSessionFactory();
			Session session5 = sf5.openSession();
			session5.beginTransaction();
			c.setEstado(Estado.Terminado);
			session5.update(c);
			session5.getTransaction().commit();
			session5.close();
		}
		
		session4.getTransaction().commit();
		session4.close();
	}
	private Estado estadocomandafromString(String estado)
	{
		return Estado.valueOf(estado);
	}

	public Double getMontoPagos(int nroFact){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Double monto = (Double)session.createQuery("SELECT SUM(p.monto_total) FROM Factura f JOIN f.pagos p WHERE f.factura_id=?").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return monto;
	}
	
	public List<Factura> getFacturas()
	{
		List<Factura> facturas=new ArrayList<Factura>();
		//HibernateUtil.initialize(facturas.get
		Session session=sf.openSession();
		List<FacturaEntity> resu=session.createQuery("from FacturaEntity").list();
		for(FacturaEntity f:resu) 
		{
			facturas.add(f.toNegocio());
		}
		session.close();
		return facturas;
	}
	/*
	public FacturaEntity getFacturaxComanda(int idComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//FacturaEntity factura= (FacturaEntity)session.createQuery("FROM ItemComandaEntity if where if.).setInteger(0,pedidoID).setFirstResult(0).setMaxResults(1).uniqueResult();"
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
	}*/
	
	/*public List <Liquidacion_Comision_Mozo> getLiquidacionDiaComisiones(Date d){
		//liquidacion de todos los mozos
		List <Mozo> todosMozos = new LinkedList <Mozo>();
		todosMozos= LocationDAO.getInstancia().getMozos();
>>>>>>> .r189
		
		return null;
	}*/
/*
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
	
	*/	
}

	

