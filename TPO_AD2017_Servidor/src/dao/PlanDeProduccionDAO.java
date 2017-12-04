package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AdministracionEntity;
import entities.ItemPlanProduccionEntity;
import entities.MateriaPrimaEntity;
import entities.MesaEntity;
import entities.PlanDeProduccionEntity;
import entities.PlatoEntity;
import enumns.EstadoRemito;
import hibernate.HibernateUtil;
import negocio.Administracion;
import negocio.Ingrediente;
import negocio.ItemPlanProduccion;
import negocio.MateriaPrima;
import negocio.Mesa;
import negocio.PlanDeProduccion;
import negocio.Plato;

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
	
	public List<PlanDeProduccion> getPlanesProduccion()
	{
		Session session=sf.openSession();
		List<PlanDeProduccion> listaM=new ArrayList<PlanDeProduccion>();
		List<PlanDeProduccionEntity> resu=session.createQuery("from PlanDeProduccionEntity p").list();
		for(PlanDeProduccionEntity p:resu)
		{
			listaM.add(p.toNegocio());
		}
		session.close();
		return listaM;
	}  
	
	
	public PlanDeProduccion getPlanByCod(int codPdp) {
		 
		Session s=sf.openSession();
		s.beginTransaction();
		PlanDeProduccionEntity plan=(PlanDeProduccionEntity) s.createQuery("FROM PlanDeProduccionEntity WHERE codigoPDP=?").setInteger(0, codPdp).uniqueResult();
		s.getTransaction().commit();
		return plan.toNegocio();
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
			Long CantidadFacturada=SemiElaboradoDAO.getInstance().getSemiElaboradoFacturados(item.getSemielaborado(), plan.getFechaplan());
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
	
	public void save(PlanDeProduccion plan) {
		
		//PlanDeProduccionEntity pl = this.toEntity(plan);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(plan.toEntity()); //cz pasado a entity
		session.getTransaction().commit();
		session.close();
	}
	public List<ItemPlanProduccion> getItemPlanPorCodPlan(int nroPlanDeProduccion)
	{
		PlanDeProduccion plan=PlanDeProduccionDAO.getInstance().getPlanByCod(nroPlanDeProduccion);
		PlanDeProduccionDAO.getInstance().CalcularporcentajeAvance(plan);
		Session session=sf.openSession();
	
		List<ItemPlanProduccion> listaM=new ArrayList<ItemPlanProduccion>();
		List<ItemPlanProduccionEntity> resu=session.createQuery("from ItemPlanProduccionEntity i where i.plandeProduccion.codigoPDP=?").setInteger(0, nroPlanDeProduccion).list();
		for(ItemPlanProduccionEntity i:resu)
		{
			listaM.add(i.toNegocio());
		}
		session.close();
		return listaM;
	}
	public void reducirstockxSemiElaborado(ItemPlanProduccion itemplan)
	{
		
		List <Ingrediente> ingredientes=PlatoDAO.getInstance().getIngredientesdeSemi(itemplan.getSemielaborado());
		for (Ingrediente ing:ingredientes)
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			MateriaPrima mp=ing.getMateriaprima();
			if (mp.getEstadescontado()==0)
			{
				float cantidadenstock=MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(ing.getMateriaprima());
				float cantidadfinal=cantidadenstock-(ing.getCantidad()*itemplan.getCantidad());
				MateriaPrimaEntity mpentity =(MateriaPrimaEntity) session.get(MateriaPrimaEntity.class,mp.getCodigo()); 
				mpentity.setCantidad(cantidadfinal);
				mpentity.setEstadescontado(1);
				session.merge(mpentity);
			}
			session.getTransaction().commit();
			session.close();
			}
		}
	
}
