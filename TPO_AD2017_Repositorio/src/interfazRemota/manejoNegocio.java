package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ComandaDTO;
import dto.FacturaDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import exceptions.ComandaException;
import exceptions.FacturaException;
import exceptions.PlatoException;
import exceptions.ReservaException;


public interface manejoNegocio extends Remote 
{

	//public List<DTO> funcion() throws RemoteException; 
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException;
	public void grabarComanda(ComandaDTO comanda) throws RemoteException,ComandaException;
	public List<ComandaDTO> mostrarComandas()throws RemoteException,ComandaException;
	public  void grabarFactura(FacturaDTO factura) throws RemoteException,FacturaException;
	public void grabarReserva(ReservaDTO reserva) throws RemoteException,ReservaException;
	public List<ReservaDTO> mostrarReservas()throws RemoteException,ReservaException;

	
}
