package bd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import dto.*;
import enumns.AreaRest;
import enumns.CategoriaPlato;
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
import exceptions.RemitoException;
import exceptions.ReservaException;
import exceptions.SalonException;
import exceptions.SectorException;
import exceptions.UnidadException;
import exceptions.UsuarioException;
import exceptions.itemComandaException;
import exceptions.itemPlanDeProduccionException;
import interfazRemota.manejoNegocio;


public class BusinessDelegate
{

	private static BusinessDelegate instance;
	private manejoNegocio remoteObject;
	
	public BusinessDelegate() throws RemoteException {
		super();
		try {
			remoteObject=(manejoNegocio) Naming.lookup("//localhost/ObjetoRemoto");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BusinessDelegate getInstance() throws RemoteException {
		if(instance == null) {
			instance = new BusinessDelegate();
		}
		return instance;
	}
	
	

/*	
	public void insertarRubro(RubroDto rubro) throws RemoteException {
		this.remoteObject.insertarRubro(rubro);		
	}*/
	
	
	//---------------------------------------USUARIOS------------------------------------------------------------
	public boolean verificarPassword(String login, String password) throws RemoteException, UsuarioException
	{
		try {
			return remoteObject.verificarPassword(login, password);
		} catch (UsuarioException e) {
			throw new UsuarioException("USUARIO o PASSWORD incorrecta!");
		}
	}
	
	public void guardarUsuarios(UsuariosDTO usuario) throws RemoteException, UsuarioException 
	{
		remoteObject.guardarUsuarios(usuario);
	}
	
	
	public UsuariosDTO buscarUserPorLogin(String login) throws RemoteException, UsuarioException
	{
		return remoteObject.buscarUserPorLogin(login);
	}
	
	public void borrarUsuario(UsuariosDTO usuario) throws RemoteException, UsuarioException
	{
		remoteObject.borrarUsuario(usuario);
	}
	//---------------------------------------PLATOS------------------------------------------------------------
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException
	{
		try {
			return remoteObject.listarPlatos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PlatoException("Error! no hay plato");
		}
	}
	
	public List<PlatoDTO> BuscarPlatosparecidos(String nombre, CategoriaPlato categoriaplato) throws RemoteException, PlatoException 
	{
		try {
			return remoteObject.buscarPlatosParecidos(nombre, categoriaplato);
		} catch (RemoteException e) {
			throw new PlatoException("No se encontraron PLATOS similares!");
		}
	}
	
	
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws RemoteException, PlatoException 
	{
		try {
			return remoteObject.BuscarPlatoPorCod(codPlato);
		} catch (RemoteException e) {
			throw new PlatoException("No se encontro el PLATO por CODIGO!");
		}
	}

	//---------------------------------------COMANDAS------------------------------------------------------------
	public void grabarComanda(ComandaDTO comanda) throws RemoteException, ComandaException 
	{
		try {
			remoteObject.grabarComanda(comanda);
		} catch (Exception e) {
			throw new ComandaException("No se pudo grabar la comanda!");
		}
	}
	
	public List<ComandaDTO> mostrarComandas() throws RemoteException, ComandaException 
	{
		try {
			return remoteObject.mostrarComandas();
		} catch (Exception e) {
			throw new ComandaException("No se pudo LISTAR las comandas!");
		}
	}
	
	public ComandaDTO BuscarComandasPorCod(Integer codComanda) throws RemoteException, ComandaException
	{
		try {
			return remoteObject.BuscarComandasPorCod(codComanda);
		} catch (Exception e) {
			throw new ComandaException("No se pudo encontrar la COMANDA por codigo!");
		}
	}
	
	
	//---------------------------------------ITEM COMANDA------------------------------------------------------------
	
	public void grabarItemComanda(ItemComandaDTO itemComanda) throws RemoteException, itemComandaException 
	{
		remoteObject.grabarItemComanda(itemComanda);
	}
	public void itemComandaLista(int coditemcomanda) throws RemoteException, itemComandaException 
	{
		remoteObject.itemComandaLista(coditemcomanda);
	}
	
	//---------------------------------------FACTURAS------------------------------------------------------------
	public void grabarFactura(FacturaDTO factura) throws RemoteException, FacturaException 
	{
		try {
			remoteObject.grabarFactura(factura);
		} catch (Exception e) {
			throw new FacturaException("No se pudo grabar la FACTURA!");
		}
	}
	
	public List<FacturaDTO> mostrarFacturas() throws RemoteException, FacturaException 
	{
		return remoteObject.mostrarFacturas();
	}
	
	
	public FacturaDTO mostrarFacturaByCod(int nroFact) throws RemoteException, FacturaException 
	{
		return remoteObject.mostrarFacturaByCod(nroFact);
	}
	
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws RemoteException, FacturaException
	{
		try {
			remoteObject.facturarMesa(codMesa, formadepago);;
		} catch (Exception e) {
			throw new FacturaException("No se pudo generar la FACTURA!");
		}
	}
	
	// ---------------------------------------ITEM FACTURA------------------------------------------------------
	
	public List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws RemoteException, FacturaException
	{
		return remoteObject.obtenerItemsFacturaByCodFactura(codFactura);
	}
	
	//---------------------------------------RESERVAS------------------------------------------------------------
	
	public void grabarReserva(ReservaDTO reserva) throws RemoteException, ReservaException 
	{
		try {
			remoteObject.grabarReserva(reserva);
		} catch (Exception e) {
			throw new ReservaException("No se pudo GRABAR la RESERVA");
		}
	}
	
	public List<ReservaDTO> mostrarReservas()throws RemoteException,ReservaException
	{
		try {
			return remoteObject.mostrarReservas();
		} catch (Exception e) {
			throw new ReservaException("No se pudo LISTAR las RESERVAS");
		}
	}
	
	//-----------------------------------MOZOS----------------------------------------------------------------------
	public List<MozoDTO> mostrarMozos() throws RemoteException,MozoException
	{
		return remoteObject.mostrarMozos();
	}
	
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws RemoteException, MozoException
	{
		return remoteObject.mostrarComisionesAPagar(FechaDesde, FechaHasta);
	}
	
	public List<String[]> mostrarResultadoComisionesMozo(Date FechaDesde,Date FechaHasta) throws RemoteException, MozoException
	{
		return remoteObject.mostrarResultadoComisionesMozo(FechaDesde,FechaHasta);
	}
	
	//-----------------------------------MESAS-------------------------------------------------------------------------
	public List<MesaDTO> mostrarMesas() throws RemoteException,MesaException
	{
		return remoteObject.mostrarMesas();
	}
	
	public MesaDTO BuscarMesaPorCod(Integer codMesa) throws RemoteException, MesaException 
	{
		return remoteObject.BuscarMesaPorCod(codMesa);
	}
	
	public List<MesaDTO> mostrarMesasLibres() throws RemoteException, MesaException
	{
		return remoteObject.mostrarMesasLibres();
	}
	public void ocuparMesaPorCod(Integer codMesa) throws RemoteException, MesaException
	{		
		try {
				remoteObject.ocuparMesaPorCod(codMesa);
		} catch (Exception e) {
		throw new MesaException("No se pudo Cambiar el Estado");
	}
	}
		
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws RemoteException, MesaException
		{		
			return remoteObject.combinarMesasPorCod(codmesa1, codmesa2);
		}
		
	public void grabarMesa(MesaDTO mesa) throws RemoteException, MesaException 
	{
		remoteObject.grabarMesa(mesa);
	}
	
	
	//-----------------------------------SECTORES-------------------------------------------------------------------------
	public List<SectorDTO> mostrarSectores() throws RemoteException, SectorException
	{
		return remoteObject.mostrarSectores();
	}
	
	//-----------------------------------SALONES-------------------------------------------------------------------------
	public List<SalonDTO> mostrarSalones() throws RemoteException, SalonException 
	{
		return remoteObject.mostrarSalones();
	}
	
	//-----------------------------------DEPOSITOS-------------------------------------------------------------------------
	public List<DepositoDTO> mostrarDepositos() throws RemoteException, DepositoException
	{
		return remoteObject.mostrarDepositos();
	}
	
	
	//-----------------------------------DEPOSITOS-------------------------------------------------------------------------
	public double mostrarTotalFacturadoCaja(Date FechaDesde, Date FechaHasta) throws RemoteException, CajaException 
	{
		return remoteObject.mostrarTotalFacturadoCaja(FechaDesde, FechaHasta);
	}
	
	
	//-----------------------------------UNIDADES---------------------------------------------------------------------------
	public List<UnidadDTO> mostrarUnidades() throws RemoteException, UnidadException {
		return remoteObject.mostrarUnidades();
		
	}
	
	public UnidadDTO UnidadByDescp(String descp) throws RemoteException {
		return remoteObject.UnidadByDescp(descp);
	}
	
	
	//-----------------------------------MATERIA PRIMA(MATERIALES)------------------------------------------------------------------
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException{
		remoteObject.grabarMateriaPrima(materia);
	}
	
	public List<MateriaPrimaDTO> listarStock() throws RemoteException
	{
		return remoteObject.listarStock();
	}

	//-----------------------------------ITEMS COMANDA-----------------------------------------------------------------------------

	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws RemoteException{
		return remoteObject.getItemsPendientesxArea(area);
	}

	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws RemoteException{
		return remoteObject.obtenerItemsComandaByCodComanda(parseInt);
	}
	
	//-----------------------------------CARTA-----------------------------------------------------------------------------
	public CartaDTO buscarCartaPorCod(int nrocarta) throws RemoteException, CartaException
	{
		return remoteObject.buscarCartaPorCod(nrocarta);
	}
	
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta) throws RemoteException, CartaException 
	{
		return remoteObject.obtenerPlatosByCodCarta(nrocarta);
	}
	
	public List<CartaDTO> mostrarCartas() throws RemoteException, CartaException 
	{
		return remoteObject.mostrarCartas();
	}
	
	//-----------------------------------PLAN DE PRODUCCION-----------------------------------------------------------------------------
	public List<PlanDeProduccionDTO> mostrarPDPs() throws RemoteException, PlanDeProduccionException 
	{
		return remoteObject.mostrarPDPs();
	}
	
	public PlanDeProduccionDTO obtenerPDPByCodPDP(int codPdp) throws RemoteException, PlanDeProduccionException
	{
		return remoteObject.obtenerPDPByCodPDP(codPdp);
	}
	
	//-----------------------------------ITEM PLAN DE PRODUCCION-----------------------------------------------------------------------------
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)throws RemoteException,itemPlanDeProduccionException
	{
		return remoteObject.obtenerItemPDPByCodPDP(nroPlanDeProduccion);
	}
	
	//REMITO
	public void grabarRemito(RemitoDTO remito) throws RemoteException, RemitoException 
	{
		remoteObject.grabarRemito(remito);
	}
	
	public List<RemitoDTO> mostrarRemitos() throws RemoteException, RemitoException 
	{
		return remoteObject.mostrarRemitos();
	}
}
