package dao;

import org.hibernate.*;

import entities.AdministracionEntity;
import entities.ElaboradoEntity;

import java.util.*;
import javax.persistence.*;
import hibernate.*;
import negocio.Administracion;

public class AdministracionDAO {

	private static AdministracionDAO dao;
	private static SessionFactory sf;
	
	private AdministracionDAO() {
		sf=HibernateUtil.getSessionFactory();
	}
	
	public static AdministracionDAO getDAO() {
			if(dao==null) {
				dao=new AdministracionDAO();
			}
			
			return dao;
		
	}
	/*
	public void agregarPlanDeProd(int codPdp) {
		Session s=sf.openSession();
		s.beginTransaction();
		
	}*/
	
	public void save(AdministracionEntity admin) {
	
		//AdministracionEntity ad = this.toEntity(admin);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}
	
}
