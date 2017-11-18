package inicio;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bd.BusinessDelegate;
import dto.CajaDTO;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.ItemRemitoDTO;
import dto.LocalDTO;
import dto.MateriaPrimaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.RemitoDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import dto.SolicitudInsumoDTO;
import dto.UnidadDTO;
import enumns.AreaRest;
import enumns.Estado;
import exceptions.ComandaException;
import exceptions.PlatoException;

public class testCliente 
{
	public static void main (String args[]) 
	{
		//System.out.print("ENTRA");
		try {
			
			/*	List<PlatoDTO> listaPlatos = BusinessDelegate.getInstance().listarPlatos();
				for(PlatoDTO p:listaPlatos) 
				{
					//System.out.println(p.getNombre());
					System.out.print(p.toString());
				}*/
				
				
				//Guardar Comanda
				UnidadDTO ue = new UnidadDTO("gramos");
				Date fecha = new Date("10/10/2020");
				
				MateriaPrimaDTO materia = new MateriaPrimaDTO("PapasAlDeposito",ue, 1000f);
				List<MateriaPrimaDTO> materiapedido = new ArrayList<MateriaPrimaDTO>();
				materiapedido.add(materia);
			
				
				List<ItemRemitoDTO> itemsremito = new ArrayList<ItemRemitoDTO>();
				ItemRemitoDTO itemremito = new ItemRemitoDTO(1);
				itemsremito.add(itemremito);
				RemitoDTO remito = new RemitoDTO(1,fecha,itemsremito);
				itemremito.setRemito(remito);
				List<RemitoDTO> remitos = new ArrayList<RemitoDTO>();
				remitos.add(remito);
				
				List<SolicitudInsumoDTO> solicitudes = new ArrayList<SolicitudInsumoDTO>();
				
				
				
				DepositoDTO deposito = new DepositoDTO(materiapedido,solicitudes,remitos);
				LocalDTO local=new LocalDTO(1,"Sucre 123", "Belgrano", deposito);
				
				SalonDTO salon=new SalonDTO("Salon");
				SectorDTO sector = new SectorDTO("Sector", salon);
				MozoDTO mozo = new MozoDTO(31575032,"Nahuelito","Grisoluble",80.4f, sector);
				//MozoDTO mozo, MesaDTO mesa,CajaDTO caja,Estado estado
				
				MesaDTO mesa= new MesaDTO(0,15,0,mozo,sector);
				
				ComandaDTO comanda=new ComandaDTO(mozo, mesa,Estado.EnProceso);
				try {
					BusinessDelegate.getInstance().grabarComanda(comanda);
				} catch (ComandaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (/*Plato*/Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print("ENTRA");
	}
}
