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
import dao.MesaDAO;
import dao.MozoDAO;
import dao.PlatoDAO;
import dao.ReservaDAO;
import dao.SalonDAO;
import dao.SectorDAO;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import entities.SectorEntity;
import enumns.Estado;
import enumns.MedioDePago;
import negocio.Caja;
import negocio.Comanda;
import negocio.Deposito;
import negocio.Factura;
import negocio.Mesa;
import negocio.Mozo;
import negocio.Plato;
import negocio.Reserva;
import negocio.Salon;
import negocio.Sector;


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
	
}
