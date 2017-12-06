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
import exceptions.ElaboradoException;
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
	
	private BusinessDelegate() throws RemoteException {
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
		} catch (RemoteException e) {
			throw new UsuarioException("USUARIO o PASSWORD incorrecta!");
		}
	}
	
	public void guardarUsuarios(UsuariosDTO usuario) throws RemoteException, UsuarioException 
	{
		try {
			remoteObject.guardarUsuarios(usuario);
		} catch (RemoteException e) {
			throw new UsuarioException("No se puede grabar el usuario!");
		}
	}
	
	
	public UsuariosDTO buscarUserPorLogin(String login) throws RemoteException, UsuarioException
	{
		try {
			return remoteObject.buscarUserPorLogin(login);
		} catch (RemoteException e) {
			throw new UsuarioException("No se ENCUENTRA el usuario");
		}
	}
	
	public void borrarUsuario(UsuariosDTO usuario) throws RemoteException, UsuarioException
	{
		try {
			remoteObject.borrarUsuario(usuario);
		} catch (RemoteException e) {
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
		} catch (RemoteException e) {
			throw new ComandaException("No se pudo grabar la comanda!");
		}
	}
	
	public List<ComandaDTO> mostrarComandas() throws RemoteException, ComandaException 
	{
		try {
			return remoteObject.mostrarComandas();
		} catch (RemoteException e) {
			throw new ComandaException("No se pudo LISTAR las comandas!");
		}
	}
	
	public ComandaDTO BuscarComandasPorCod(Integer codComanda) throws RemoteException, ComandaException
	{
		try {
			return remoteObject.BuscarComandasPorCod(codComanda);
		} catch (RemoteException e) {
			throw new ComandaException("No se pudo encontrar la COMANDA por codigo!");
		}
	}
	 
	
	//---------------------------------------ITEM COMANDA------------------------------------------------------------
	
	public boolean grabarItemComanda(ItemComandaDTO itemComanda) throws RemoteException, itemComandaException 
	{
		try {
			return remoteObject.grabarItemComanda(itemComanda);
		} catch (RemoteException e) {
			throw new itemComandaException("NO se pudo GRABAR el ITEMCOMANDA!");
		}
	}
	
	
	public void itemComandaLista(int coditemcomanda) throws RemoteException, itemComandaException 
	{
		try {
			remoteObject.itemComandaLista(coditemcomanda);
		} catch (RemoteException e) {
			throw new itemComandaException("El ITEM DE LA COMANDA NO PUDO REALIZARSE!");
		}
	}
	
	//---------------------------------------FACTURAS------------------------------------------------------------
	public void grabarFactura(FacturaDTO factura) throws RemoteException, FacturaException 
	{
		try {
			remoteObject.grabarFactura(factura);
		} catch (RemoteException e) {
			throw new FacturaException("No se pudo grabar la FACTURA!");
		}
	}
	
	public List<FacturaDTO> mostrarFacturas() throws RemoteException, FacturaException 
	{
		try {
			return remoteObject.mostrarFacturas();
		} catch (RemoteException e) {
			throw new FacturaException("No se pueden MOSTRAR las FACTURAS!");
		}
	}
	
	
	public FacturaDTO mostrarFacturaByCod(int nroFact) throws RemoteException, FacturaException 
	{
		try {
			return remoteObject.mostrarFacturaByCod(nroFact);
		} catch (RemoteException e) {
			throw new FacturaException("No se ENCONTRO la FACTURA!");
		}
	}
	
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws RemoteException, FacturaException
	{
		try {
			remoteObject.facturarMesa(codMesa, formadepago);
		} catch (RemoteException e) {
			throw new FacturaException("No se pudo generar la FACTURA!");
		}
	}
	
	// ---------------------------------------ITEM FACTURA------------------------------------------------------
	
	public List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws RemoteException, FacturaException
	{
		try {
			return remoteObject.obtenerItemsFacturaByCodFactura(codFactura);
		} catch (RemoteException e) {
			throw new FacturaException("No se encontraron los items de la FACTURA!");
		}
	}
	
	//---------------------------------------RESERVAS------------------------------------------------------------
	
	public void grabarReserva(ReservaDTO reserva) throws RemoteException, ReservaException 
	{
		try {
			remoteObject.grabarReserva(reserva);
		} catch (RemoteException e) {
			throw new ReservaException("No se pudo GRABAR la RESERVA");
		}
	}
	
	public List<ReservaDTO> mostrarReservas()throws RemoteException,ReservaException
	{
		try {
			return remoteObject.mostrarReservas();
		} catch (RemoteException e) {
			throw new ReservaException("No se pudieron LISTAR las RESERVAS");
		}
	}
	
	//-----------------------------------MOZOS----------------------------------------------------------------------
	public List<MozoDTO> mostrarMozos() throws RemoteException,MozoException
	{
		try {
			return remoteObject.mostrarMozos();
		} catch (RemoteException e) {
			throw new MozoException("No se pueden MOSTRAR los MOZOS!");
		}
	}
	
	
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws RemoteException, MozoException
	{
		try {
			return remoteObject.mostrarComisionesAPagar(FechaDesde, FechaHasta);
		} catch (RemoteException e) {
			throw new MozoException("No se pueden CALCULAR las comisiones de los MOZOS!");
		}
	}
	
	
	public List<String[]> mostrarResultadoComisionesMozo(Date FechaDesde,Date FechaHasta) throws RemoteException, MozoException
	{
		try {
			return remoteObject.mostrarResultadoComisionesMozo(FechaDesde,FechaHasta);
		} catch (RemoteException e) {
			throw new MozoException("No se pueden MOSTRAR el resultado de las COMISIONES de los MOZOS!");
		}
	}
	
	//-----------------------------------MESAS-------------------------------------------------------------------------
	public List<MesaDTO> mostrarMesas() throws RemoteException,MesaException
	{
		try {
			return remoteObject.mostrarMesas();
		} catch (RemoteException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS!");
		}
	}
	public List<MesaDTO> mostrarFacturables() throws RemoteException,MesaException
	{
		try {
			return remoteObject.mostrarMesasFacturables();
		} catch (RemoteException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS FACTURABLES!");
		}
	}
	public List<MesaDTO> mostrarMesasOcupadas() throws RemoteException,MesaException
	{
		try {
			return remoteObject.mostrarMesasOcupadas();
		} catch (RemoteException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS OCUPADAS!");
		}
	}
	
	public MesaDTO BuscarMesaPorCod(Integer codMesa) throws RemoteException, MesaException 
	{
		try {
			return remoteObject.BuscarMesaPorCod(codMesa);
		} catch (RemoteException e) {
			throw new MesaException("No se pueden ENCONTRO la MESA buscada!");
		}
	}
	
	public List<MesaDTO> mostrarMesasLibres() throws RemoteException, MesaException
	{
		try {
			return remoteObject.mostrarMesasLibres();
		} catch (RemoteException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS LIBRES!");
		}
	}
	
	
	public void ocuparMesaPorCod(Integer codMesa) throws RemoteException, MesaException
	{		
		try {
				remoteObject.ocuparMesaPorCod(codMesa);
		} catch (RemoteException e) {
		throw new MesaException("No se pudo Cambiar el Estado");
	}
	}
		
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws RemoteException, MesaException
		{		
			try {
				return remoteObject.combinarMesasPorCod(codmesa1, codmesa2);
			} catch (RemoteException e) {
				throw new MesaException("No se pueden COMBINAR esas MESAS!");
			}
		}
		
	public void grabarMesa(MesaDTO mesa) throws RemoteException, MesaException 
	{
		try {
			remoteObject.grabarMesa(mesa);
		} catch (RemoteException e) {
			throw new MesaException("No se puede GRABAR la MESA!");
		}
	}
	
	
	//-----------------------------------SECTORES-------------------------------------------------------------------------
	public List<SectorDTO> mostrarSectores() throws RemoteException, SectorException
	{
		try {
			return remoteObject.mostrarSectores();
		} catch (RemoteException e) {
			throw new SectorException("No se pueden MOSTRAR los SECTORES!");
		}
	}
	
	//-----------------------------------SALONES-------------------------------------------------------------------------
	public List<SalonDTO> mostrarSalones() throws RemoteException, SalonException 
	{
		try {
			return remoteObject.mostrarSalones();
		} catch (RemoteException e) {
			throw new SalonException("No se pueden MOSTRAR los SALONES!");
		}
	}
	
	//-----------------------------------DEPOSITOS-------------------------------------------------------------------------
	public List<DepositoDTO> mostrarDepositos() throws RemoteException, DepositoException
	{
		try {
			return remoteObject.mostrarDepositos();
		} catch (RemoteException e) {
			throw new DepositoException("No se pueden MOSTRAR los DEPOSITOS!");
		}
	}
	
	
	//-----------------------------------FACTURADO CAJA-------------------------------------------------------------------------
	public double mostrarTotalFacturadoCaja(Date FechaDesde, Date FechaHasta) throws RemoteException, CajaException 
	{
		try {
			return remoteObject.mostrarTotalFacturadoCaja(FechaDesde, FechaHasta);
		} catch (RemoteException e) {
			throw new CajaException("No se pueden MOSTRAR lo FACTURADO EN CAJA");
		}
	}
	
	
	//-----------------------------------UNIDADES---------------------------------------------------------------------------
	public List<UnidadDTO> mostrarUnidades() throws RemoteException, UnidadException {
		try {
			return remoteObject.mostrarUnidades();
		} catch (RemoteException e) {
			throw new UnidadException("No se pueden MOSTRAR las UNIDADES!");
		}
		
	}
	
	public UnidadDTO UnidadByDescp(String descp) throws RemoteException,UnidadException {
		try {
			return remoteObject.UnidadByDescp(descp);
		} catch (RemoteException e) {
			throw new UnidadException("No se pueden MOSTRAR las UNIDADES por descripcion!");
		}
	}
	
	
	//-----------------------------------MATERIA PRIMA(MATERIALES)------------------------------------------------------------------
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException, MateriaPrimaException
	{
		try {
			remoteObject.grabarMateriaPrima(materia);
		} catch (RemoteException e) {
			throw new MateriaPrimaException("No se puede GRABAR la MATERIA PRIMA!");
		}
	}
	
	public List<MateriaPrimaDTO> listarStock() throws RemoteException, MateriaPrimaException
	{
		try {
			return remoteObject.listarStock();
		} catch (RemoteException e) {
			throw new MateriaPrimaException("No se pueden LISTAR  las MATERIAS PRIMA!");
		}
	}
	
	public MateriaPrimaDTO getMateriaPrimaByCod(Integer codMaterial) throws RemoteException, MateriaPrimaException
	{
		try {
			return remoteObject.getMateriaPrimaByCod(codMaterial);
		} catch (RemoteException e) {
			throw new MateriaPrimaException("No se pueden MOSTRAR Las MATERIAS PRIMAS!");
		}
	}

	public void actualizarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException, MateriaPrimaException {
		try {// TODO Auto-generated method stub
		remoteObject.actualizarMaterial(materia);
		} catch (RemoteException e) {
		throw new MateriaPrimaException("No se pueden MOSTRAR Las MATERIAS PRIMAS!");
		}
	}
	
	public void eliminarMateria(MateriaPrimaDTO materia)  throws RemoteException, MateriaPrimaException{
		try {// TODO Auto-generated method stub// TODO Auto-generated method stub
		remoteObject.eliminarMateria(materia);
	} catch (RemoteException e) {
		throw new MateriaPrimaException("No se pueden MOSTRAR Las MATERIAS PRIMAS!");
	}
	}

	//-----------------------------------ITEMS COMANDA-----------------------------------------------------------------------------

	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws RemoteException,itemComandaException
	{
		
		try {
			return remoteObject.getItemsPendientesxArea(area);
		} catch (RemoteException e) {
			throw new itemComandaException("NO HAY ITEMS PENDIENTES");
		}
	}

	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws RemoteException,itemComandaException
	{
		try {
			return remoteObject.obtenerItemsComandaByCodComanda(parseInt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new itemComandaException("NO ESTA EL ITEM BUSCADO");
		}
	}
	
	//-----------------------------------CARTA-----------------------------------------------------------------------------
	public CartaDTO buscarCartaPorCod(int nrocarta) throws RemoteException, CartaException
	{
		try {
			return remoteObject.buscarCartaPorCod(nrocarta);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new CartaException("NO EXISTE CARTA CON ESE CODIGO");
		}
	}
	
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta) throws RemoteException, CartaException 
	{
		try {
			return remoteObject.obtenerPlatosByCodCarta(nrocarta);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new CartaException("NO EXISTEN PLATOS PARA CARTA CON ESE CODIGO");
		}
	}
	
	public List<CartaDTO> mostrarCartas() throws RemoteException, CartaException 
	{
		try {
			return remoteObject.mostrarCartas();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new CartaException("NO HAY CARTAS");
		}
	}
	
	//-----------------------------------PLAN DE PRODUCCION-----------------------------------------------------------------------------
	public List<PlanDeProduccionDTO> mostrarPDPs() throws RemoteException, PlanDeProduccionException 
	{
		try {
			return remoteObject.mostrarPDPs();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PlanDeProduccionException ("NO HAY PLANES");
		}
	}
	
	public PlanDeProduccionDTO obtenerPDPByCodPDP(int codPdp) throws RemoteException, PlanDeProduccionException
	{
		try {
			return remoteObject.obtenerPDPByCodPDP(codPdp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PlanDeProduccionException ("NO HAY PLAN CON CODIGO INGRESADO");
		}
	}
	
	public void grabarPdP(PlanDeProduccionDTO pdp) throws RemoteException, PlanDeProduccionException {
		try {
			remoteObject.grabarPdP(pdp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PlanDeProduccionException ("NO SE PUDO GRABAR EL PLAN");
		}
		
	}
	
	//-----------------------------------ITEM PLAN DE PRODUCCION-----------------------------------------------------------------------------
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)throws RemoteException,itemPlanDeProduccionException
	{
		try {
			return remoteObject.obtenerItemPDPByCodPDP(nroPlanDeProduccion);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new itemPlanDeProduccionException ("NO SE PUDO OBTENER ITEM PLAN DE PRODUCCION");
		}
	}
	
	public void grabarItemPdP(ItemPlanProduccionDTO itemPdP) throws RemoteException,itemPlanDeProduccionException{
	try {
		remoteObject.grabarItemPdP(itemPdP);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		throw new itemPlanDeProduccionException ("NO SE PUDO GRABAR EL ITEM");
	}
		
	}
	
	//-----------------------------------REMITO-------------------------------------------------------------------------
	//REMITO
	public void grabarRemito(RemitoDTO remito) throws RemoteException, RemitoException 
	{
		try {
			remoteObject.grabarRemito(remito);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RemitoException  ("NO SE PUDO GRABAR EL REMITO");
		}
	}
	
	public List<RemitoDTO> mostrarRemitos() throws RemoteException, RemitoException 
	{
		try {
			return remoteObject.mostrarRemitos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RemitoException  ("NO PUDE OBTENER LISTADO DE REMITOS");
		}
	}
	
	public RemitoDTO getRemitoByCod(Integer parseInt) throws RemoteException, RemitoException {
		try {
			return remoteObject.getRemitoByCod(parseInt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RemitoException  ("NO PUDE OBTENER REMITO POR CODIGO");
		}
		
	}
	
	//-----------------------------------ITEM RMEITO-------------------------------------------------------------------------
	//ITEM REMITO
	public void grabarItemRemito(ItemRemitoDTO itemRemito) throws RemoteException, itemRemitoException 
	{
		try {
			remoteObject.grabarItemRemito(itemRemito);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new itemRemitoException  ("NO PUDE GRABAR ITEM REMITO");
		}
	}

	//-----------------------------------SOLICITUD INDIVIDUAL-------------------------------------------------------------------------
	
	public List<SolicitudIndividualDTO> mostrarSolicitudesIndividuales() throws RemoteException, SolicitudException  
	{
		try {
			return remoteObject.mostrarSolicitudesIndividuales();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SolicitudException  ("NO SE PUEDE MOSTRAR SOLICITUDES");
		}
	}

	
	public void grabarSolicitudIndividual(SolicitudIndividualDTO solicitud) throws RemoteException, SolicitudException 
	{
		try {
			remoteObject.grabarSolicitudIndividual(solicitud);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SolicitudException  ("NO SE PUEDE GRABAR SOLICITUD");
		}
	}

	public void unirSolicitudesIndividuales(List<CombinadorDTO> mandar) throws RemoteException, SolicitudException {
		try {
			remoteObject.unirSolicitudesIndividuales(mandar);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SolicitudException  ("NO SE PUEDEN COMBINAR SOLICITUDES");
		}
		
	}

	public List<SolicitudIndividualDTO> mostrarSolicitudesNoDiarias()	throws RemoteException, SolicitudException 
	{
		try {
			return remoteObject.mostrarSolicitudesNoDiarias();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SolicitudException  ("NO PUEDO MOSTRAR SOLICITUDES NO DIARIAS");
		}
	}
	
	public List<SolicitudDiariaDTO> mostrarSolicitudesDiarias() throws RemoteException, SolicitudException{
		try {
			return remoteObject.mostrarSolicitudesDiarias();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SolicitudException  ("NO PUEDO MOSTRAR SOLICITUDES DIARIAS");
		}
	}

	
	//-----------------------------------SEMIS-------------------------------------------------------------------------
	
	public List<SemiElaboradoDTO> mostrarSemiElaborados()  throws RemoteException, SemiElaboradoException{
		try {
			return remoteObject.mostrarSemiElaborados();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SemiElaboradoException  ("NO PUEDO OBTENER SEMI ELABORADOS");
		}
	}

	public SemiElaboradoDTO getSemiElaboradoByCod(int parseInt) throws RemoteException, SemiElaboradoException{
		// TODO Auto-generated method stub
		try {
			return remoteObject.getSemiElaboradoByCod(parseInt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SemiElaboradoException  ("NO PUEDO OBTENER EL SEMIELABORADO SOLICITADO");
		}
	}


	
	//-------------------------------------ELABORADOS------------------------------------------

	public void grabarElaborado(ElaboradoDTO elab)throws RemoteException, SemiElaboradoException {
		// TODO Auto-generated method stub
		try {
			remoteObject.grabarElaborado(elab);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new SemiElaboradoException  ("NO PUEDO OBTENER SEMI ELABORADOS");
		}
	}
	
	public ElaboradoDTO getElaboradoByCod(int parseInt) throws RemoteException, ElaboradoException{
		// TODO Auto-generated method stub
		try {
			return remoteObject.getElaboradoByCod(parseInt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new ElaboradoException  ("NO PUEDO OBTENER ELABORADOS");
		}
	}

	public void actualizarElaborado(ElaboradoDTO elab) throws RemoteException, ElaboradoException{
		// TODO Auto-generated method stub
		 try {
			remoteObject.actualizarElaborado(elab);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new ElaboradoException  ("NO PUEDO ACTUALIZAR ELABORADO");
		}
	}

	


	

	

	
}
