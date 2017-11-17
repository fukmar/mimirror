package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	
	private MesaDAO(){}
	
	public static MesaDAO getInstance(){
		if(instancia == null)
			instancia = new MesaDAO();
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
	
}