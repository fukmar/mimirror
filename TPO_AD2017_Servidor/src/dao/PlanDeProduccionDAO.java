package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AdministracionEntity;
import entities.PlanDeProduccionEntity;
import enumns.EstadoRemito;
import hibernate.HibernateUtil;
import negocio.Administracion;
import negocio.ItemPlanProduccion;
import negocio.PlanDeProduccion;

public class PlanDeProduccionDAO {
	
	private static PlanDeProduccionDAO instancia;
	private static SessionFactory sf=null;
	
	public static PlanDeProduccionDAO getInstance(){
		if(instancia == null)
		{
			instancia = new PlanDeProduccionDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}

	
	private PlanDeProduccionDAO(){
		sf = HibernateUtil.getSessionFactory();
	}

	
	public PlanDeProduccionEntity obtenerPlan(int codPdp) {
		
		Session s=sf.openSession();
		s.beginTransaction();
		PlanDeProduccionEntity plan=(PlanDeProduccionEntity) s.createQuery("FROM PlanDeProduccionEntity WHERE codigoPDP=?").setInteger(0, codPdp).uniqueResult();
		s.getTransaction().commit();
		return plan;
	}
	
	public PlanDeProduccion obtenerPlanFecha(Date Fecha) {
		SimpleDateFormat sformat=new SimpleDateFormat("dd-MM-YYYY");
		String fromDate=null;
		fromDate=sformat.format(Fecha);
		Session s=sf.openSession();
		s.beginTransaction();
		PlanDeProduccionEntity plan=(PlanDeProduccionEntity) s.createQuery("FROM PlanDeProduccionEntity WHERE fechaplan=?").setString(0, fromDate).uniqueResult();
		s.getTransaction().commit();
		return plan.toNegocio();
	}
	
	public void CalcularporcentajeAvance(PlanDeProduccion plan) {
		Session s2=sf.openSession();
		s2.beginTransaction();
		int totalitemsfacturados=0;
		int totalitemsplanificados=0;
		for (ItemPlanProduccion item: plan.getItemspdp())
		{
			Session s=sf.openSession();
			s.beginTransaction();
			Long CantidadFacturada=SemiElaboradoDAO.getInstance().getSemiElaboradosFacturados(item.getSemielaborado(), plan.getFechaplan());
			double porcentajetotal=(double)CantidadFacturada/item.getCantidad();
			item.setPorcientoavance(porcentajetotal);
			Query query=s.createQuery("update from ItemPlanProduccionEntity i set i.porcientoavance = ? where itemplanid= ? ");
	 		query.setDouble(0, porcentajetotal);
			query.setInteger(1,item.getItemplanid());
			query.executeUpdate();
			totalitemsfacturados=(int) (totalitemsfacturados+CantidadFacturada);
			totalitemsplanificados=totalitemsplanificados+item.getCantidad();
			s.getTransaction().commit();
			s.close();
		}
		double avanceplantotal=	(double)totalitemsfacturados/totalitemsplanificados;
		Query query2=s2.createQuery("update from PlanDeProduccionEntity p set p.avance = ? where codigoPDP= ? ");
 		query2.setDouble(0, avanceplantotal);
		query2.setInteger(1,plan.getCodigoPDP());
		query2.executeUpdate();
		s2.getTransaction().commit();
		s2.close();
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
