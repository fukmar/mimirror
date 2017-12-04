package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.ItemComandaEntity;
import entities.MateriaPrimaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import enumns.AreaRest;
import enumns.CategoriaPlato;
import enumns.EstadoItemComanda;
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
			if (mp.getEstadescontado()==0)
			{
				float cantidadenstock=MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(ing.getMateriaprima());
				float cantidadfinal=cantidadenstock-(ing.getCantidad()*i.getCantidad());
				Query query=session.createQuery("update from MateriaPrimaEntity m set m.cantidad = ? where m.codMaterial= ? ");
				query.setFloat(0, cantidadfinal);
		 		query.setInteger(1, mp.getCodigo());
				query.executeUpdate();
				session.getTransaction().commit();
				session.close();
			}
			} 
		}
	public List<ItemComanda> getItemsPendientesxArea(AreaRest area)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		List<ItemComanda> listaItemComanda=new ArrayList<ItemComanda>();
		
		EstadoItemComanda estado=estadoitemcomandafromString("Pendiente");
		Query query=session.createQuery("from ItemComandaEntity i where i.plato.area=? and i.estado=? ");
 		query.setParameter(0,area);
 		query.setParameter(1,estado);
 		@SuppressWarnings("unchecked")
		List<ItemComandaEntity> resu=query.list();
		for(ItemComandaEntity i:resu) 
		{
			listaItemComanda.add(i.toNegocio());
		}
		session.close();
		return listaItemComanda;
	}
	
	public void updateitemComandatoIniciada(ItemComanda i)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		EstadoItemComanda estado=estadoitemcomandafromString("Iniciada");
		Query query=session.createQuery("update from ItemComandaEntity i set i.estado = ? where i.coditemComanda=?");
 		query.setParameter(1,i.getCoditemComanda());
 		query.setParameter(0,estado);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	public boolean HaySuficiente (List<Ingrediente> ingredientesnecesarios, int cantidad)
	{
	
		int sepuede=0;
		for(Ingrediente i:ingredientesnecesarios) 
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			session.beginTransaction();
			MateriaPrimaEntity mp= new MateriaPrimaEntity();
			mp=(MateriaPrimaEntity) session.createQuery("from MateriaPrimaEntity mp where mp.codMaterial=?").setInteger(0,i.getMateriaprima().getCodigo()).uniqueResult();
	 		if (mp.getCantidad()<(i.getCantidad()*cantidad))
	 			sepuede++;
	 		session.close();
		}
		if (sepuede==0) return true;
		else return false;
	}
	public void updateitemComandatoFinalizada(ItemComanda i)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		EstadoItemComanda estado=estadoitemcomandafromString("Finalizada");
		Query query=session.createQuery("update from ItemComandaEntity i set i.estado = ? where i.coditemComanda=?");
 		query.setParameter(1,i.getCoditemComanda());
 		query.setParameter(0,estado);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	private EstadoItemComanda estadoitemcomandafromString(String estadoitem)
	{
		return EstadoItemComanda.valueOf(estadoitem);
	}
	private AreaRest areaitemcomandafromString(String area)
	{
		return AreaRest.valueOf(area);
	}
}
