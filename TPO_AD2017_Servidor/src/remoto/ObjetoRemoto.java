package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controlador.Controlador;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import exceptions.ComandaException;
import exceptions.DepositoException;
import exceptions.FacturaException;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.PlatoException;
import exceptions.ReservaException;
import exceptions.SalonException;
import exceptions.SectorException;
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
	public List<PlatoDTO> BuscarPlatosparecidos(String nombre, String categoriaplato)
			throws RemoteException, PlatoException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().BuscarPlatosparecidos(nombre, categoriaplato);
	}

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
	
	@Override
	public ComandaDTO BuscarComandasPorCod(Integer codComanda) throws RemoteException, ComandaException
	{
		return Controlador.getInstance().listarComandasPorCod(codComanda);
	}
	
	//--------------------------FACTURAS--------------------------------------------------------------------------------
	@Override
	public void grabarFactura(FacturaDTO factura) throws RemoteException, FacturaException 
	{
		Controlador.getInstance().guardarFactura(factura);
		
	}

	@Override
	public List<FacturaDTO> mostrarFacturas() throws RemoteException, FacturaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarFacturas();
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

	//----------------------------------MESAS---------------------------------------------------------------------------------
	@Override
	public List<MesaDTO> mostrarMesas() throws RemoteException, MesaException {
		return Controlador.getInstance().listarMesas();
	}

	//----------------------------------SECTORES---------------------------------------------------------------------------------
	@Override
	public List<SectorDTO> mostrarSectores() throws RemoteException, SectorException 
	{

		return Controlador.getInstance().listarSectores();
	}

	//----------------------------------SALONES---------------------------------------------------------------------------------
	@Override
	public List<SalonDTO> mostrarSalones() throws RemoteException, SalonException {
		return Controlador.getInstance().listarSalones();
	}

	//----------------------------------DEPOSITOS---------------------------------------------------------------------------------
	@Override
	public List<DepositoDTO> mostrarDepositos() throws RemoteException, DepositoException
	{
		return Controlador.getInstance().listarDepositos();
	}

	

	

	
	
	
}
