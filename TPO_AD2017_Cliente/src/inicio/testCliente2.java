package inicio;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import bd.BusinessDelegate;
import dto.ComandaDTO;
import dto.FacturaDTO;
import dto.ReservaDTO;
import enumns.MedioDePago;
import exceptions.ComandaException;
import exceptions.ReservaException;

public class testCliente2 {

	public static void main(String[] args) 
	{
		Date fecha = new Date("10/10/2020");
		ReservaDTO reserva=new ReservaDTO(1,"Ceci",fecha);
		try {
			BusinessDelegate.getInstance().grabarReserva(reserva);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	}

}
