package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.FacturaEntity;
import entities.ItemComandaEntity;
import entities.ItemFacturaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import enumns.Estado;
import enumns.EstadoRemito;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.Factura;
import negocio.ItemComanda;
import negocio.ItemFactura;
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
	
	public void save(ItemFactura itemfactura)
	{
		ItemFacturaEntity ite=itemfactura.toEntity(); //aca cambie yo, cz
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(ite);
		session.getTransaction().commit();
		session.close();
	}

	//FALTA
	/*private ItemFacturaDAO toEntity(ItemFacturaDAO itemcomanda) {	
		return null;

	}*/
	
}