package inicio;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import bd.BusinessDelegate;
import dto.ComandaDTO;
import dto.PlatoDTO;
import exceptions.ComandaException;
import exceptions.PlatoException;

public class testCliente 
{
	public static void main (String args[]) 
	{
		//System.out.print("ENTRA");
		try {
			
				List<PlatoDTO> listaPlatos = BusinessDelegate.getInstance().listarPlatos();
				for(PlatoDTO p:listaPlatos) 
				{
					//System.out.println(p.getNombre());
					System.out.print(p.toString());
				}
				
				
				//Guardar Comanda
				ComandaDTO comanda=new ComandaDTO(); //me faltan los parametros
				try {
					BusinessDelegate.getInstance().grabarComanda(comanda);
				} catch (ComandaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print("ENTRA");
	}
}
