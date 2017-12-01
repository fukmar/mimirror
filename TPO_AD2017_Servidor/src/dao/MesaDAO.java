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
		List<MesaEntity> resu=session.createQuery("from MesaEntity m  where m.activa=0").list();
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
		List<MesaEntity> resu=session.createQuery("from MesaEntity m where m.estado=0 and m.activa=0").list();
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
		List<MesaEntity> resu=session.createQuery("from MesaEntity m where m.estado=0 and m.capacidad>? or m.capacidad=? and m.activa=0").setInteger(0, cantidadpersonas).setInteger(1, cantidadpersonas).list();
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
		List<MesaEntity> resu=session.createQuery("from MesaEntity m where m.estado=0 and m.capacidad>? or m.capacidad=? and m.activa=0").setInteger(0, cantidadpersonas).setInteger(1, cantidadpersonas).list();
		for(MesaEntity m:resu)
		{
			listaM.add(m.toNegocio());
		}
		session.close();
		return listaM;
		
	}
	public Mesa combinarMesa (Mesa mesa1, Mesa mesa2)
		{
			if (mesa1.getEstado()==0 && mesa2.getEstado()==0 && mesa1.getActiva()==0 && mesa2.getActiva()==0)
			{
				if (mesa1.getSector().getCodSector()==mesa2.getSector().getCodSector())
					{
						int capacidadnueva=mesa1.getCapacidad()+mesa2.getCapacidad();
						MesaEntity mesa3=new MesaEntity();
						mesa3.setCapacidad(mesa1.getCapacidad()+mesa2.getCapacidad());
						mesa3.setCombinada(1);
						mesa3.setEstado(1);
						mesa3.setCantidadPersonas(0);
						mesa3.setSector(mesa1.getSector().toEntity());
						mesa3.setMozo(mesa1.getMozo().toEntity());
						SessionFactory sf = HibernateUtil.getSessionFactory();
						Session session=sf.openSession();
						session.beginTransaction();
						Query query=session.createQuery("update from MesaEntity m set m.combinada = ? where m.codMesa=? or m.codMesa=?");
				 		query.setParameter(0,2);
				 		query.setParameter(1,mesa1.getCodMesa());
				 		query.setParameter(2,mesa2.getCodMesa());
						query.executeUpdate();
						session.getTransaction().commit();
						session.close();
						SessionFactory sf2 = HibernateUtil.getSessionFactory();
						Session session2=sf2.openSession();
						session2.beginTransaction();
						session2.save(mesa3);
						session2.getTransaction().commit();
						session2.close();
						updateMesaToOcupada(mesa1);
						updateMesaToOcupada(mesa2);
						SessionFactory sf3 = HibernateUtil.getSessionFactory();
						Session session3=sf3.openSession();
						session3.beginTransaction();
						Query query3=session3.createQuery("update from MesaEntity m set m.combinador = ? where m.codMesa=? or m.codMesa=? or m.codMesa=?");
				 		query3.setParameter(0,mesa3.getCodMesa());
				 		query3.setParameter(1,mesa1.getCodMesa());
				 		query3.setParameter(2,mesa2.getCodMesa());
				 		query3.setParameter(3,mesa3.getCodMesa());
						query3.executeUpdate();
						session3.getTransaction().commit();
						session3.close();
						return (mesa3.toNegocio());
					}
						
				}
			return null;
		}
	public void LiberarMesaCombinada (Mesa mesacombinada)
	{
		SessionFactory sf4 = HibernateUtil.getSessionFactory();
		Session session4=sf4.openSession();
		session4.beginTransaction();
		Query query4=session4.createQuery("update from MesaEntity m set m.estado = 0, m.combinador = 0, m.combinada=0 where m.combinador=? and m.combinada=2");
 		query4.setParameter(0,mesacombinada.getCodMesa());
		query4.executeUpdate();
		session4.getTransaction().commit();
		session4.close();
		
		SessionFactory sf3 = HibernateUtil.getSessionFactory();
		Session session3=sf3.openSession();
		session3.beginTransaction();
		Query query3=session3.createQuery("update from MesaEntity m set m.estado = 0, m.combinador = 0,m.activa=1 where m.combinador=?");
 		query3.setParameter(0,mesacombinada.getCodMesa());
		query3.executeUpdate();
		session3.getTransaction().commit();
		session3.close();
		
	}
}