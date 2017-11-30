package controlador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.classic.Session;

import com.sun.corba.se.spi.protocol.CorbaMessageMediator;

import dao.CajaDAO;
import dao.ComandaDAO;
import dao.DepositoDAO;
import dao.FacturaDAO;
import dao.ItemComandaDAO;
import dao.MesaDAO;
import dao.MozoDAO;
import dao.PlatoDAO;
import dao.ReservaDAO;
import dao.SalonDAO;
import dao.SectorDAO;
import dao.UnidadDAO;
import dao.UsuariosDAO;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
import dto.ItemComandaDTO;
import dto.MateriaPrimaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import dto.UnidadDTO;
import entities.PlatoEntity;
import entities.SectorEntity;
import enumns.AreaRest;
import enumns.Estado;
import enumns.MedioDePago;
import negocio.Caja;
import negocio.Comanda;
import negocio.Deposito;
import negocio.Factura;
import negocio.ItemComanda;
import negocio.MateriaPrima;
import negocio.Mesa;
import negocio.Mozo;
import negocio.Plato;
import negocio.Reserva;
import negocio.Salon;
import negocio.Sector;
import negocio.Unidad;


public class Controlador {
	
	private static Controlador instancia; 
	
	public static Controlador getInstance(){
		if (instancia == null)
		return instancia = new Controlador();
		else
		return instancia;
	}
	
/*	public List<View> funcion() {
		List<UnidadView> uv = new ArrayList<UnidadView>();
		List<Unidad> unidades = UnidadDAO.getInstance().getAll();
		for(Unidad u : unidades)
			uv.add(u.toView());
		return uv;
	}*/
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------
		//USUARIOS
		
		
	public boolean autenticarPassword(String login, String password) 
	{
			boolean resu = false;
			resu=UsuariosDAO.getInstance().validarPassword(login, password);
			return resu;
	}
	//----------------------------------------------------------------------------------------------------------------------------------------
	//PLATOS
	public List<PlatoDTO> listarPlatos()
	{
		//aca hay que llamar al DAO, el DAO me devuelve un obje de negocio
		//El obj de negocio hay que pasarlo a DTO
		//este metodo devuelve un DTO
		List<PlatoDTO> listaDTO=new ArrayList<PlatoDTO>();
		List <Plato> listaN=PlatoDAO.getInstance().getPlatos();
		for(Plato p: listaN) 
		{
			listaDTO.add(p.toDTO());
		}
		return listaDTO;
		
	}
	
	public List<PlatoDTO> BuscarPlatosparecidos(String nombre, String categoriaplato)
	{
		List<Plato> platosN=PlatoDAO.getInstance().getPlatosparecidos(nombre, categoriaplato);
		List<PlatoDTO> platosp=new ArrayList<PlatoDTO>();
		for(Plato p:platosN) 
		{
			platosp.add(p.toDTO());
		}
		return platosp;
	}
	
	public PlatoDTO listarPlatoPorCod(Integer codPlato) 
	{
		Plato platoN=PlatoDAO.getInstance().getPlatoPorCod(codPlato);
		PlatoDTO plato=platoN.toDTO();
		return plato;
	}
	//----------------------------------------------------------------------------------------------------------------------------------
   //COMANDAS
	
	public void guardarComanda(ComandaDTO comanda) 
	{
		Integer codMozo=comanda.getMozo().getDni();
		Mozo mozo=MozoDAO.getInstancia().getMozosByCod(codMozo);
		Integer codMesa=comanda.getMesa().getCodMesa();
		Mesa mesa=MesaDAO.getInstance().getMesaN(codMesa);
		Estado estado=comanda.getEstado();
		new Comanda(mozo,mesa,estado).save();
	}
	
	
	public List<ComandaDTO> listarComandas()
	{
		List<ComandaDTO> listaCom=new ArrayList<ComandaDTO>();
		List<Comanda> listaComN=ComandaDAO.getInstance().getComandas();
		for(Comanda c:listaComN)
		{
			listaCom.add(c.toDTO());
			
		}
		return listaCom;
	}
	
	
	public ComandaDTO listarComandasPorCod(Integer codComanda)
	{
		ComandaDTO comanda=new ComandaDTO(); 
		Comanda comandaN=ComandaDAO.getInstance().obtenerComandaByCod(codComanda);
		comanda=comandaN.toDTO();
		return comanda;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	//ITEM COMANDA
	public void guardarItemComanda(ItemComandaDTO itemComanda) 
	{
		//(Integer cantidad, Plato plato,Comanda comanda
		Integer codPlato=itemComanda.getPlato().getCodigo();
		Plato plato=PlatoDAO.getInstance().getPlatoPorCod(codPlato);
		Integer codComanda=itemComanda.getComanda().getCodComanda();
		Comanda comanda=ComandaDAO.getInstance().obtenerComandaByCod(codComanda);
		new ItemComanda(itemComanda.getCantidad(),itemComanda.getEstado(), plato,comanda).save();
	}
	//-------------------------------------------------------------------------------------------------------------------------------------
	//FACTURAS
	public  void guardarFactura(FacturaDTO factura) 
	{
		System.out.println("LLEGA");
		Integer codMesa=factura.getMesa().getCodMesa();
		Mesa mesa=MesaDAO.getInstance().getMesaN(codMesa);
		new Factura(factura.getFecha(),factura.getImporte(),factura.getMedioPago(),mesa).save();
		
	} 
	
	public List<FacturaDTO> listarFacturas()
	{
		List<FacturaDTO> facturas=new ArrayList<FacturaDTO>();
		List<Factura> listaF=FacturaDAO.getInstance().getFacturas();
		for(Factura f:listaF) 
		{
			facturas.add(f.toDTO());
		}
		return facturas;
		
	}
	
	public FacturaDTO listarFacturaByCod(int nroFact)
	{
		FacturaDTO factura=new FacturaDTO();
		Factura facturaN=FacturaDAO.getInstance().obtenerFacturaByCod(nroFact);
		factura=facturaN.toDTO();
		return factura;
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------------
	//RESERVAS
	
	public void guardarReserva(ReservaDTO reserva)
	{
		new Reserva(reserva.getNombre(),reserva.getFechayHora(),reserva.getCantidadComensales()).save();
	}
	
	public List<ReservaDTO> listarReservas()
	{
		List<ReservaDTO> listaReservas=new ArrayList<ReservaDTO>();
		List<Reserva> reservaN=ReservaDAO.getInstancia().getReservas();
		for(Reserva r:reservaN) 
		{
			listaReservas.add(r.toDTO());
		}
		return listaReservas;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//MOZOS
	public List<MozoDTO> listarMozos()
	{
		List<MozoDTO> mozos=new ArrayList<MozoDTO>();
		List<Mozo> listaM=MozoDAO.getInstancia().getMozos();
		for(Mozo m:listaM) 
		{
			mozos.add(m.toDTO());
		}
		
		return mozos;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------
	// MESAS
	public List<MesaDTO> listarMesas() 
	{
		List<MesaDTO> mesas=new ArrayList<MesaDTO>();
		List<Mesa> listaM=MesaDAO.getInstance().getMesas();
		for(Mesa m:listaM) 
		{
			mesas.add(m.toDTO());
		}
		return mesas;
	}
	
	public MesaDTO listarMesaPorCod(Integer codMesa) 
	{
		MesaDTO mesa=new MesaDTO();
		Mesa mesaN=MesaDAO.getInstance().obtenerMesaPorCod(codMesa);
		mesa=mesaN.toDTO();
		return mesa;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------
    //LISTAR SECTORES
	
	public List<SectorDTO> listarSectores()
	{
		List<SectorDTO> sectores=new ArrayList<SectorDTO>();
		List<Sector> listaS=SectorDAO.getInstancia().getSectores();
		for(Sector s:listaS)
		{
			sectores.add(s.toDTO());
		}
		return sectores;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------
    //LISTAR SALONES
	
	public List<SalonDTO> listarSalones()
	{
		List<SalonDTO> salones=new ArrayList<SalonDTO>();
		List<Salon> listaS=SalonDAO.getInstancia().getSalones();
		for(Salon s:listaS)
		{
			salones.add(s.toDTO());
		}
		return salones;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------
    //LISTAR DEPOSITOS
	public List<DepositoDTO> listarDepositos()
	{
		List<DepositoDTO> depositos=new ArrayList<DepositoDTO>();
		List<Deposito> listaS=DepositoDAO.getInstancia().getDepositos();
		for(Deposito s:listaS)
		{
			depositos.add(s.toDTO());
		}
		return depositos;
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------
    //LISTAR FACTURADO EN CAJA
	public double listarTotalFacturadoCaja (Date FechaDesde,Date FechaHasta)
	{
		double importe=CajaDAO.getInstancia().getTotalFacturadoCaja(FechaDesde, FechaHasta);
		return importe;
	}
	
	//LISTAR TODAS LAS UNIDADES
	public List<UnidadDTO> listarUnidades() {
		// TODO Auto-generated method stub
		
		List<UnidadDTO> unidadesDTO=new ArrayList<UnidadDTO>();
		List<Unidad> unidadesCo=UnidadDAO.getInstance().getUnidades();
		
		for(Unidad uniCom:unidadesCo) {
			unidadesDTO.add(uniCom.toDTO());
		}
		return unidadesDTO;
	}
	
	//OBTENER UNIDAD POR DESCRIPCION
	public UnidadDTO UnidadByDescp(String descp) {
		// TODO Auto-generated method stub
		Unidad uni = UnidadDAO.getInstance().getUnidadByDescp(descp);
		UnidadDTO unidad =uni.toDTO();
		return unidad;
	}
	
	//GRABAR MATERIA PRIMA
	public void grabarMateriaPrima(MateriaPrimaDTO materia) {
		// TODO Auto-generated method stub
		Unidad uni= UnidadDAO.getInstance().getUnidadByDescp(materia.getUnidadUso().getDescripcion());
		Deposito depo= new Deposito();
		new MateriaPrima(materia.getDescripcion(), uni, materia.getCantidad(), depo).save();
		
	}

	//OBTENER DEPOSITO POR CODIGO
	public DepositoDTO DepositoByCod(Integer codDeposito) {
		// TODO Auto-generated method stub
		Deposito depo=DepositoDAO.getInstancia().getDepositoByCod(codDeposito);
		DepositoDTO deposito=depo.toDTO();
		return deposito;
	}

	//OBTENER ITEMS DE COMANDAS POR AREA
	public List<ItemComandaDTO> getItemsPendientesxArea(AreaRest area) {
		List<ItemComandaDTO> items=new ArrayList<ItemComandaDTO>();
		List<ItemComanda> itemsnegocio=ItemComandaDAO.getInstance().getItemsPendientesxArea(area);
		for(ItemComanda item:itemsnegocio)
		{
			items.add(item.toDTO());
		}
		return items;
	}
	
}
