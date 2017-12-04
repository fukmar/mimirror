package dao;
import enumns.CategoriaPlato;
import enumns.EstadoRemito;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.ItemRemitoEntity;
import entities.PlatoEntity;
import entities.RemitoEntity;
import entities.SolicitudIndividualEntity;
import enumns.EstadoSolicitud;
import hibernate.HibernateUtil;
import negocio.ItemRemito;
import negocio.MateriaPrima;
import negocio.Plato;
import negocio.Remito;
import negocio.SolicitudIndividual;


public class RemitoDAO {

	private static RemitoDAO instancia;
	private static SessionFactory sf=null;
	
	private RemitoDAO(){}
	
	public static RemitoDAO getInstance()
	{
		if(instancia == null)
		{
			instancia = new RemitoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(Remito remito)
	{ //VERIFICAR ZUKI POR FAVOR..ACABO DE CAMBIARLO.

	RemitoEntity rem = remito.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(rem);
	session.getTransaction().commit();
	session.close();
	} 
	  
	public List<ItemRemito> getItemsRemitos(int codigoRemito)
	{
		List<ItemRemito> listaItemRemitos=new ArrayList<ItemRemito>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
 		@SuppressWarnings("unchecked")
		List<ItemRemitoEntity> itemsRemito=session.createQuery("from ItemRemitoEntity where remito.codRemito=?").setInteger(0,codigoRemito).list();
		for(ItemRemitoEntity item:itemsRemito) 
		{
			listaItemRemitos.add(item.toNegocio());
		}
		session.close();
		return listaItemRemitos;
	}
	public ItemRemito getItemRemito(Integer codigoitemRemito)
	{
		ItemRemito ItemRemitos=new ItemRemito();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
 		@SuppressWarnings("unchecked")
		ItemRemitoEntity itemRemito=(ItemRemitoEntity) session.createQuery("from ItemRemitoEntity where codItemRemito=?").setInteger(0,codigoitemRemito).uniqueResult();
		return itemRemito.toNegocio();
	}
	public void ingresarMateriaPrima (Remito r)
	{		
		if (r.getEstado()==EstadoRemito.EnProceso)
		{

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran=session.beginTransaction();
			//session.beginTransaction();
			List <ItemRemito> items = RemitoDAO.getInstance().getItemsRemitos(r.getCodRemito());
			for(ItemRemito item:items)
				{
					float cantidadingresada=item.getCantidad();
					float cantidadactual=MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(item.getMateriaprima());
					float cantidadfinal=cantidadingresada+cantidadactual;
					MateriaPrima mp=MateriaPrimaDAO.getInstance().getMateriaPrimaByCod(item.getMateriaprima().getCodigo());
					MateriaPrimaDAO.getInstance().updateCantidadMateriaPrima(mp, cantidadfinal);
				}
			tran.commit();
			session.close();
		}
	}
	public void ingresarMateriaPrimaporItemRemito ()
	{		
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran=session.beginTransaction();
			Integer maxitemremito=(Integer) session.createQuery("select max(codItemRemito) from ItemRemitoEntity").uniqueResult();
			ItemRemito itemremito=RemitoDAO.getInstance().getItemRemito(maxitemremito);
			//session.beginTransaction();
			SessionFactory sf2 = HibernateUtil.getSessionFactory();
			Session session2 = sf2.openSession();
			Transaction tran2=session2.beginTransaction();
			float cantidadingresada=itemremito.getCantidad();
			float cantidadactual=MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(itemremito.getMateriaprima());
			float cantidadfinal=cantidadingresada+cantidadactual;
			MateriaPrima mp=MateriaPrimaDAO.getInstance().getMateriaPrimaByCod(itemremito.getMateriaprima().getCodigo());
			MateriaPrimaDAO.getInstance().updateCantidadMateriaPrima(mp, cantidadfinal);
			tran.commit();
			session.close();
			tran2.commit();
			session2.close();
		}
	
		public void updateEstadoRemito(Remito remito, String estado)
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			session.beginTransaction();
			EstadoRemito estadoremito=estadoremitofromString(estado);
			Query query=session.createQuery("update from RemitoEntity r set r.estado = ? where codRemito= ? ");
	 		query.setParameter(0, estadoremito);
			query.setFloat(1,remito.getCodRemito());
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
		}
		
		
		private EstadoRemito estadoremitofromString(String estado)
		{
			return EstadoRemito.valueOf(estado);
		}
		
		
		
		public List<Remito> getRemitos()
		{
			List<Remito> remitos=new ArrayList<Remito>();
			Session session=sf.openSession();
			List<RemitoEntity> resu=session.createQuery("from RemitoEntity").list();
			for(RemitoEntity r: resu)
			{
				remitos.add(r.toNegocio());
			}
			session.close();
			return remitos;
		}
		
		public Remito getRemitoByCod(Integer codRemito)
		{
			Remito remito=new Remito();
			Session session=sf.openSession();
			System.out.println("busco remito numero "+codRemito);
			RemitoEntity resu=(RemitoEntity) session.createQuery("from RemitoEntity r where r.codRemito=?").setInteger(0, codRemito).uniqueResult();
			remito=resu.toNegocio();
			session.close();
			return remito;
		}
	}


