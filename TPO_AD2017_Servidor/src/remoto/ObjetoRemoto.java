package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controlador.Controlador;
import dao.MozoDAO;
import dto.CartaDTO;
import dto.ComandaDTO;
import dto.CombinadorDTO;
import dto.DepositoDTO;
import dto.ElaboradoDTO;
import dto.FacturaDTO;
import dto.ItemComandaDTO;
import dto.ItemFacturaDTO;
import dto.ItemPlanProduccionDTO;
import dto.ItemRemitoDTO;
import dto.MateriaPrimaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlanDeProduccionDTO;
import dto.PlatoDTO;
import dto.RemitoDTO;
import dto.ReservaDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import dto.SemiElaboradoDTO;
import dto.SolicitudDiariaDTO;
import dto.SolicitudIndividualDTO;
import dto.UnidadDTO;
import dto.UsuariosDTO;
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
import exceptions.SemiElaboradoException;
import exceptions.SalonException;
import exceptions.SectorException;
import exceptions.SolicitudException;
import exceptions.UnidadException;
import exceptions.UsuarioException;
import exceptions.itemComandaException;
import exceptions.itemPlanDeProduccionException;
import exceptions.itemRemitoException;
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
		public boolean verificarPassword(String login, String password) throws   UsuarioException 
		{
			return Controlador.getInstance().autenticarPassword(login, password);
		}
		
		
		@Override
		public void guardarUsuarios(UsuariosDTO usuario) throws   UsuarioException 
		{
			Controlador.getInstance().grabarUsuarios(usuario);
			
		}

		@Override
		public UsuariosDTO buscarUserPorLogin(String login) throws   UsuarioException {
			// TODO Auto-generated method stub
			return Controlador.getInstance().listarUserPorLogin(login);
		}

		@Override
		public void borrarUsuario(UsuariosDTO usuario) throws   UsuarioException {
			Controlador.getInstance().borrarUsuario(usuario);
			
		}
	//----------------------------PLATOS------------------------------------------------------------------------------
	@Override
	public List<PlatoDTO> listarPlatos() throws   PlatoException
	{
		return Controlador.getInstance().listarPlatos();
	}

	@Override
	public List<PlatoDTO> buscarPlatosParecidos(String nombre, CategoriaPlato categoriaplato)
			throws   PlatoException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().BuscarPlatosparecidos(nombre, categoriaplato);
	}

	@Override
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws   PlatoException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarPlatoPorCod(codPlato);
	}

	//----------------------------COMANDAS----------------------------------------------------------------------------
	public void grabarComanda(ComandaDTO comanda) throws   ComandaException 
	{
		Controlador.getInstance().guardarComanda(comanda);
		
	}

	@Override
	public List<ComandaDTO> mostrarComandas() throws   ComandaException 
	{
		
		return Controlador.getInstance().listarComandas();
	}
	
	@Override
	public ComandaDTO BuscarComandasPorCod(Integer codComanda) throws   ComandaException
	{
		return Controlador.getInstance().listarComandasPorCod(codComanda);
	}
	
	//--------------------------ITEM COMANDA--------------------------------------------------------------------------------
	@Override
	public boolean grabarItemComanda(ItemComandaDTO itemComanda) throws   itemComandaException 
	{
		return Controlador.getInstance().guardarItemComanda(itemComanda);
		
	}
	
	//Paso a listo el item comanda
	public void itemComandaLista(int coditemcomanda) throws   itemComandaException 
	{
		Controlador.getInstance().itemComandaLista(coditemcomanda);
	}
	
	//-----------------------------------ITEMS COMANDA POR AREA y POR COD COMANDA------------

	@Override
	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws itemComandaException {

		return Controlador.getInstance().getItemsPendientesxArea(area);
	}

	@Override
	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws itemComandaException {
		
		return Controlador.getInstance().obtenerItemsComandaByCodComanda(parseInt);
	}

	
	//--------------------------FACTURAS--------------------------------------------------------------------------------
	@Override
	public void grabarFactura(FacturaDTO factura) throws   FacturaException 
	{
		Controlador.getInstance().guardarFactura(factura);
		
	}

	@Override
	public List<FacturaDTO> mostrarFacturas() throws   FacturaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarFacturas();
	}

	@Override
	public FacturaDTO mostrarFacturaByCod(int nroFact) throws   FacturaException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarFacturaByCod(nroFact);
	}
	
	public List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws   FacturaException
	{
		return Controlador.getInstance().obtenerItemsFacturaByCodFactura(codFactura);
		
	}
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws   FacturaException
	{
		Controlador.getInstance().facturarMesa(codMesa, formadepago);
	}

	
	//-----------------------------------RESERVA-----------------------------------------------------------------------
	@Override
	public void grabarReserva(ReservaDTO reserva) throws   ReservaException
	{
		Controlador.getInstance().guardarReserva(reserva);
		
	}

	@Override
	public List<ReservaDTO> mostrarReservas() throws   ReservaException {
		return Controlador.getInstance().listarReservas();
	}
    //---------------------------------MOZOS--------------------------------------------------------------------------------
	@Override
	public List<MozoDTO> mostrarMozos() throws   MozoException {
		return Controlador.getInstance().listarMozos();
	}

	@Override
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws   MozoException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarComisionesAPagar(FechaDesde, FechaHasta);
	}

	@Override
	public List<String[]> mostrarResultadoComisionesMozo(Date FechaDesde,Date FechaHasta) throws   MozoException
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().ResultadoComisionesMozo(FechaDesde,FechaHasta);
	}
	
	//----------------------------------MESAS---------------------------------------------------------------------------------
	@Override
	public List<MesaDTO> mostrarMesas() throws   MesaException {
		return Controlador.getInstance().listarMesas();
	}

	@Override
	public MesaDTO BuscarMesaPorCod(Integer codMesa) throws   MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarMesaPorCod(codMesa);
	}
	
	@Override
	public List<MesaDTO> mostrarMesasLibres() throws   MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarMesasLibres();
	}
	@Override
	public List<MesaDTO> mostrarMesasOcupadas() throws   MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarMesasOcupadas();
	}
	@Override
	public List<MesaDTO> mostrarMesasFacturables() throws   MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarMesasFacturables();
	}
	
	public void ocuparMesaPorCod(Integer codMesa) throws   MesaException {
		// TODO Auto-generated method stub
		Controlador.getInstance().ocuparMesaPorCod(codMesa);
	}
	
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws   MesaException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().combinarMesasPorCod(codmesa1, codmesa2);
	}
	
	@Override
	public void grabarMesa(MesaDTO mesa) throws   MesaException 
	{
		Controlador.getInstance().guardarMesa(mesa);
		
	}
	
	//----------------------------------SECTORES---------------------------------------------------------------------------------
	@Override
	public List<SectorDTO> mostrarSectores() throws   SectorException 
	{

		return Controlador.getInstance().listarSectores();
	}

	//----------------------------------SALONES---------------------------------------------------------------------------------
	@Override
	public List<SalonDTO> mostrarSalones() throws   SalonException {
		return Controlador.getInstance().listarSalones();
	}

	//----------------------------------DEPOSITOS---------------------------------------------------------------------------------
	@Override
	public List<DepositoDTO> mostrarDepositos() throws   DepositoException
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
	public double mostrarTotalFacturadoCaja(Date FechaDesde, Date FechaHasta) throws   CajaException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarTotalFacturadoCaja(FechaDesde, FechaHasta);
	}

	//----------------------------------UNIDADES----------------------------------------------------------------------------
	@Override
	public List<UnidadDTO> mostrarUnidades() throws   UnidadException
	{
		return Controlador.getInstance().listarUnidades();
		
		
	}

	@Override
	public UnidadDTO UnidadByDescp(String descp) throws  UnidadException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().UnidadByDescp(descp);
	}


	//-----------------------------------MATERIA PRIMA-----------------------------------------------------------------------
	@Override
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws MateriaPrimaException {
		Controlador.getInstance().grabarMateriaPrima(materia);
		
	}
	@Override
	public List<MateriaPrimaDTO> listarStock() throws MateriaPrimaException
	{
		return Controlador.getInstance().listarStock();
	}


	@Override
	public MateriaPrimaDTO getMateriaPrimaByCod(Integer codMaterial) throws   MateriaPrimaException
	{
		// TODO Auto-generated method stub
		return  Controlador.getInstance().listarMateriaPrimaByCod(codMaterial);
	}
	
	@Override
	public void actualizarMaterial(MateriaPrimaDTO materia) throws   MateriaPrimaException {
		// TODO Auto-generated method stub
		Controlador.getInstance().actualizarMateriaPrima(materia);
		
	}
	

	@Override
	public void eliminarMateria(MateriaPrimaDTO materia) throws   MateriaPrimaException {
		// TODO Auto-generated method stub
		Controlador.getInstance().eliminarMateria(materia);
	}

	//--------------------------------CARTA-------------------------------------------------
	@Override
	public CartaDTO buscarCartaPorCod(int nrocarta) throws   CartaException 
	{
		
		return Controlador.getInstance().listarCartaPorCod(nrocarta);
	}

	@Override
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta) throws   CartaException 
	{
		return Controlador.getInstance().listarPlatosporCodCarta(nrocarta);
	}

	@Override
	public List<CartaDTO> mostrarCartas() throws   CartaException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarCartas();
	}

	//--------------------------------PLAN DE PRODUCCION------------------------------------------------
	@Override
	public List<PlanDeProduccionDTO> mostrarPDPs() throws   PlanDeProduccionException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarPlanesProduccion();
	}

	@Override
	public PlanDeProduccionDTO obtenerPDPByCodPDP(int codPdp) throws   PlanDeProduccionException
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarPlanByCod(codPdp);
	}

	@Override
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)
			throws   itemPlanDeProduccionException {
		// TODO Auto-generated method stub listarItemPlanPorCodPlan
		return Controlador.getInstance().listarItemPlanPorCodPlan(nroPlanDeProduccion);
	}
	
	@Override
	public void grabarPdP(PlanDeProduccionDTO pdp) throws   PlanDeProduccionException {
		Controlador.getInstance().grabarPdP(pdp);
		
	}

	@Override
	public void grabarItemPdP(ItemPlanProduccionDTO itemPdP) throws   itemPlanDeProduccionException {
		Controlador.getInstance().grabarItemPdP(itemPdP);
		
	}
	
	//--------------------------------REMITO------------------------------------------------
	//REMITO
	@Override
	public void grabarRemito(RemitoDTO remito) throws   RemitoException {
		Controlador.getInstance().guardarRemito(remito);
		
	}

	@Override
	public List<RemitoDTO> mostrarRemitos() throws   RemitoException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarRemitos();
	}

	
	
	public RemitoDTO getRemitoByCod(Integer parseInt) throws   RemitoException {
		
		return Controlador.getInstance().getRemitoByCod(parseInt);
	}

	//-------------------------------ITEM REMITO---------------------------------------------------------
	//ITEM REMITO
	@Override
	public void grabarItemRemito(ItemRemitoDTO itemRemito) throws   itemRemitoException 
	{
		Controlador.getInstance().guardarItemRemito(itemRemito);
	}

	
	//-------------------------------SOLICITUDES----------------------------------------------------------
	//MOSTRAR
	@Override
	public List<SolicitudIndividualDTO> mostrarSolicitudesIndividuales() throws   SolicitudException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarSolicitudesIndividuales();
	}
	public List<SolicitudIndividualDTO> mostrarSolicitudesNoDiarias()	throws   SolicitudException 
	{
		// TODO Auto-generated method stub
		return Controlador.getInstance().listarSolicitudesNoDiarias();
	}

	@Override
	public void grabarSolicitudIndividual(SolicitudIndividualDTO solicitud) throws   SolicitudException 
	{
		Controlador.getInstance().guardarSolicitudIndividual(solicitud);
		
	}

	@Override
	public void unirSolicitudesIndividuales(List<CombinadorDTO> resultado) throws   SolicitudException {
		Controlador.getInstance().UnirSolicitudesIndividuales(resultado);
		
	}
	
	@Override
	public List<SolicitudDiariaDTO> mostrarSolicitudesDiarias() throws   SolicitudException {
		return Controlador.getInstance().listarSolicitudesDiarias();
	}


	//-------------------------------SEMIS----------------------------------------------------------
	
	@Override
	public List<SemiElaboradoDTO> mostrarSemiElaborados() throws   SemiElaboradoException{
		return Controlador.getInstance().mostrarSemiElaborados();
	}

	@Override
	public SemiElaboradoDTO getSemiElaboradoByCod(int parseInt) throws   SemiElaboradoException {
		return Controlador.getInstance().getSemiElaboradoByCod(parseInt);
	}

	
	//-------------------------------ELABORADOS-----------------------------------------------------------
	@Override
	public void grabarElaborado(ElaboradoDTO elab) throws ElaboradoException  {
		// TODO Auto-generated method stub
		Controlador.getInstance().grabarElaborado(elab);
	}

	@Override
	public ElaboradoDTO getElaboradoByCod(int parseInt) throws   ElaboradoException {
		// TODO Auto-generated method stub
		return Controlador.getInstance().getElaboradoByCod(parseInt);
	}

	@Override
	public void actualizarElaborado(ElaboradoDTO elab) throws   ElaboradoException {
		// TODO Auto-generated method stub
		Controlador.getInstance().actualizarElaborado(elab);
	}


	


	

	

	


	

	
	
	
	
}
