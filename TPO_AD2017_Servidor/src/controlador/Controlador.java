package controlador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.classic.Session;

import com.sun.corba.se.spi.protocol.CorbaMessageMediator;

import dao.CajaDAO;
import dao.ComandaDAO;
import dao.MesaDAO;
import dao.MozoDAO;
import dao.PlatoDAO;
import dao.ReservaDAO;
import dao.SectorDAO;
import dto.ComandaDTO;
import dto.FacturaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SectorDTO;
import entities.SectorEntity;
import enumns.Estado;
import enumns.MedioDePago;
import negocio.Caja;
import negocio.Comanda;
import negocio.Factura;
import negocio.Mesa;
import negocio.Mozo;
import negocio.Plato;
import negocio.Reserva;
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
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	//FACTURAS
	public  void guardarFactura(FacturaDTO factura) 
	{
		Integer codMesa=factura.getMesa().getCodMesa();
		Mesa mesa=MesaDAO.getInstance().getMesaN(codMesa);
		Integer codMozo=factura.getMozo().getDni();
		Mozo mozo=MozoDAO.getInstancia().getMozosByCod(codMozo); //FM: Saque la CAJA
		//(Date fecha, double importe,MedioDePago medioPago, Mesa mesa, Mozo mozo,Caja caja)
		new Factura(factura.getFecha(),factura.getImporte(),factura.getMedioPago(),mesa,mozo).save();
		
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
	//LISTAR MESAS
	public List<MesaDTO> listarMesas() 
	{
		List<MesaDTO> mesas=new ArrayList<>();
		List<Mesa> listaM=MesaDAO.getInstance().getMesas();
		for(Mesa m:listaM) 
		{
			mesas.add(m.toDTO());
		}
		return mesas;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------
    //LISTAR SECTORES
	
	public List<SectorDTO> listarSectores()
	{
		List<SectorDTO> sectores=new ArrayList<>();
		List<Sector> listaS=SectorDAO.getInstancia().getSectores();
		for(Sector s:listaS)
		{
			sectores.add(s.toDTO());
		}
		return sectores;
	}
}
