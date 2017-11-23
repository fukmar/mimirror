package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controlador.Controlador;
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
import interfazRemota.manejoNegocio;

public class ObjetoRemoto extends UnicastRemoteObject implements manejoNegocio
{
	private static final long serialVersionUID = -5248202885298860470L;

	public ObjetoRemoto() throws RemoteException 
	{
		super();
	}

	//----------------------------PLATOS------------------------------------------------------------------------------
	@Override
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException
	{
		return Controlador.getInstance().listarPlatos();
	}

	@Override
	/*public void grabarComanda(ComandaDTO comanda) throws RemoteException, ComandaException 
	{
		Controlador.getInstance().guardarComanda(comanda.getMozo(),comanda.getMesa(),comanda.getEstado());
		
	}*/
	//----------------------------COMANDAS----------------------------------------------------------------------------
	public void grabarComanda(ComandaDTO comanda) throws RemoteException, ComandaException 
	{
		Controlador.getInstance().guardarComanda(comanda);
		
	}

	@Override
	public List<ComandaDTO> mostrarComandas() throws RemoteException, ComandaException 
	{
		
		return Controlador.getInstance().listarComandas();
	}
	
	
	//--------------------------FACTURAS--------------------------------------------------------------------------------
	@Override
	public void grabarFactura(FacturaDTO factura) throws RemoteException, FacturaException 
	{
		Controlador.getInstance().guardarFactura(factura);
		
	}

	//-----------------------------------RESERVA-----------------------------------------------------------------------
	@Override
	public void grabarReserva(ReservaDTO reserva) throws RemoteException, ReservaException
	{
		Controlador.getInstance().guardarReserva(reserva);
		
	}

	@Override
	public List<ReservaDTO> mostrarReservas() throws RemoteException, ReservaException {
		return Controlador.getInstance().listarReservas();
	}
    //---------------------------------MOZOS--------------------------------------------------------------------------------
	@Override
	public List<MozoDTO> mostrarMozos() throws RemoteException, MozoException {
		return Controlador.getInstance().listarMozos();
	}

	
	
}
