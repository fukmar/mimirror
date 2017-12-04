package bd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
import exceptions.MateriaPrimaException;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.PlanDeProduccionException;
import exceptions.PlatoException;
import exceptions.RemitoException;
import exceptions.ReservaException;
import exceptions.SalonException;
import exceptions.SectorException;
import exceptions.SemiElaboradoException;
import exceptions.SolicitudException;
import exceptions.UnidadException;
import exceptions.UsuarioException;
import exceptions.itemComandaException;
import exceptions.itemPlanDeProduccionException;
import exceptions.itemRemitoException;
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
		try {
			remoteObject.guardarUsuarios(usuario);
		} catch (UsuarioException e) {
			throw new UsuarioException("No se puede grabar el usuario!");
		}
	}
	
	
	public UsuariosDTO buscarUserPorLogin(String login) throws RemoteException, UsuarioException
	{
		try {
			return remoteObject.buscarUserPorLogin(login);
		} catch (UsuarioException e) {
			throw new UsuarioException("No se ENCUENTRA el usuario");
		}
	}
	
	public void borrarUsuario(UsuariosDTO usuario) throws RemoteException, UsuarioException
	{
		try {
			remoteObject.borrarUsuario(usuario);
		} catch (UsuarioException e) {
			throw new UsuarioException("No se pudo BORRAR el usuario");
		}
	}
	//---------------------------------------PLATOS------------------------------------------------------------
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException
	{
		try {
			return remoteObject.listarPlatos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PlatoException("Error! no hay platos");
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
	
	public boolean grabarItemComanda(ItemComandaDTO itemComanda) throws RemoteException, itemComandaException 
	{
		try {
			return remoteObject.grabarItemComanda(itemComanda);
		} catch (itemComandaException e) {
			throw new itemComandaException("NO se pudo GRABAR el ITEMCOMANDA!");
		}
	}
	
	
	public void itemComandaLista(int coditemcomanda) throws RemoteException, itemComandaException 
	{
		try {
			remoteObject.itemComandaLista(coditemcomanda);
		} catch (itemComandaException e) {
			throw new itemComandaException("El ITEM DE LA COMANDA NO PUDO REALIZARSE!");
		}
	}
	
	//---------------------------------------FACTURAS------------------------------------------------------------
	public void grabarFactura(FacturaDTO factura) throws RemoteException, FacturaException 
	{
		try {
			remoteObject.grabarFactura(factura);
		} catch (FacturaException e) {
			throw new FacturaException("No se pudo grabar la FACTURA!");
		}
	}
	
	public List<FacturaDTO> mostrarFacturas() throws RemoteException, FacturaException 
	{
		try {
			return remoteObject.mostrarFacturas();
		} catch (FacturaException e) {
			throw new FacturaException("No se pueden MOSTRAR las FACTURAS!");
		}
	}
	
	
	public FacturaDTO mostrarFacturaByCod(int nroFact) throws RemoteException, FacturaException 
	{
		try {
			return remoteObject.mostrarFacturaByCod(nroFact);
		} catch (FacturaException e) {
			throw new FacturaException("No se ENCONTRO la FACTURA!");
		}
	}
	
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws RemoteException, FacturaException
	{
		try {
			remoteObject.facturarMesa(codMesa, formadepago);
		} catch (FacturaException e) {
			throw new FacturaException("No se pudo generar la FACTURA!");
		}
	}
	
	// ---------------------------------------ITEM FACTURA------------------------------------------------------
	
	public List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws RemoteException, FacturaException
	{
		try {
			return remoteObject.obtenerItemsFacturaByCodFactura(codFactura);
		} catch (FacturaException e) {
			throw new FacturaException("No se encontraron los items de la FACTURA!");
		}
	}
	
	//---------------------------------------RESERVAS------------------------------------------------------------
	
	public void grabarReserva(ReservaDTO reserva) throws RemoteException, ReservaException 
	{
		try {
			remoteObject.grabarReserva(reserva);
		} catch (ReservaException e) {
			throw new ReservaException("No se pudo GRABAR la RESERVA");
		}
	}
	
	public List<ReservaDTO> mostrarReservas()throws RemoteException,ReservaException
	{
		try {
			return remoteObject.mostrarReservas();
		} catch (ReservaException e) {
			throw new ReservaException("No se pudieron LISTAR las RESERVAS");
		}
	}
	
	//-----------------------------------MOZOS----------------------------------------------------------------------
	public List<MozoDTO> mostrarMozos() throws RemoteException,MozoException
	{
		try {
			return remoteObject.mostrarMozos();
		} catch (MozoException e) {
			throw new MozoException("No se pueden MOSTRAR los MOZOS!");
		}
	}
	
	
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws RemoteException, MozoException
	{
		try {
			return remoteObject.mostrarComisionesAPagar(FechaDesde, FechaHasta);
		} catch (MozoException e) {
			throw new MozoException("No se pueden CALCULAR las comisiones de los MOZOS!");
		}
	}
	
	
	public List<String[]> mostrarResultadoComisionesMozo(Date FechaDesde,Date FechaHasta) throws RemoteException, MozoException
	{
		try {
			return remoteObject.mostrarResultadoComisionesMozo(FechaDesde,FechaHasta);
		} catch (MozoException e) {
			throw new MozoException("No se pueden MOSTRAR el resultado de las COMISIONES de los MOZOS!");
		}
	}
	
	//-----------------------------------MESAS-------------------------------------------------------------------------
	public List<MesaDTO> mostrarMesas() throws RemoteException,MesaException
	{
		try {
			return remoteObject.mostrarMesas();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS!");
		}
	}
	public List<MesaDTO> mostrarFacturables() throws RemoteException,MesaException
	{
		try {
			return remoteObject.mostrarMesasFacturables();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS FACTURABLES!");
		}
	}
	public List<MesaDTO> mostrarMesasOcupadas() throws RemoteException,MesaException
	{
		try {
			return remoteObject.mostrarMesasOcupadas();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS OCUPADAS!");
		}
	}
	
	public MesaDTO BuscarMesaPorCod(Integer codMesa) throws RemoteException, MesaException 
	{
		try {
			return remoteObject.BuscarMesaPorCod(codMesa);
		} catch (MesaException e) {
			throw new MesaException("No se pueden ENCONTRO la MESA buscada!");
		}
	}
	
	public List<MesaDTO> mostrarMesasLibres() throws RemoteException, MesaException
	{
		try {
			return remoteObject.mostrarMesasLibres();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS LIBRES!");
		}
	}
	
	
	public void ocuparMesaPorCod(Integer codMesa) throws RemoteException, MesaException
	{		
		try {
				remoteObject.ocuparMesaPorCod(codMesa);
		} catch (MesaException e) {
		throw new MesaException("No se pudo Cambiar el Estado");
	}
	}
		
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws RemoteException, MesaException
		{		
			try {
				return remoteObject.combinarMesasPorCod(codmesa1, codmesa2);
			} catch (MesaException e) {
				throw new MesaException("No se pueden COMBINAR esas MESAS!");
			}
		}
		
	public void grabarMesa(MesaDTO mesa) throws RemoteException, MesaException 
	{
		try {
			remoteObject.grabarMesa(mesa);
		} catch (MesaException e) {
			throw new MesaException("No se puede GRABAR la MESA!");
		}
	}
	
	
	//-----------------------------------SECTORES-------------------------------------------------------------------------
	public List<SectorDTO> mostrarSectores() throws RemoteException, SectorException
	{
		try {
			return remoteObject.mostrarSectores();
		} catch (SectorException e) {
			throw new SectorException("No se pueden MOSTRAR los SECTORES!");
		}
	}
	
	//-----------------------------------SALONES-------------------------------------------------------------------------
	public List<SalonDTO> mostrarSalones() throws RemoteException, SalonException 
	{
		try {
			return remoteObject.mostrarSalones();
		} catch (SalonException e) {
			throw new SalonException("No se pueden MOSTRAR los SALONES!");
		}
	}
	
	//-----------------------------------DEPOSITOS-------------------------------------------------------------------------
	public List<DepositoDTO> mostrarDepositos() throws RemoteException, DepositoException
	{
		try {
			return remoteObject.mostrarDepositos();
		} catch (DepositoException e) {
			throw new DepositoException("No se pueden MOSTRAR los DEPOSITOS!");
		}
	}
	
	
	//-----------------------------------FACTURADO CAJA-------------------------------------------------------------------------
	public double mostrarTotalFacturadoCaja(Date FechaDesde, Date FechaHasta) throws RemoteException, CajaException 
	{
		try {
			return remoteObject.mostrarTotalFacturadoCaja(FechaDesde, FechaHasta);
		} catch (CajaException e) {
			throw new CajaException("No se pueden MOSTRAR lo FACTURADO EN CAJA");
		}
	}
	
	
	//-----------------------------------UNIDADES---------------------------------------------------------------------------
	public List<UnidadDTO> mostrarUnidades() throws RemoteException, UnidadException {
		try {
			return remoteObject.mostrarUnidades();
		} catch (UnidadException e) {
			throw new UnidadException("No se pueden MOSTRAR las UNIDADES!");
		}
		
	}
	
	public UnidadDTO UnidadByDescp(String descp) throws RemoteException,UnidadException {
		try {
			return remoteObject.UnidadByDescp(descp);
		} catch (UnidadException e) {
			throw new UnidadException("No se pueden MOSTRAR las UNIDADES por descripcion!");
		}
	}
	
	
	//-----------------------------------MATERIA PRIMA(MATERIALES)------------------------------------------------------------------
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException, MateriaPrimaException
	{
		try {
			remoteObject.grabarMateriaPrima(materia);
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se puede GRABAR la MATERIA PRIMA!");
		}
	}
	
	public List<MateriaPrimaDTO> listarStock() throws RemoteException, MateriaPrimaException
	{
		try {
			return remoteObject.listarStock();
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se pueden LISTAR  las MATERIAS PRIMA!");
		}
	}
	
	public MateriaPrimaDTO getMateriaPrimaByCod(Integer codMaterial) throws RemoteException, MateriaPrimaException
	{
		try {
			return remoteObject.getMateriaPrimaByCod(codMaterial);
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se pueden MOSTRAR Las MATERIAS PRIMAS!");
		}
	}

	public void actualizarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException, MateriaPrimaException {
		// TODO Auto-generated method stub
		remoteObject.actualizarMaterial(materia);
		
	}
	
	public void eliminarMateria(MateriaPrimaDTO materia)  throws RemoteException, MateriaPrimaException{
		// TODO Auto-generated method stub
		remoteObject.eliminarMateria(materia);
	}

	//-----------------------------------ITEMS COMANDA-----------------------------------------------------------------------------

	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws RemoteException,itemComandaException
	{
		return remoteObject.getItemsPendientesxArea(area);
	}

	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws RemoteException,itemComandaException
	{
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
	
	public void grabarPdP(PlanDeProduccionDTO pdp) throws RemoteException, PlanDeProduccionException {
		remoteObject.grabarPdP(pdp);
		
	}
	
	//-----------------------------------ITEM PLAN DE PRODUCCION-----------------------------------------------------------------------------
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)throws RemoteException,itemPlanDeProduccionException
	{
		return remoteObject.obtenerItemPDPByCodPDP(nroPlanDeProduccion);
	}
	
	public void grabarItemPdP(ItemPlanProduccionDTO itemPdP) throws RemoteException,itemPlanDeProduccionException{
	remoteObject.grabarItemPdP(itemPdP);
		
	}
	
	//-----------------------------------REMITO-------------------------------------------------------------------------
	//REMITO
	public void grabarRemito(RemitoDTO remito) throws RemoteException, RemitoException 
	{
		remoteObject.grabarRemito(remito);
	}
	
	public List<RemitoDTO> mostrarRemitos() throws RemoteException, RemitoException 
	{
		return remoteObject.mostrarRemitos();
	}
	
	public RemitoDTO getRemitoByCod(Integer parseInt) throws RemoteException, RemitoException {
		return remoteObject.getRemitoByCod(parseInt);
		
	}
	
	//-----------------------------------ITEM RMEITO-------------------------------------------------------------------------
	//ITEM REMITO
	public void grabarItemRemito(ItemRemitoDTO itemRemito) throws RemoteException, itemRemitoException 
	{
		remoteObject.grabarItemRemito(itemRemito);
	}

	//-----------------------------------SOLICITUD INDIVIDUAL-------------------------------------------------------------------------
	
	public List<SolicitudIndividualDTO> mostrarSolicitudesIndividuales() throws RemoteException, SolicitudException  
	{
		return remoteObject.mostrarSolicitudesIndividuales();
	}

	
	public void grabarSolicitudIndividual(SolicitudIndividualDTO solicitud) throws RemoteException, SolicitudException 
	{
		remoteObject.grabarSolicitudIndividual(solicitud);
	}

	public void unirSolicitudesIndividuales(List<CombinadorDTO> mandar) throws RemoteException, SolicitudException {
		remoteObject.unirSolicitudesIndividuales(mandar);
		
	}

	public List<SolicitudIndividualDTO> mostrarSolicitudesNoDiarias()	throws RemoteException, SolicitudException 
	{
		return remoteObject.mostrarSolicitudesNoDiarias();
	}
	//-----------------------------------SEMIS-------------------------------------------------------------------------
	
	public List<SemiElaboradoDTO> mostrarSemiElaborados()  throws RemoteException, SemiElaboradoException{
		return remoteObject.mostrarSemiElaborados();
	}

	public SemiElaboradoDTO getSemiElaboradoByCod(int parseInt) throws RemoteException, SemiElaboradoException{
		// TODO Auto-generated method stub
		return remoteObject.getSemiElaboradoByCod(parseInt);
	}


	
	//-------------------------------------ELABORADOS------------------------------------------

	public void grabarElaborado(ElaboradoDTO elab)throws RemoteException, SemiElaboradoException {
		// TODO Auto-generated method stub
		remoteObject.grabarElaborado(elab);
	}


	

	

	
}
