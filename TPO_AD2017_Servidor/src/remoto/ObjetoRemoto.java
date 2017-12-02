package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import controlador.Controlador;
import dao.MozoDAO;
import dto.CartaDTO;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
import dto.ItemComandaDTO;
import dto.ItemFacturaDTO;
import dto.ItemPlanProduccionDTO;
import dto.MateriaPrimaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlanDeProduccionDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import dto.UnidadDTO;
import dto.UsuariosDTO;
import enumns.AreaRest;
import enumns.MedioDePago;
import exceptions.CajaException;
import exceptions.CartaException;
import exceptions.ComandaException;
import exceptions.DepositoException;
import exceptions.FacturaException;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.PlanDeProduccionException;
import exceptions.PlatoException;
import exceptions.ReservaException;
import exceptions.SalonException;
import exceptions.SectorException;
import exceptions.UnidadException;
import exceptions.UsuarioException;
import exceptions.itemComandaException;
import exceptions.itemPlanDeProduccionException;
import interfazRemota.manejoNegocio;
import negocio.ItemFactura;
import negocio.Mesa;

public class ObjetoRemoto extends UnicastRemoteObject implements manejoNegocio
{
	private static final long serialVersionUID = -5248202885298860470L;

	public ObjetoRemoto() throws RemoteException 
	{
		super();
	}
	
	//-----------------------------USUARIOS--------------------------------------------------------------------------
		
		@Override
		public boolean verificarPassword(String login, String password) throws RemoteException, UsuarioException 
		{
			return Controlador.getInstance().autenticarPassword(login, password);
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

	@Override
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws RemoteException, PlatoException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarPlatoPorCod(codPlato);
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
	
	//--------------------------ITEM COMANDA--------------------------------------------------------------------------------
	@Override
	public void grabarItemComanda(ItemComandaDTO itemComanda) throws RemoteException, itemComandaException 
	{
		Controlador.getInstance().guardarItemComanda(itemComanda);
		
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

	@Override
	public FacturaDTO mostrarFacturaByCod(int nroFact) throws RemoteException, FacturaException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarFacturaByCod(nroFact);
	}
	
	public List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws RemoteException, FacturaException
	{
		return Controlador.getInstance().obtenerItemsFacturaByCodFactura(codFactura);
		
	}
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws RemoteException, FacturaException
	{
		Controlador.getInstance().facturarMesa(codMesa, formadepago);
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

	@Override
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws RemoteException, MozoException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarComisionesAPagar(FechaDesde, FechaHasta);
	}

	
	
	//----------------------------------MESAS---------------------------------------------------------------------------------
	@Override
	public List<MesaDTO> mostrarMesas() throws RemoteException, MesaException {
		return Controlador.getInstance().listarMesas();
	}

	@Override
	public MesaDTO BuscarMesaPorCod(Integer codMesa) throws RemoteException, MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarMesaPorCod(codMesa);
	}
	
	@Override
	public List<MesaDTO> mostrarMesasLibres() throws RemoteException, MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarMesasLibres();
	}
	
	public void ocuparMesaPorCod(Integer codMesa) throws RemoteException, MesaException {
		// TODO Auto-generated method stub
		Controlador.getInstance().ocuparMesaPorCod(codMesa);
	}
	
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws RemoteException, MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().combinarMesasPorCod(codmesa1, codmesa2);
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
	
	
	@Override
	public DepositoDTO DepositoByCod(Integer codDeposito) throws RemoteException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().DepositoByCod(codDeposito);
	}

	//----------------------------------CAJA---------------------------------------------------------------------------------
	@Override
	public double mostrarTotalFacturadoCaja(Date FechaDesde, Date FechaHasta) throws RemoteException, CajaException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarTotalFacturadoCaja(FechaDesde, FechaHasta);
	}

	//----------------------------------UNIDADES----------------------------------------------------------------------------
	@Override
	public List<UnidadDTO> mostrarUnidades() throws RemoteException, UnidadException
	{
		return Controlador.getInstance().listarUnidades();
		
		
	}

	@Override
	public UnidadDTO UnidadByDescp(String descp) throws RemoteException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().UnidadByDescp(descp);
	}


	//-----------------------------------MATERIA PRIMA-----------------------------------------------------------------------
	@Override
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException {
		Controlador.getInstance().grabarMateriaPrima(materia);
		
	}

	//-----------------------------------ITEMS COMANDA POR AREA y POR COD COMANDA------------

	@Override
	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws RemoteException {

		return Controlador.getInstance().getItemsPendientesxArea(area);
	}

	@Override
	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws RemoteException {
		
		return Controlador.getInstance().obtenerItemsComandaByCodComanda(parseInt);
	}

	
	//--------------------------------CARTA-------------------------------------------------
	@Override
	public CartaDTO buscarCartaPorCod(int nrocarta) throws RemoteException, CartaException 
	{
		
		return Controlador.getInstance().listarCartaPorCod(nrocarta);
	}

	@Override
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta) throws RemoteException, CartaException 
	{
		return Controlador.getInstance().listarPlatosporCodCarta(nrocarta);
	}

	@Override
	public List<CartaDTO> mostrarCartas() throws RemoteException, CartaException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarCartas();
	}

	//--------------------------------PLAN DE PRODUCCION------------------------------------------------
	@Override
	public List<PlanDeProduccionDTO> mostrarPDPs() throws RemoteException, PlanDeProduccionException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarPlanesProduccion();
	}

	@Override
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)
			throws RemoteException, itemPlanDeProduccionException {
		// TODO Auto-generated method stub listarItemPlanPorCodPlan
		return Controlador.getInstance().listarItemPlanPorCodPlan(nroPlanDeProduccion);
	}

	@Override
	public void guardarUsuarios(UsuariosDTO usuario) throws RemoteException, UsuarioException 
	{
		Controlador.getInstance().grabarUsuarios(usuario);
		
	}

	

	

	

	
	


	

	

	
	
	
}
