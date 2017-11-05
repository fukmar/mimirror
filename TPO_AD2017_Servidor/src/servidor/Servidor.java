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

	public void main (String args[])
	{
		new Servidor();
	}
	
	public Servidor()
	{
		try {
			LocateRegistry.createRegistry(1099);
			manejoNegocio objetoRemoto=new ObjetoRemoto();
			Naming.rebind("//localhost/ObjetoRemoto",objetoRemoto);
			System.out.println("Fijado en //localhost/ObjetoRemoto ");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		


}