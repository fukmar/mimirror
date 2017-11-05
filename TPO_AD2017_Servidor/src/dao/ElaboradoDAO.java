package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.Plato;
import negocio.SemiElaborado;

public class ElaboradoDAO {

	
private static ElaboradoDAO instancia;
	
	private ElaboradoDAO(){}
	
	public static ElaboradoDAO getInstance(){
		if(instancia == null)
			instancia = new ElaboradoDAO();
		return instancia;
	}
	
	public void save(Elaborado elab){

	ElaboradoEntity ee = this.toEntity(elab);
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ee);
	session.getTransaction().commit();
	session.close();
	}

	//FALTA
	private ElaboradoEntity toEntity(Elaborado elab) {	
		return null;

	}
	
}
