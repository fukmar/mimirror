package dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComandaEntity;
import entities.ElaboradoEntity;
import entities.ItemComandaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Elaborado;
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
	
	public void save(ItemComandaDAO itemcomanda){

	ItemComandaEntity ic = this.toEntity(itemcomanda);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ic);
	session.getTransaction().commit();
	session.close();
	}
	public List <ItemComandaEntity> obtenerItemComandasAbiertasxMesa(int codComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<ItemComandaEntity> itemscomanda = session.createQuery("from ItemComandaEntity c where c.comanda.codComanda=?").setInteger(0, codComanda).list();
		session.getTransaction().commit();
		session.close();
		return itemscomanda;
	}
	
	public ItemComandaEntity obtenerItemComanda(int coditemComanda){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		ItemComandaEntity itemcomanda = (ItemComandaEntity)session.createQuery("from ItemComandaEntity c where c.coditemComanda=?").setInteger(0, coditemComanda).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return itemcomanda;
	}
	//FALTA
	private ItemComandaEntity toEntity(ItemComandaDAO itemcomanda) {	
		return null;

	}
	
}
