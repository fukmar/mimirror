package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.ItemFacturaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.Plato;
import negocio.SemiElaborado;

public class ItemFacturaDAO {

	
private static ItemFacturaDAO instancia;
	
	private ItemFacturaDAO(){}
	
	public static ItemFacturaDAO getInstance(){
		if(instancia == null)
			instancia = new ItemFacturaDAO();
		return instancia;
	}
	
	public void save(ItemFacturaEntity itemfactura){
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(itemfactura);
	session.getTransaction().commit();
	session.close();
	}
	public Double calcularSubTotalItemFactura(int codItemFactura){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Double subtotal = (Double)session.createQuery("select SUM(itcom.cantidad * p.precio) from ItemFacturaEntity itfac join itfac.itemcomanda itcom join itcom.plato p where itfac.codItemFactura=?").setInteger(0,codItemFactura).uniqueResult();
		return subtotal;
	}
	public ItemFacturaEntity obtenerItemFactura(int codItemFactura){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		ItemFacturaEntity item=new ItemFacturaEntity();
		item = (ItemFacturaEntity)session.createQuery("from ItemFacturaEntity where coditemComanda=?").setInteger(0,codItemFactura).uniqueResult();
		return item;
	}
	public void actualizarsubtotalItemFactura(int codItemFactura)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		ItemFacturaEntity itemfact=new ItemFacturaEntity();
		itemfact=ItemFacturaDAO.getInstance().obtenerItemFactura(codItemFactura);
		double subtotal=ItemFacturaDAO.getInstance().calcularSubTotalItemFactura(itemfact.getCodItemFactura());
		itemfact.setSubtotal(subtotal);
		session.merge(itemfact);
		session.getTransaction().commit();
		session.close();
	}
	//FALTA
	private ItemFacturaDAO toEntity(ItemFacturaDAO itemcomanda) {	
		return null;

	}
	
}
