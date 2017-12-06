package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

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
import exceptions.SalonException;
import exceptions.SectorException;
import exceptions.SolicitudException;
import exceptions.UnidadException;
import exceptions.UsuarioException;
import exceptions.itemComandaException;
import exceptions.itemPlanDeProduccionException;
import exceptions.itemRemitoException;
import exceptions.SemiElaboradoException;







public interface manejoNegocio extends Remote 
{

	//USUARIO
	public boolean verificarPassword(String login, String password) throws UsuarioException;
	public void guardarUsuarios(UsuariosDTO usuario)throws UsuarioException;
	public UsuariosDTO buscarUserPorLogin(String login) throws UsuarioException;
	public void borrarUsuario (UsuariosDTO usuario) throws UsuarioException;
	
	//PLATO
	public List<PlatoDTO> listarPlatos() throws  PlatoException;
	public List<PlatoDTO> buscarPlatosParecidos(String nombre, CategoriaPlato categoriaplato) throws  PlatoException;
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws  PlatoException;
	
	//COMANDA
	public void grabarComanda(ComandaDTO comanda) throws ComandaException;
	public List<ComandaDTO> mostrarComandas()throws ComandaException;
	public ComandaDTO BuscarComandasPorCod(Integer codComanda)throws ComandaException;
	
	 
	//ITEMCOMANDA
	public boolean grabarItemComanda(ItemComandaDTO itemComanda) throws itemComandaException;
	public void itemComandaLista(int coditemcomanda) throws  itemComandaException;
	
	//FACTURA
	public  void grabarFactura(FacturaDTO factura) throws FacturaException;
	public List<FacturaDTO> mostrarFacturas()throws FacturaException;
	public FacturaDTO mostrarFacturaByCod(int nroFact)throws FacturaException;
	public void facturarMesa(int codMesa, MedioDePago formadepago) throws  FacturaException;
	
	//ITEMFACTURA
	List<ItemFacturaDTO> obtenerItemsFacturaByCodFactura(Integer codFactura) throws  FacturaException;
	
	//RESERVA
	public void grabarReserva(ReservaDTO reserva) throws ReservaException;
	public List<ReservaDTO> mostrarReservas()throws ReservaException;
	
	//MOZOS
	public List<MozoDTO> mostrarMozos() throws MozoException; 
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws  MozoException;
	public List<String[]> mostrarResultadoComisionesMozo (Date FechaDesde,Date FechaHasta)throws  MozoException;
	
	//MESAS 
	public List<MesaDTO> mostrarMesas() throws MesaException;
	public MesaDTO BuscarMesaPorCod(Integer codMesa)throws MesaException;
	public List<MesaDTO> mostrarMesasLibres()throws MesaException;
	public void ocuparMesaPorCod(Integer codMesa)throws MesaException;
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws  MesaException;
	public void grabarMesa(MesaDTO mesa)throws  MesaException;
	public List<MesaDTO> mostrarMesasOcupadas() throws  MesaException;
	public List<MesaDTO> mostrarMesasFacturables() throws  MesaException;
	
	//SECTORES
	public List<SectorDTO> mostrarSectores() throws SectorException;
	
	//SALONES
	public List<SalonDTO> mostrarSalones() throws SalonException;
	
	//DEPOSITOS
	public List<DepositoDTO> mostrarDepositos() throws DepositoException;
	public DepositoDTO DepositoByCod(Integer codDeposito) throws RemoteException;
	
	
	//FACTURACION CAJA
	public double mostrarTotalFacturadoCaja (Date FechaDesde,Date FechaHasta)throws CajaException;
	

	//UNIDAD
	public List<UnidadDTO> mostrarUnidades() throws  UnidadException;
	public UnidadDTO UnidadByDescp(String descp) throws UnidadException;

	//MATERIA PRIMA
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws MateriaPrimaException;
	public List<MateriaPrimaDTO> listarStock() throws MateriaPrimaException;
	public MateriaPrimaDTO getMateriaPrimaByCod(Integer codMaterial) throws MateriaPrimaException;
	public void actualizarMaterial(MateriaPrimaDTO materia) throws  MateriaPrimaException;
	public void eliminarMateria(MateriaPrimaDTO materia) throws  MateriaPrimaException;
	
	//ITEMS COMANDA
	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws itemComandaException;

	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws itemComandaException;

	//CARTA
	public CartaDTO buscarCartaPorCod(int nrocarta) throws CartaException;
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta)throws CartaException;
	public List<CartaDTO> mostrarCartas()throws CartaException;
	
	//PLAN DE PRODUCCION
	public List<PlanDeProduccionDTO> mostrarPDPs() throws PlanDeProduccionException;
	public PlanDeProduccionDTO obtenerPDPByCodPDP(int codPdp)throws PlanDeProduccionException;
	public void grabarPdP(PlanDeProduccionDTO pdp) throws PlanDeProduccionException;
	
	//ITEM PLAN DE PRODUCCION
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)throws itemPlanDeProduccionException;
	public void grabarItemPdP(ItemPlanProduccionDTO itemPdP) throws itemPlanDeProduccionException;

	
	//REMITO
	public void grabarRemito(RemitoDTO remito) throws RemitoException;
	public List<RemitoDTO> mostrarRemitos()throws RemitoException;
	public RemitoDTO getRemitoByCod(Integer parseInt) throws RemitoException;
	
	//ITEM REMITO
	public void grabarItemRemito(ItemRemitoDTO itemRemito) throws itemRemitoException;
	
	//SOLICITUD INDIVIDUAL
	public List<SolicitudIndividualDTO> mostrarSolicitudesIndividuales()throws SolicitudException;
	public List<SolicitudIndividualDTO> mostrarSolicitudesNoDiarias()	throws  SolicitudException;
	public void grabarSolicitudIndividual(SolicitudIndividualDTO solicitud)throws SolicitudException;
	public void unirSolicitudesIndividuales(List<CombinadorDTO> mandar) throws SolicitudException;
	
	//SOLI DIARIA
	public List<SolicitudDiariaDTO> mostrarSolicitudesDiarias() throws  SolicitudException;
	
	//SEMIS
	public List<SemiElaboradoDTO> mostrarSemiElaborados() throws  SemiElaboradoException;
	public SemiElaboradoDTO getSemiElaboradoByCod(int parseInt) throws  SemiElaboradoException;
	
	
	//ELABORADOS
	public void grabarElaborado(ElaboradoDTO elab) throws  ElaboradoException;
	public ElaboradoDTO getElaboradoByCod(int parseInt)throws  ElaboradoException;
	public void actualizarElaborado(ElaboradoDTO elab)throws  ElaboradoException;
	


	
}

