package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.PlatoDTO;
import exceptions.PlatoException;

public interface manejoNegocio extends Remote 
{

	//public List<DTO> funcion() throws RemoteException; 
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException;
	
}
