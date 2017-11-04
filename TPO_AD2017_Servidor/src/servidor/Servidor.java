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

public class Servidor extends UnicastRemoteObject implements Serializable, interfazRemota.manejoNegocio{

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
		PlanDeProduccionEntity test = new PlanDeProduccionEntity(1,est.EnProceso);
		SessionFactory sf = hbt.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(test);
		session.getTransaction().commit();
		session.close();
		*/
		/*
		UnidadEntity test = new UnidadEntity(1,"unidad uno");
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
		Integer i = new Integer("1345");
	
		
		MateriaPrimaEntity mpe = new MateriaPrimaEntity(1,"desc",ue);
	
		List<MateriaPrimaEntity> materiales = new ArrayList<MateriaPrimaEntity>();
		materiales.add(mpe);
		SemiElaboradoEntity see = new SemiElaboradoEntity(1,"tipo","calidad","desc",pdpe,i,fecha,materiales,ue);
		
		List<SemiElaboradoEntity> componentes = new ArrayList<SemiElaboradoEntity>();
		componentes.add(see);
		
		ElaboradoEntity test = new ElaboradoEntity(i,"tipo","calidad","pizza",pdpe,i,fecha, ue, componentes);
		
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