package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.ItemComandaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.hbt;
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
	SessionFactory sf = hbt.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ic);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private ItemComandaEntity toEntity(ItemComandaDAO itemcomanda) {	
		return null;

	}
	
}
