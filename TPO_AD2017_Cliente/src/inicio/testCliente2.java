package inicio;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import bd.BusinessDelegate;
import dto.ComandaDTO;
import dto.FacturaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import enumns.CategoriaPlato;
import enumns.MedioDePago;
import exceptions.ComandaException;
import exceptions.FacturaException;
import exceptions.MozoException;
import exceptions.PlatoException;
import exceptions.ReservaException;

public class testCliente2 {

	public static void main(String[] args) 
	{
		Date fecha = new Date("10/10/2020");
		//GRABAR RESERVAS
		ReservaDTO reserva=new ReservaDTO("Ceci",fecha,8);
		try {
			BusinessDelegate.getInstance().grabarReserva(reserva);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//LISTAR RESERVAS
	 List<ReservaDTO> listaRes;
	try {
		listaRes = BusinessDelegate.getInstance().mostrarReservas();
		 for(ReservaDTO r:listaRes)
		 {
			 //System.out.println(r.getCodReserva()+r.getNombre()+r.getFechayHora());
			 System.out.println(r.toString());
		 }
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ReservaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//LISTAR COMANDAS
	List<ComandaDTO> listCom;
	try {
		listCom = BusinessDelegate.getInstance().mostrarComandas();
		for(ComandaDTO c:listCom) 
		{
			System.out.println(c.toString());
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ComandaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//LISTAR MOZOS
	try {
		List<MozoDTO> listaMozos=BusinessDelegate.getInstance().mostrarMozos();
		for(MozoDTO m:listaMozos)
		{
			System.out.println(m.toString());
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MozoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//LISTAR PLATOS
	List<PlatoDTO> listaPlatos;
	try {
		listaPlatos = BusinessDelegate.getInstance().listarPlatos();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (PlatoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//LISTAR FACTURAS
	try {
		List<FacturaDTO> listaFact=BusinessDelegate.getInstance().mostrarFacturas();
		for(FacturaDTO f: listaFact) 
		{
			System.out.println(f.toString());
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FacturaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//BUSCAR COMANDA POR NRO
	try {
		ComandaDTO comanda=BusinessDelegate.getInstance().BuscarComandasPorCod(1);
		System.out.println("La comanda buscada es: "+comanda.toString());
		} catch (RemoteException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		} catch (ComandaException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	
	//BUSCAR PLATO POR NRO
		try {
			PlatoDTO plato=BusinessDelegate.getInstance().BuscarPlatoPorCod(1);
			System.out.println("El plato buscado es: "+plato.toString());
			} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			} catch (PlatoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
	
	
	//SUGERIR PLATO
	try {
		List<PlatoDTO> platosS=BusinessDelegate.getInstance().BuscarPlatosparecidos("Milanesa con Papas Fritas","Carnes");
		for(PlatoDTO p:platosS)
		{
			System.out.println(p.toString());
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (PlatoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
