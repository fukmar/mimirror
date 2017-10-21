package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.hbt;
import negocio.Elaborado;
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
	
	public void save(ItemFacturaDAO itemcomanda){

	ItemFacturaDAO ifac = this.toEntity(itemcomanda);
	SessionFactory sf = hbt.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ifac);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private ItemFacturaDAO toEntity(ItemFacturaDAO itemcomanda) {	
		return null;

	}
	
}
