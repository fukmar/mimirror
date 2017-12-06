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
	public boolean verificarPassword(String login, String password) throws  UsuarioException
	{
		try {
			return remoteObject.verificarPassword(login, password);
		} catch (UsuarioException e) {
			throw new UsuarioException("USUARIO o PASSWORD incorrecta!");
		}
	}
	
	public void guardarUsuarios(UsuariosDTO usuario) throws  UsuarioException 
	{
		try {
			remoteObject.guardarUsuarios(usuario);
		} catch (UsuarioException e) {
			throw new UsuarioException("No se puede grabar el usuario!");
		}
	}
	
	
	public UsuariosDTO buscarUserPorLogin(String login) throws  UsuarioException
	{
		try {
			return remoteObject.buscarUserPorLogin(login);
		} catch (UsuarioException e) {
			throw new UsuarioException("No se ENCUENTRA el usuario");
		}
	}
	
	public void borrarUsuario(UsuariosDTO usuario) throws  UsuarioException
	{
		try {
			remoteObject.borrarUsuario(usuario);
		} catch (UsuarioException e) {
			throw new UsuarioException("No se pudo BORRAR el usuario");
		}
	}
	//---------------------------------------PLATOS------------------------------------------------------------
	public List<PlatoDTO> listarPlatos() throws  PlatoException
	{
		try {
			return remoteObject.listarPlatos();
		} catch (PlatoException e) {
			// TODO Auto-generated catch block
			throw new PlatoException("Error! no hay platos");
		}
	}
	
	public List<PlatoDTO> BuscarPlatosparecidos(String nombre, CategoriaPlato categoriaplato) throws  PlatoException 
	{
		try {
			return remoteObject.buscarPlatosParecidos(nombre, categoriaplato);
		} catch (PlatoException e) {
			throw new PlatoException("No se encontraron PLATOS similares!");
		}
	}
	
	
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws  PlatoException 
	{
		try {
			return remoteObject.BuscarPlatoPorCod(codPlato);
		} catch (PlatoException e) {
			throw new PlatoException("No se encontro el PLATO por CODIGO!");
		}
	}

	//---------------------------------------COMANDAS------------------------------------------------------------
	public void grabarComanda(ComandaDTO comanda) throws  ComandaException 
	{
		try {
			remoteObject.grabarComanda(comanda);
		} catch (Exception e) {
			throw new ComandaException("No se pudo grabar la comanda!");
		}
	}
	
	public List<ComandaDTO> mostrarComandas() throws  ComandaException 
	{
		try {
			return remoteObject.mostrarComandas();
		} catch (Exception e) {
			throw new ComandaException("No se pudo LISTAR las comandas!");
		}
	}
	
	public ComandaDTO BuscarComandasPorCod(Integer codComanda) throws  ComandaException
	{
		try {
			return remoteObject.BuscarComandasPorCod(codComanda);
		} catch (Exception e) {
			throw new ComandaException("No se pudo encontrar la COMANDA por codigo!");
		}
	}
	 
	
	//---------------------------------------ITEM COMANDA------------------------------------------------------------
	
	public boolean grabarItemComanda(ItemComandaDTO itemComanda) throws  itemComandaException 
	{
		try {
			return remoteObject.grabarItemComanda(itemComanda);
		} catch (itemComandaException e) {
			throw new itemComandaException("NO se pudo GRABAR el ITEMCOMANDA!");
		}
	}
	
	
	public void itemComandaLista(int coditemcomanda) throws  itemComandaException 
	{
		try {
			remoteObject.itemComandaLista(coditemcomanda);
		} catch (itemComandaException e) {
			throw new itemComandaException("El ITEM DE LA COMANDA NO PUDO REALIZARSE!");
		}
	}
	
	//---------------------------------------FACTURAS------------------------------------------------------------
	public void grabarFactura(FacturaDTO factura) throws  FacturaException 
	{
		try {
			remoteObject.grabarFactura(factura);
		} catch (FacturaException e) {
			throw new FacturaException("No se pudo grabar la FACTURA!");
		}
	}
	
	public List<FacturaDTO> mostrarFacturas() throws  FacturaException 
	{
		try {
			return remoteObject.mostrarFacturas();
		} catch (FacturaException e) {
			throw new FacturaException("No se pueden MOSTRAR las FACTURAS!");
		}
	}
	
	
	public FacturaDTO mostrarFacturaByCod(int nroFact) throws  FacturaException 
	{
		try {
			return remoteObject.mostrarFacturaByCod(nroFact);
		} catch (FacturaException e) {
			throw new FacturaException("No se ENCONTRO la FACTURA!");
		}
	}
	
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws  FacturaException
	{
		try {
			remoteObject.facturarMesa(codMesa, formadepago);
		} catch (FacturaException e) {
			throw new FacturaException("No se pudo generar la FACTURA!");
		}
	}
	
	// ---------------------------------------ITEM FACTURA------------------------------------------------------
	
	public List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws  FacturaException
	{
		try {
			return remoteObject.obtenerItemsFacturaByCodFactura(codFactura);
		} catch (FacturaException e) {
			throw new FacturaException("No se encontraron los items de la FACTURA!");
		}
	}
	
	//---------------------------------------RESERVAS------------------------------------------------------------
	
	public void grabarReserva(ReservaDTO reserva) throws  ReservaException 
	{
		try {
			remoteObject.grabarReserva(reserva);
		} catch (ReservaException e) {
			throw new ReservaException("No se pudo GRABAR la RESERVA");
		}
	}
	
	public List<ReservaDTO> mostrarReservas()throws ReservaException
	{
		try {
			return remoteObject.mostrarReservas();
		} catch (ReservaException e) {
			throw new ReservaException("No se pudieron LISTAR las RESERVAS");
		}
	}
	
	//-----------------------------------MOZOS----------------------------------------------------------------------
	public List<MozoDTO> mostrarMozos() throws MozoException
	{
		try {
			return remoteObject.mostrarMozos();
		} catch (MozoException e) {
			throw new MozoException("No se pueden MOSTRAR los MOZOS!");
		}
	}
	
	
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws  MozoException
	{
		try {
			return remoteObject.mostrarComisionesAPagar(FechaDesde, FechaHasta);
		} catch (MozoException e) {
			throw new MozoException("No se pueden CALCULAR las comisiones de los MOZOS!");
		}
	}
	
	
	public List<String[]> mostrarResultadoComisionesMozo(Date FechaDesde,Date FechaHasta) throws  MozoException
	{
		try {
			return remoteObject.mostrarResultadoComisionesMozo(FechaDesde,FechaHasta);
		} catch (MozoException e) {
			throw new MozoException("No se pueden MOSTRAR el resultado de las COMISIONES de los MOZOS!");
		}
	}
	
	//-----------------------------------MESAS-------------------------------------------------------------------------
	public List<MesaDTO> mostrarMesas() throws MesaException
	{
		try {
			return remoteObject.mostrarMesas();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS!");
		}
	}
	public List<MesaDTO> mostrarFacturables() throws MesaException
	{
		try {
			return remoteObject.mostrarMesasFacturables();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS FACTURABLES!");
		}
	}
	public List<MesaDTO> mostrarMesasOcupadas() throws MesaException
	{
		try {
			return remoteObject.mostrarMesasOcupadas();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS OCUPADAS!");
		}
	}
	
	public MesaDTO BuscarMesaPorCod(Integer codMesa) throws  MesaException 
	{
		try {
			return remoteObject.BuscarMesaPorCod(codMesa);
		} catch (MesaException e) {
			throw new MesaException("No se pueden ENCONTRO la MESA buscada!");
		}
	}
	
	public List<MesaDTO> mostrarMesasLibres() throws  MesaException
	{
		try {
			return remoteObject.mostrarMesasLibres();
		} catch (MesaException e) {
			throw new MesaException("No se pueden MOSTRAR las MESAS LIBRES!");
		}
	}
	
	
	public void ocuparMesaPorCod(Integer codMesa) throws  MesaException
	{		
		try {
				remoteObject.ocuparMesaPorCod(codMesa);
		} catch (MesaException e) {
		throw new MesaException("No se pudo Cambiar el Estado");
	}
	}
		
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws  MesaException
		{		
			try {
				return remoteObject.combinarMesasPorCod(codmesa1, codmesa2);
			} catch (MesaException e) {
				throw new MesaException("No se pueden COMBINAR esas MESAS!");
			}
		}
		
	public void grabarMesa(MesaDTO mesa) throws  MesaException 
	{
		try {
			remoteObject.grabarMesa(mesa);
		} catch (MesaException e) {
			throw new MesaException("No se puede GRABAR la MESA!");
		}
	}
	
	
	//-----------------------------------SECTORES-------------------------------------------------------------------------
	public List<SectorDTO> mostrarSectores() throws  SectorException
	{
		try {
			return remoteObject.mostrarSectores();
		} catch (SectorException e) {
			throw new SectorException("No se pueden MOSTRAR los SECTORES!");
		}
	}
	
	//-----------------------------------SALONES-------------------------------------------------------------------------
	public List<SalonDTO> mostrarSalones() throws  SalonException 
	{
		try {
			return remoteObject.mostrarSalones();
		} catch (SalonException e) {
			throw new SalonException("No se pueden MOSTRAR los SALONES!");
		}
	}
	
	//-----------------------------------DEPOSITOS-------------------------------------------------------------------------
	public List<DepositoDTO> mostrarDepositos() throws  DepositoException
	{
		try {
			return remoteObject.mostrarDepositos();
		} catch (DepositoException e) {
			throw new DepositoException("No se pueden MOSTRAR los DEPOSITOS!");
		}
	}
	
	
	//-----------------------------------FACTURADO CAJA-------------------------------------------------------------------------
	public double mostrarTotalFacturadoCaja(Date FechaDesde, Date FechaHasta) throws  CajaException 
	{
		try {
			return remoteObject.mostrarTotalFacturadoCaja(FechaDesde, FechaHasta);
		} catch (CajaException e) {
			throw new CajaException("No se pueden MOSTRAR lo FACTURADO EN CAJA");
		}
	}
	
	
	//-----------------------------------UNIDADES---------------------------------------------------------------------------
	public List<UnidadDTO> mostrarUnidades() throws  UnidadException {
		try {
			return remoteObject.mostrarUnidades();
		} catch (UnidadException e) {
			throw new UnidadException("No se pueden MOSTRAR las UNIDADES!");
		}
		
	}
	
	public UnidadDTO UnidadByDescp(String descp) throws UnidadException {
		try {
			return remoteObject.UnidadByDescp(descp);
		} catch (UnidadException e) {
			throw new UnidadException("No se pueden MOSTRAR las UNIDADES por descripcion!");
		}
	}
	
	
	//-----------------------------------MATERIA PRIMA(MATERIALES)------------------------------------------------------------------
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws  MateriaPrimaException
	{
		try {
			remoteObject.grabarMateriaPrima(materia);
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se puede GRABAR la MATERIA PRIMA!");
		}
	}
	
	public List<MateriaPrimaDTO> listarStock() throws  MateriaPrimaException
	{
		try {
			return remoteObject.listarStock();
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se pueden LISTAR  las MATERIAS PRIMA!");
		}
	}
	
	public MateriaPrimaDTO getMateriaPrimaByCod(Integer codMaterial) throws  MateriaPrimaException
	{
		try {
			return remoteObject.getMateriaPrimaByCod(codMaterial);
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se pueden MOSTRAR Las MATERIAS PRIMAS!");
		}
	}

	public void actualizarMateriaPrima(MateriaPrimaDTO materia) throws  MateriaPrimaException {
		// TODO Auto-generated method stub
		try {
			remoteObject.actualizarMaterial(materia);
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se pueden ACTUALIZAR Las MATERIAS PRIMAS!");
		}
		
	}
	
	public void eliminarMateria(MateriaPrimaDTO materia)  throws  MateriaPrimaException{
		// TODO Auto-generated method stub
		try {
			remoteObject.eliminarMateria(materia);
		} catch (MateriaPrimaException e) {
			throw new MateriaPrimaException("No se pueden ELIMINAR Las MATERIAS PRIMAS!");
		}
	}

	//-----------------------------------ITEMS COMANDA-----------------------------------------------------------------------------

	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws itemComandaException
	{
		try {
			return remoteObject.getItemsPendientesxArea(area);
		} catch (itemComandaException e) {
			throw new itemComandaException("No se pueden MOSTRAR los ITEMS COMANDA por AREA!");
		}
	}

	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws itemComandaException
	{
		try {
			return remoteObject.obtenerItemsComandaByCodComanda(parseInt);
		} catch (itemComandaException e) {
			throw new itemComandaException("No se pueden MOSTRAR los ITEMS COMANDA por CODIGO DE COMANDA!");
		}
	}
	
	//-----------------------------------CARTA-----------------------------------------------------------------------------
	public CartaDTO buscarCartaPorCod(int nrocarta) throws  CartaException
	{
		try {
			return remoteObject.buscarCartaPorCod(nrocarta);
		} catch (CartaException e) {
			throw new CartaException("No se encuentra la CARTA!");
		}
	}
	
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta) throws  CartaException 
	{
		try {
			return remoteObject.obtenerPlatosByCodCarta(nrocarta);
		} catch (CartaException e) {
			throw new CartaException("No se encuentran los platos por codigo de  CARTA!");
		}
	}
	
	public List<CartaDTO> mostrarCartas() throws  CartaException 
	{
		try {
			return remoteObject.mostrarCartas();
		} catch (CartaException e) {
			throw new CartaException("No se pueden MOSTRAR las cartas");
		}
	}
	
	//-----------------------------------PLAN DE PRODUCCION-----------------------------------------------------------------------------
	public List<PlanDeProduccionDTO> mostrarPDPs() throws  PlanDeProduccionException 
	{
		try {
			return remoteObject.mostrarPDPs();
		} catch (PlanDeProduccionException e) {
			throw new PlanDeProduccionException("No se pueden mostrar los planes de produccion !");
		}
	}
	
	public PlanDeProduccionDTO obtenerPDPByCodPDP(int codPdp) throws  PlanDeProduccionException
	{
		try {
			return remoteObject.obtenerPDPByCodPDP(codPdp);
		} catch (PlanDeProduccionException e) {
			throw new PlanDeProduccionException("No se pueden  obtener el plan de producccion!");
		}
	}
	
	public void grabarPdP(PlanDeProduccionDTO pdp) throws  PlanDeProduccionException {
		try {
			remoteObject.grabarPdP(pdp);
		} catch (PlanDeProduccionException e) {
			throw new PlanDeProduccionException("No se puede GRABAR el plan de produccion !");
		}
		
	}
	
	//-----------------------------------ITEM PLAN DE PRODUCCION-----------------------------------------------------------------------------
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)throws itemPlanDeProduccionException
	{
		try {
			return remoteObject.obtenerItemPDPByCodPDP(nroPlanDeProduccion);
		} catch (itemPlanDeProduccionException e) {
			throw new itemPlanDeProduccionException("No se pueden obtener los items de planes de produccion !");
		}
	}
	
	public void grabarItemPdP(ItemPlanProduccionDTO itemPdP) throws itemPlanDeProduccionException{
	try {
		remoteObject.grabarItemPdP(itemPdP);
	} catch (itemPlanDeProduccionException e) {
		throw new itemPlanDeProduccionException("No se pueden GRABAR los items de planes de produccion !");
	}
		
	}
	
	//-----------------------------------REMITO-------------------------------------------------------------------------
	//REMITO
	public void grabarRemito(RemitoDTO remito) throws  RemitoException 
	{
		try {
			remoteObject.grabarRemito(remito);
		} catch (RemitoException e) {
			throw new RemitoException("No se pueden GRABAR los REMITOS !");
		}
	}
	
	public List<RemitoDTO> mostrarRemitos() throws  RemitoException 
	{
		try {
			return remoteObject.mostrarRemitos();
		} catch (RemitoException e) {
			throw new RemitoException("No se pueden MOSTRAR los REMITOS !");
		}
	}
	
	public RemitoDTO getRemitoByCod(Integer parseInt) throws  RemitoException {
		try {
			return remoteObject.getRemitoByCod(parseInt);
		} catch (RemitoException e) {
			throw new RemitoException("No se encuentra el remito !");
		}
		
	}
	
	//-----------------------------------ITEM REMITO-------------------------------------------------------------------------
	//ITEM REMITO
	public void grabarItemRemito(ItemRemitoDTO itemRemito) throws  itemRemitoException 
	{
		try {
			remoteObject.grabarItemRemito(itemRemito);
		} catch (itemRemitoException e) {
			throw new itemRemitoException ("No se pueden GRABAR los ITEM REMITO !");
		}
	}

	//-----------------------------------SOLICITUD INDIVIDUAL-------------------------------------------------------------------------
	
	public List<SolicitudIndividualDTO> mostrarSolicitudesIndividuales() throws  SolicitudException  
	{
		try {
			return remoteObject.mostrarSolicitudesIndividuales();
		} catch (SolicitudException e) {
			throw new SolicitudException ("No se pueden MOSTRAR las solicitudes individuales!");
		}
	}

	
	public void grabarSolicitudIndividual(SolicitudIndividualDTO solicitud) throws  SolicitudException 
	{
		try {
			remoteObject.grabarSolicitudIndividual(solicitud);
		} catch (Exception e) {
			throw new SolicitudException ("No se pueden GRABAR las solicitudes individuales!");
		}
	}

	public void unirSolicitudesIndividuales(List<CombinadorDTO> mandar) throws  SolicitudException {
		try {
			remoteObject.unirSolicitudesIndividuales(mandar);
		} catch (Exception e) {
			throw new SolicitudException ("No se pueden UNIR las solicitudes individuales!");
		}
		
	}

	public List<SolicitudIndividualDTO> mostrarSolicitudesNoDiarias()	throws  SolicitudException 
	{
		try {
			return remoteObject.mostrarSolicitudesNoDiarias();
		} catch (SolicitudException e) {
			throw new SolicitudException ("No se pueden MOSTRAR las solicitudes NO individuales!");
		}
	}
	
	public List<SolicitudDiariaDTO> mostrarSolicitudesDiarias() throws  SolicitudException{
		try {
			return remoteObject.mostrarSolicitudesDiarias();
		} catch (SolicitudException e) {
			throw new SolicitudException ("No se pueden MOSTRAR las solicitudes DIARIAS!");
		}
	}

	
	//-----------------------------------SEMIS-------------------------------------------------------------------------
	
	public List<SemiElaboradoDTO> mostrarSemiElaborados()  throws  SemiElaboradoException{
		try {
			return remoteObject.mostrarSemiElaborados();
		} catch (SemiElaboradoException e) {
			throw new SemiElaboradoException("No se pueden MOSTRAR los SEMIELABORADOS!");
		}
	}

	public SemiElaboradoDTO getSemiElaboradoByCod(int parseInt) throws  SemiElaboradoException{
		// TODO Auto-generated method stub
		try {
			return remoteObject.getSemiElaboradoByCod(parseInt);
		} catch (SemiElaboradoException e) {
			throw new SemiElaboradoException("No se ENCUENTRAN el SEMIELABORADO!");
		}
	}


	
	//-------------------------------------ELABORADOS------------------------------------------

	public void grabarElaborado(ElaboradoDTO elab)throws  ElaboradoException {
		// TODO Auto-generated method stub
		try {
			remoteObject.grabarElaborado(elab);
		} catch (ElaboradoException e) {
			throw new ElaboradoException("No se pueden GRABAR los ELABORADOS!");
		}
	}
	
	public ElaboradoDTO getElaboradoByCod(int parseInt) throws  ElaboradoException{
		// TODO Auto-generated method stub
		try {
			return remoteObject.getElaboradoByCod(parseInt);
		} catch (ElaboradoException e) {
			throw new ElaboradoException("No se pueden obtener el elaborado!");
		}
	}

	public void actualizarElaborado(ElaboradoDTO elab) throws  ElaboradoException{
		// TODO Auto-generated method stub
		 try {
			remoteObject.actualizarElaborado(elab);
		} catch (ElaboradoException e) {
			throw new ElaboradoException("No se puede ACTUALIZAR el ELABORADO!");
		}
	}

	


	

	

	
}
