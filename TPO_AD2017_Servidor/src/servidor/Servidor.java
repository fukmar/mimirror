package servidor;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.*;
import enumns.Estado;
import hibernate.hbt;
import interfazRemota.manejoNegocio;
import negocio.PlanDeProduccion;
import remoto.ObjetoRemoto;

public class Servidor {

	protected Servidor() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) throws MalformedURLException {
	 ObjetoRemoto remoteObject;
	try {
		remoteObject = new ObjetoRemoto();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("//localhost/manejoNegocio", remoteObject);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
	
		}
	
		System.out.print("OK");
		
		//aca van pruebas de DB
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

		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
		
		//aca terminan pruebas de DB
		
		
		
}

	

/*
 	public List<DTO> funcion() throws RemoteException {
		// TODO Auto-generated method stub
		return manejoNegocio.getInstance().getUnidades();
	}
 
 */
}