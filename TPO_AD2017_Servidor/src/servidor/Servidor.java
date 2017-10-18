package servidor;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import interfazRemota.manejoNegocio;
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
		Naming.rebind("//localhost/Controlador", remoteObject);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
	
		}
	
		System.out.print("OK"); 		
}


/*
 	public List<DTO> funcion() throws RemoteException {
		// TODO Auto-generated method stub
		return manejoNegocio.getInstance().getUnidades();
	}
 
 */
}