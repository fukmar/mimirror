package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controlador.Controlador;
import dto.PlatoDTO;
import exceptions.PlatoException;
import interfazRemota.manejoNegocio;

public class ObjetoRemoto extends UnicastRemoteObject implements manejoNegocio{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5248202885298860470L;

	public ObjetoRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException
	{
		return Controlador.getInstance().listarPlatos();
	}
	
	
/*	public List<DTO> funcion() throws RemoteException {
		// TODO Auto-generated method stub
		return manejoNegocio.getInstance().get();
	}
*/
	
	
}
