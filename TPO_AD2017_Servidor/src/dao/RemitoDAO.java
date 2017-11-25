package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemRemitoEntity;
import entities.PlatoEntity;
import entities.RemitoEntity;
import hibernate.HibernateUtil;
import negocio.ItemRemito;
import negocio.MateriaPrima;
import negocio.Plato;
import negocio.Remito;


public class RemitoDAO {

	private static RemitoDAO instancia;
	
	private RemitoDAO(){}
	
	public static RemitoDAO getInstance(){
		if(instancia == null)
			instancia = new RemitoDAO();
		return instancia;
	}
	
	public void save(Remito remito){ //VERIFICAR ZUKI POR FAVOR..ACABO DE CAMBIARLO.

	RemitoEntity rem = remito.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(rem);
	session.getTransaction().commit();
	session.close();
	}
	public List<ItemRemito> getItemsRemitos()
	{
		List<ItemRemito> listaItemRemitos=new ArrayList<ItemRemito>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
 		@SuppressWarnings("unchecked")
		List<ItemRemitoEntity> itemsRemito=session.createQuery("from ItemRemitoEntity").list();
		for(ItemRemitoEntity item:itemsRemito) 
		{
			listaItemRemitos.add(item.toNegocio());
		}
		session.close();
		return listaItemRemitos;
	}
	public void ingresarMateriaPrima (Remito r)
	{		
		
		for(ItemRemito item:r.getItemsRemito())
		{
			float cantidadingresada=item.getCantidad();
			float cantidadactual=MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(item.getMateriaprima());
			float cantidadfinal=cantidadingresada+cantidadactual;
			MateriaPrima mp=MateriaPrimaDAO.getInstance().getMateriaPrimaPorId(item.getMateriaprima().getCodigo());
			MateriaPrimaDAO.getInstance().updateCantidadMateriaPrima(mp, cantidadfinal);
		}
		
	}

	
	
}
