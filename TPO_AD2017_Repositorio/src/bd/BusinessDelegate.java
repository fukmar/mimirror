package bd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.*;
import exceptions.ComandaException;
import exceptions.PlatoException;
import interfazRemota.manejoNegocio;


public class BusinessDelegate
{

	private static BusinessDelegate instance;
	private manejoNegocio remoteObject;
	
	public BusinessDelegate() throws RemoteException {
		super();
		try {
			remoteObject=(manejoNegocio) Naming.lookup("//localhost/ObjetoRemoto");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BusinessDelegate getInstance() throws RemoteException {
		if(instance == null) {
			instance = new BusinessDelegate();
		}
		return instance;
	}
	
	

/*	
	public void insertarRubro(RubroDto rubro) throws RemoteException {
		this.remoteObject.insertarRubro(rubro);		
	}*/
	
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException
	{
		try {
			return remoteObject.listarPlatos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PlatoException("Error! no hay plato");
		}
	}
	
	
	public void grabarComanda(ComandaDTO comanda) throws RemoteException, ComandaException 
	{
		try {
			remoteObject.grabarComanda(comanda);
		} catch (Exception e) {
			throw new ComandaException("Error no hay comanda!");
		}
	}
	
}
