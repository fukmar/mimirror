package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ComandaDTO;
import dto.PlatoDTO;
import exceptions.ComandaException;
import exceptions.PlatoException;


public interface manejoNegocio extends Remote 
{

	//public List<DTO> funcion() throws RemoteException; 
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException;
	public void grabarComanda(ComandaDTO comanda) throws RemoteException,ComandaException;
	
}
