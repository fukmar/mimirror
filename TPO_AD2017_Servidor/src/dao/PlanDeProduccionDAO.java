package dao;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AdministracionEntity;
import entities.PlanDeProduccionEntity;
import hibernate.HibernateUtil;
import negocio.Administracion;

public class PlanDeProduccionDAO {
	
	private static PlanDeProduccionDAO dao;
	private static SessionFactory sf;
	
	
	
	private PlanDeProduccionDAO(){
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static PlanDeProduccionDAO getDAO(){
		if(dao == null)
			dao = new PlanDeProduccionDAO();
		return dao;
	}
	
	
	public PlanDeProduccionEntity obtenerPlan(int codPdp) {
		
		Session s=sf.openSession();
		s.beginTransaction();
		PlanDeProduccionEntity plan=(PlanDeProduccionEntity) s.createQuery("FROM PlanDeProduccionEntity WHERE codigoPDP=?").setInteger(0, codPdp).uniqueResult();
		s.getTransaction().commit();
		return plan;
	}
	
	public void save(PlanDeProduccionEntity plan) {
		
		//PlanDeProduccionEntity pl = this.toEntity(plan);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(plan);
		session.getTransaction().commit();
		session.close();
	}
	
}
