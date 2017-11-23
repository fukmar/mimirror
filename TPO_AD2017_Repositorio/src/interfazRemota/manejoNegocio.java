package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ComandaDTO;
import dto.FacturaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import exceptions.ComandaException;
import exceptions.FacturaException;
import exceptions.MozoException;
import exceptions.PlatoException;
import exceptions.ReservaException;


public interface manejoNegocio extends Remote 
{

	
	//PLATO
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException;
	//COMANDA
	public void grabarComanda(ComandaDTO comanda) throws RemoteException,ComandaException;
	public List<ComandaDTO> mostrarComandas()throws RemoteException,ComandaException;
	//FACTURA
	public  void grabarFactura(FacturaDTO factura) throws RemoteException,FacturaException;
	//RESERVA
	public void grabarReserva(ReservaDTO reserva) throws RemoteException,ReservaException;
	public List<ReservaDTO> mostrarReservas()throws RemoteException,ReservaException;
	//MOZOS
	public List<MozoDTO> mostrarMozos() throws RemoteException,MozoException; 
	
}
