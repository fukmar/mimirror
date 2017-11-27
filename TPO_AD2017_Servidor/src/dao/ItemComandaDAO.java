package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.ItemComandaEntity;
import entities.MateriaPrimaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.Ingrediente;
import negocio.ItemComanda;
import negocio.MateriaPrima;
import negocio.Plato;
import negocio.SemiElaborado;

public class ItemComandaDAO {

	
private static ItemComandaDAO instancia;
	
	private ItemComandaDAO(){}
	
	public static ItemComandaDAO getInstance(){
		if(instancia == null)
			instancia = new ItemComandaDAO();
		return instancia;
	}
	
	public void save(ItemComanda itemcomanda){

	ItemComandaEntity ic = itemcomanda.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ic);
	session.getTransaction().commit();
	session.close();
	}
	
	public List <ItemComanda> obtenerItemComandasAbiertasxMesa(int codComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<ItemComandaEntity> itemcomandas = session.createQuery("from ItemComandaEntity c where c.comanda.codComanda=?").setInteger(0, codComanda).list();
		List <ItemComanda> itemcomandasnegocio=new ArrayList<ItemComanda>();
		for (ItemComandaEntity i:itemcomandas)
		{
			itemcomandasnegocio.add(i.toNegocio());
		}
		session.getTransaction().commit();
		session.close();
		return itemcomandasnegocio;
	}
	
	public ItemComanda obtenerItemComandaByCod(int coditemComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		ItemComandaEntity itemcomanda = (ItemComandaEntity)session.createQuery("from ItemComandaEntity c where c.coditemComanda=?").setInteger(0, coditemComanda).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return itemcomanda.toNegocio();
	}
	public void reducirstockxItemComanda(ItemComanda i){
		
		
		List <Ingrediente> ingredientes=PlatoDAO.getInstance().getIngredientes(i.getPlato());
		for (Ingrediente ing:ingredientes)
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			MateriaPrima mp=ing.getMateriaprima();
			float cantidadenstock=MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(ing.getMateriaprima());
			float cantidadfinal=cantidadenstock-(ing.getCantidad()*i.getCantidad());
			MateriaPrimaEntity mpentity =(MateriaPrimaEntity) session.get(MateriaPrimaEntity.class,mp.getCodigo()); 
			mpentity.setCantidad(cantidadfinal);
			session.merge(mpentity);
			session.getTransaction().commit();
			session.close();
			}
		}
	
}
