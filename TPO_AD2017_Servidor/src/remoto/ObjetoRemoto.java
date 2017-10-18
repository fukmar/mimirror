package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import interfazRemota.manejoNegocio;

public class ObjetoRemoto extends UnicastRemoteObject implements interfazRemota.manejoNegocio{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5248202885298860470L;

	public ObjetoRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
/*	public List<DTO> funcion() throws RemoteException {
		// TODO Auto-generated method stub
		return manejoNegocio.getInstance().get();
	}
*/
	
	
}
