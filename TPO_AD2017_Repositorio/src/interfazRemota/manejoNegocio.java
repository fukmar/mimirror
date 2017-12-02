package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.CartaDTO;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
import dto.ItemComandaDTO;
import dto.ItemFacturaDTO;
import dto.MateriaPrimaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import dto.UnidadDTO;
import enumns.AreaRest;
import enumns.MedioDePago;
import exceptions.CajaException;
import exceptions.CartaException;
import exceptions.ComandaException;
import exceptions.DepositoException;
import exceptions.FacturaException;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.PlatoException;
import exceptions.ReservaException;
import exceptions.SalonException;
import exceptions.SectorException;
import exceptions.UnidadException;
import exceptions.UsuarioException;
import exceptions.itemComandaException;





public interface manejoNegocio extends Remote 
{

	//USUARIO
	public boolean verificarPassword(String login, String password) throws RemoteException,UsuarioException;
	
	//PLATO
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException;
	public List<PlatoDTO> BuscarPlatosparecidos(String nombre, String categoriaplato) throws RemoteException, PlatoException;
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws RemoteException, PlatoException;
	
	//COMANDA
	public void grabarComanda(ComandaDTO comanda) throws RemoteException,ComandaException;
	public List<ComandaDTO> mostrarComandas()throws RemoteException,ComandaException;
	public ComandaDTO BuscarComandasPorCod(Integer codComanda)throws RemoteException,ComandaException;
	 
	//ITEMCOMANDA
	public void grabarItemComanda(ItemComandaDTO itemComanda) throws RemoteException,itemComandaException;
	
	//FACTURA
	public  void grabarFactura(FacturaDTO factura) throws RemoteException,FacturaException;
	public List<FacturaDTO> mostrarFacturas()throws RemoteException,FacturaException;
	public FacturaDTO mostrarFacturaByCod(int nroFact)throws RemoteException,FacturaException;
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws RemoteException, FacturaException;
	//ITEMFACTURA
	List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws RemoteException, FacturaException;
	
	//RESERVA
	public void grabarReserva(ReservaDTO reserva) throws RemoteException,ReservaException;
	public List<ReservaDTO> mostrarReservas()throws RemoteException,ReservaException;
	
	//MOZOS
	public List<MozoDTO> mostrarMozos() throws RemoteException,MozoException; 
	
	//MESAS 
	public List<MesaDTO> mostrarMesas() throws RemoteException,MesaException;
	public MesaDTO BuscarMesaPorCod(Integer codMesa)throws RemoteException,MesaException;
	public List<MesaDTO> mostrarMesasLibres()throws RemoteException,MesaException;
	public void ocuparMesaPorCod(Integer codMesa)throws RemoteException,MesaException;
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws RemoteException, MesaException;
	
	//SECTORES
	public List<SectorDTO> mostrarSectores() throws RemoteException,SectorException;
	
	//SALONES
	public List<SalonDTO> mostrarSalones() throws RemoteException,SalonException;
	
	//DEPOSITOS
	public List<DepositoDTO> mostrarDepositos() throws RemoteException,DepositoException;
	public DepositoDTO DepositoByCod(Integer codDeposito) throws RemoteException;
	
	
	//FACTURACION CAJA
	public double mostrarTotalFacturadoCaja (Date FechaDesde,Date FechaHasta)throws RemoteException,CajaException;
	

	//UNIDAD
	public List<UnidadDTO> mostrarUnidades() throws RemoteException, UnidadException;
	public UnidadDTO UnidadByDescp(String descp) throws RemoteException;

	//MATERIA PRIMA
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException;

	//ITEMS COMANDA
	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws RemoteException;

	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws RemoteException;
	
	//CARTA
	public CartaDTO buscarCartaPorCod(int nrocarta) throws RemoteException,CartaException;
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta)throws RemoteException,CartaException;
	public List<CartaDTO> mostrarCartas()throws RemoteException,CartaException;
}
