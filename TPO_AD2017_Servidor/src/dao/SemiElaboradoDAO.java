package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Plato;
import negocio.SemiElaborado;

public class SemiElaboradoDAO {

	
private static SemiElaboradoDAO instancia;
	
	private SemiElaboradoDAO(){}
	
	public static SemiElaboradoDAO getInstance(){
		if(instancia == null)
			instancia = new SemiElaboradoDAO();
		return instancia;
	}
	
	public void save(SemiElaborado semielab){

	SemiElaboradoEntity see = this.toEntity(semielab);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(see);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private SemiElaboradoEntity toEntity(SemiElaborado semielab) {	
		return null;

	}
	
}

