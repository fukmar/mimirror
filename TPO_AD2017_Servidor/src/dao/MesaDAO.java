package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.tree.SessionFactoryAwareNode;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.MesaEntity;
import entities.ItemComandaEntity;
import entities.MesaEntity;
import enumns.Estado;
import enumns.EstadoItemComanda;
import hibernate.HibernateUtil;
import negocio.Factura;
import negocio.ItemComanda;
import negocio.ItemFactura;
import negocio.Mesa;


public class MesaDAO {

	
private static MesaDAO instancia;
private static SessionFactory sf=null;
	
	private MesaDAO(){}
	
	public static MesaDAO getInstance()
	{
		if(instancia == null) {
			instancia = new MesaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public Mesa obtenerMesaPorCod(int nromesa)
	{
		Mesa mesa=new Mesa();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//MesaEntity mesa=new MesaEntity();
		MesaEntity resu= (MesaEntity)session.createQuery("FROM MesaEntity m WHERE m.codMesa=?").setInteger(0,nromesa).setFirstResult(0).setMaxResults(1).uniqueResult();
		mesa=resu.toNegocio();
		return mesa;
	}
	
	//Listar mesas pero devuelve negocio
	public Mesa getMesaN(Integer codmesa)
	{
		Mesa mesa=new Mesa();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		MesaEntity resu = (MesaEntity)session.createQuery("FROM MesaEntity m WHERE m.codMesa=?").setInteger(0,codmesa).setFirstResult(0).setMaxResults(1).uniqueResult();
		mesa=resu.toNegocio();
		return mesa;
	}
	
	
	public List<Mesa> getMesas()
	{
		Session session=sf.openSession();
		List<Mesa> listaM=new ArrayList<Mesa>();
		List<MesaEntity> resu=session.createQuery("from MesaEntity").list();
		for(MesaEntity m:resu)
		{
			listaM.add(m.toNegocio());
		}
		session.close();
		return listaM;
	}
	public void updateMesaToOcupada(Mesa m)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("update from MesaEntity m set m.estado = ? where m.codMesa=?");
 		query.setParameter(0,1);
 		query.setParameter(1,m.getCodMesa());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	public void updateMesaToLibre(Mesa m)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("update from MesaEntity m set m.estado = ? where m.codMesa=?");
 		query.setParameter(0,0);
 		query.setParameter(1,m.getCodMesa());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Mesa> getMesasLibres()
	{
		Session session=sf.openSession();
		List<Mesa> listaM=new ArrayList<Mesa>();
		List<MesaEntity> resu=session.createQuery("from MesaEntity m where m.estado=0").list();
		for(MesaEntity m:resu)
		{
			listaM.add(m.toNegocio());
		}
		session.close();
		return listaM;
	}
	
	public boolean validateMesasLibresbyCantidad(int cantidadpersonas)
	{
		Session session=sf.openSession();
		List<Mesa> listaM=new ArrayList<Mesa>();
		List<MesaEntity> resu=session.createQuery("from MesaEntity m where m.estado=0 and m.capacidad>?").setInteger(0, cantidadpersonas).list();
		for(MesaEntity m:resu)
		{
			listaM.add(m.toNegocio());
		}
		session.close();
		if (resu.isEmpty()) return false;
		else return true;
	}
	
	public List<Mesa> getMesasLibresbyCantidad(int cantidadpersonas)
	{
		Session session=sf.openSession();
		List<Mesa> listaM=new ArrayList<Mesa>();
		List<MesaEntity> resu=session.createQuery("from MesaEntity m where m.estado=0 and m.capacidad>?").setInteger(0, cantidadpersonas).list();
		for(MesaEntity m:resu)
		{
			listaM.add(m.toNegocio());
		}
		session.close();
		return listaM;
		
	}
	
}