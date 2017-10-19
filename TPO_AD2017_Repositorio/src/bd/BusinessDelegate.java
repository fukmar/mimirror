package bd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dto.*;
import interfazRemota.manejoNegocio;;

public class BusinessDelegate {

	private static BusinessDelegate instance;
	private manejoNegocio remoteObject;
	
	public static BusinessDelegate getInstance() {
		if(instance == null) {
			instance = new BusinessDelegate();
		}
		return instance;
	}
	
	private BusinessDelegate() {
			try {
				this.remoteObject = (manejoNegocio) Naming.lookup("//localhost/manejoNegocio");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	

/*	
	public void insertarRubro(RubroDto rubro) throws RemoteException {
		this.remoteObject.insertarRubro(rubro);		
	}*/
	
	
}
