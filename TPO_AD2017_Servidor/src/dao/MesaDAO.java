package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.tree.SessionFactoryAwareNode;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.MesaEntity;
import entities.ItemComandaEntity;
import entities.MesaEntity;
import enumns.Estado;
import hibernate.HibernateUtil;
import negocio.Factura;
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
	
	public MesaEntity obtenerMesa(int nromesa){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		MesaEntity mesa=new MesaEntity();
		mesa = (MesaEntity)session.createQuery("FROM MesaEntity m WHERE m.codMesa=?").setInteger(0,nromesa).setFirstResult(0).setMaxResults(1).uniqueResult();
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
	
}