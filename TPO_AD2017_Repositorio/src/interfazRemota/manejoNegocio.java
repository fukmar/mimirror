package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import dto.CartaDTO;
import dto.ComandaDTO;
import dto.DepositoDTO;
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







public interface manejoNegocio extends Remote 
{

	//USUARIO
	public boolean verificarPassword(String login, String password) throws RemoteException,UsuarioException;
	public void guardarUsuarios(UsuariosDTO usuario)throws RemoteException,UsuarioException;
	public UsuariosDTO buscarUserPorLogin(String login) throws RemoteException,UsuarioException;
	public void borrarUsuario (UsuariosDTO usuario) throws RemoteException,UsuarioException;
	
	//PLATO
	public List<PlatoDTO> listarPlatos() throws RemoteException, PlatoException;
	public List<PlatoDTO> buscarPlatosParecidos(String nombre, CategoriaPlato categoriaplato) throws RemoteException, PlatoException;
	public PlatoDTO BuscarPlatoPorCod(Integer codPlato) throws RemoteException, PlatoException;
	
	//COMANDA
	public void grabarComanda(ComandaDTO comanda) throws RemoteException,ComandaException;
	public List<ComandaDTO> mostrarComandas()throws RemoteException,ComandaException;
	public ComandaDTO BuscarComandasPorCod(Integer codComanda)throws RemoteException,ComandaException;
	
	 
	//ITEMCOMANDA
	public boolean grabarItemComanda(ItemComandaDTO itemComanda) throws RemoteException,itemComandaException;
	public void itemComandaLista(int coditemcomanda) throws RemoteException, itemComandaException;
	
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
	public double mostrarComisionesAPagar(Date FechaDesde, Date FechaHasta) throws RemoteException, MozoException;
	public List<String[]> mostrarResultadoComisionesMozo (Date FechaDesde,Date FechaHasta)throws RemoteException, MozoException;
	
	//MESAS 
	public List<MesaDTO> mostrarMesas() throws RemoteException,MesaException;
	public MesaDTO BuscarMesaPorCod(Integer codMesa)throws RemoteException,MesaException;
	public List<MesaDTO> mostrarMesasLibres()throws RemoteException,MesaException;
	public void ocuparMesaPorCod(Integer codMesa)throws RemoteException,MesaException;
	public Integer combinarMesasPorCod(Integer codmesa1, Integer codmesa2) throws RemoteException, MesaException;
	public void grabarMesa(MesaDTO mesa)throws RemoteException, MesaException;
	
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
	public UnidadDTO UnidadByDescp(String descp) throws RemoteException,UnidadException;

	//MATERIA PRIMA
	public void grabarMateriaPrima(MateriaPrimaDTO materia) throws RemoteException,MateriaPrimaException;
	public List<MateriaPrimaDTO> listarStock() throws RemoteException,MateriaPrimaException;
	public MateriaPrimaDTO getMateriaPrimaByCod(Integer codMaterial) throws RemoteException,MateriaPrimaException;
	
	//ITEMS COMANDA
	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) throws RemoteException,itemComandaException;

	public List<ItemComandaDTO> obtenerItemsComandaByCodComanda(int parseInt) throws RemoteException,itemComandaException;

	//CARTA
	public CartaDTO buscarCartaPorCod(int nrocarta) throws RemoteException,CartaException;
	public List<PlatoDTO> obtenerPlatosByCodCarta(int nrocarta)throws RemoteException,CartaException;
	public List<CartaDTO> mostrarCartas()throws RemoteException,CartaException;
	
	//PLAN DE PRODUCCION
	public List<PlanDeProduccionDTO> mostrarPDPs() throws RemoteException,PlanDeProduccionException;
	public PlanDeProduccionDTO obtenerPDPByCodPDP(int codPdp)throws RemoteException,PlanDeProduccionException;
	
	//ITEM PLAN DE PRODUCCION
	public List<ItemPlanProduccionDTO> obtenerItemPDPByCodPDP(int nroPlanDeProduccion)throws RemoteException,itemPlanDeProduccionException;
	
	//REMITO
	public void grabarRemito(RemitoDTO remito) throws RemoteException,RemitoException;
	public List<RemitoDTO> mostrarRemitos()throws RemoteException,RemitoException;
	public RemitoDTO getRemitoByCod(Integer parseInt) throws RemoteException,RemitoException;
	
	//ITEM REMITO
	public void grabarItemRemito(ItemRemitoDTO itemRemito) throws RemoteException,itemRemitoException;
	
	//SOLICITUD INDIVIDUAL
	public List<SolicitudIndividualDTO> mostrarSolicitudesIndividuales()throws RemoteException,SolicitudException;
	public void grabarSolicitudIndividual(SolicitudIndividualDTO solicitud)throws RemoteException,SolicitudException;
	
}

