package inicio;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bd.BusinessDelegate;
import dto.AdministracionDTO;
import dto.CajaDTO;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
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
import enumns.MedioDePago;
import exceptions.ComandaException;
import exceptions.FacturaException;
import exceptions.PlatoException;

public class testCliente 
{
	public static void main (String args[]) 
	{
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
		
		//AdministracionDTO admi= new AdministracionDTO(6, AreaRest.Administracion, planes, local);
		
		DepositoDTO deposito = new DepositoDTO(materiapedido,solicitudes,remitos);
		LocalDTO local=new LocalDTO(1,"Sucre 123", "Belgrano", deposito);
		
		SalonDTO salon=new SalonDTO(2,AreaRest.salon, "Salon", local);
		SectorDTO sector = new SectorDTO("Sector", salon);
		MozoDTO mozo = new MozoDTO(31575032,"Nahuelito","Grisoluble",80.4f, sector);
		//MozoDTO mozo, MesaDTO mesa,CajaDTO caja,Estado estado
		
		MesaDTO mesa= new MesaDTO(0,15,0,mozo,sector);
		
		ComandaDTO comanda=new ComandaDTO(mozo, mesa,Estado.EnProceso);
		
		//(Date fecha, float importe,MedioDePago medioPago, MesaDTO mesa, MozoDTO mozo,CajaDTO caja)
		CajaDTO caja=new CajaDTO(2,AreaRest.Caja,salon, local);
		FacturaDTO fact=new FacturaDTO(fecha,new Float(652),MedioDePago.Contado,mesa,mozo,caja);
		
		//HASTA ACA DECLARACION DE VARIABLES
		//ACA EMPIEZAN LOS LLAMADOS
		//LISTAR PLATOS
				List<PlatoDTO> listaPlatos;
				try {
					listaPlatos = BusinessDelegate.getInstance().listarPlatos();
					for(PlatoDTO p:listaPlatos) 
					{
						//System.out.println(p.getNombre());
						System.out.print(p.toString()  );
				
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PlatoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//GUARDAR COMANDA		
		try {
			BusinessDelegate.getInstance().grabarComanda(comanda);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ComandaException e) {
			e.printStackTrace();
		}
		///GUARDAR FACTURA
		try {
			BusinessDelegate.getInstance().grabarFactura(fact);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FacturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
