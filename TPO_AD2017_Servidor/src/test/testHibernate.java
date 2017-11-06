package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.MateriaPrimaEntity;
import entities.PlanDeProduccionEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import enumns.Estado;
import hibernate.HibernateUtil;

public class testHibernate {

	//Hagan sus pruebas relacionadas a HIBERNATE ACA
	public static void main(String[] args) 
	{
		
		
		
		/*
		 * 	//aca van pruebas de DB
	/*	LocalEntity test = new LocalEntity(1,"aca","alla");
		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
		*/
		/*
		Estado est = null;
		PlanDeProduccionEntity test = new PlanDeProduccionEntity(est.EnProceso);
		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
		*/
		/*
		UnidadEntity test = new UnidadEntity("unidad uno");
		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
		*/
		/*
		MozoEntity test = new MozoEntity(31575032,"Nahuelito","Grisoluble",80.4f);
		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
		*/
		
		
		UnidadEntity ue = new UnidadEntity("gramos");
	
		Estado est = null;
		PlanDeProduccionEntity pdpe = new PlanDeProduccionEntity(est.EnProceso);
		Date fecha = new Date("10/10/2020");
		
		MateriaPrimaEntity mpe = new MateriaPrimaEntity("desc",ue);
	
		List<MateriaPrimaEntity> materiales = new ArrayList<MateriaPrimaEntity>();
		materiales.add(mpe);
		SemiElaboradoEntity see = new SemiElaboradoEntity("tipo","calidad","desc",pdpe,1,fecha,materiales,ue);
		
		List<SemiElaboradoEntity> componentes = new ArrayList<SemiElaboradoEntity>();
		componentes.add(see);
		
		ElaboradoEntity ee = new ElaboradoEntity("tipo","calidad","pizza",pdpe,1,fecha, ue, componentes);
			
		
		List<ElaboradoEntity> elabs = new ArrayList<ElaboradoEntity>();
		elabs.add(ee);
		
		PlatoEntity test = new PlatoEntity("platito",13f,elabs);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
		
		//aca terminan pruebas de DB
		  
		  /*
 	public List<DTO> funcion() throws RemoteException {
		// TODO Auto-generated method stub
		return manejoNegocio.getInstance().getUnidades();
	}
 
 *****************
 *Mapeadas
 *sector
 *Mesa
 *Factura
 *itemFactura
 *Comanda
 *ItemComanda
 *cajas
 *arearestaurant
 *
 *
 *Hay que revisar varias cosas:
 *Comanda es un OneToMany pero lo mapeao como un one to one con item comanda, no se por que
 *revisar mesa factura (tiene que ser 1:1) y no sale asi
 *item facutra item comanda (para mi es 1:1 pero vos pusiste otra cosa en el codigo)
 *e item comanda con plato que tambien es 1:1 pero no lo dibuja asi
 *hay algo rarisimo en arearestaurant pero ma;ana lo veo
 
 
 */
		
		
	}

}
