package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import exceptions.CajaException;
import exceptions.ComandaException;
import exceptions.DepositoException;
import exceptions.FacturaException;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.PlatoException;
import exceptions.ReservaException;
import exceptions.SalonException;
import exceptions.SectorException;



public interface manejoNegocio extends Remote 
{

	
	//PLATO
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException;
	public List<PlatoDTO> BuscarPlatosparecidos(String nombre, String categoriaplato) throws RemoteException, PlatoException;
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws RemoteException, PlatoException;
	
	//COMANDA
	public void grabarComanda(ComandaDTO comanda) throws RemoteException,ComandaException;
	public List<ComandaDTO> mostrarComandas()throws RemoteException,ComandaException;
	public ComandaDTO BuscarComandasPorCod(Integer codComanda)throws RemoteException,ComandaException;
	
	//FACTURA
	public  void grabarFactura(FacturaDTO factura) throws RemoteException,FacturaException;
	public List<FacturaDTO> mostrarFacturas()throws RemoteException,FacturaException;
	
	//RESERVA
	public void grabarReserva(ReservaDTO reserva) throws RemoteException,ReservaException;
	public List<ReservaDTO> mostrarReservas()throws RemoteException,ReservaException;
	
	//MOZOS
	public List<MozoDTO> mostrarMozos() throws RemoteException,MozoException; 
	
	//MESAS
	public List<MesaDTO> mostrarMesas() throws RemoteException,MesaException;
	public MesaDTO BuscarMesaPorCod(Integer codMesa)throws RemoteException,MesaException;
	
	//SECTORES
	public List<SectorDTO> mostrarSectores() throws RemoteException,SectorException;
	
	//SALONES
	public List<SalonDTO> mostrarSalones() throws RemoteException,SalonException;
	
	//DEPOSITOS
	public List<DepositoDTO> mostrarDepositos() throws RemoteException,DepositoException;
	
	//FACTURACION CAJA
	public double mostrarTotalFacturadoCaja (Date FechaDesde,Date FechaHasta)throws RemoteException,CajaException;
	
}
