package inicio;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bd.BusinessDelegate;
import dto.AdministracionDTO;
import dto.CajaDTO;
import dto.CartaDTO;
import dto.ComandaDTO;
import dto.DepositoDTO;
import dto.ElaboradoDTO;
import dto.FacturaDTO;
import dto.IngredienteDTO;
import dto.ItemComandaDTO;
import dto.ItemFacturaDTO;
import dto.ItemRemitoDTO;
import dto.LocalDTO;
import dto.MateriaPrimaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlanDeProduccionDTO;
import dto.PlatoDTO;
import dto.RemitoDTO;
import dto.SalonDTO;
import dto.SectorDTO;
import dto.SemiElaboradoDTO;
import dto.SolicitudIndividualDTO;
import dto.UnidadDTO;
import enumns.AreaRest;
import enumns.CategoriaPlato;
import enumns.Estado;
import enumns.EstadoItemComanda;
import enumns.EstadoRemito;
import enumns.MedioDePago;
import enumns.Temporada;
import exceptions.ComandaException;
import exceptions.FacturaException;
import exceptions.PlatoException;
import exceptions.itemComandaException;


public class testCliente 
{
	public static void main (String args[]) 
	{
	
		UnidadDTO ue = new UnidadDTO("gramos");
		Date fecha = new Date("10/10/2020");
		DepositoDTO deposito=new DepositoDTO();
		deposito.setCodDeposito(1);
		
		//Materia Prima
		MateriaPrimaDTO materia = new MateriaPrimaDTO("PapasAlDeposito",ue, 1000f);
		List<MateriaPrimaDTO> materiapedido = new ArrayList<MateriaPrimaDTO>();
		materiapedido.add(materia);
	
		//Item Remito
		List<ItemRemitoDTO> itemsremito = new ArrayList<ItemRemitoDTO>();
		ItemRemitoDTO itemremito = new ItemRemitoDTO(1);
		itemsremito.add(itemremito);
		
		//REMITO
		RemitoDTO remito = new RemitoDTO(1,fecha,deposito,itemsremito,EstadoRemito.EnProceso);
	
		itemremito.setRemito(remito);
		List<RemitoDTO> remitos = new ArrayList<RemitoDTO>();
		remitos.add(remito);
		
		
		//SOLICITUD INSUMO
		List<SolicitudIndividualDTO> solicitudes = new ArrayList<SolicitudIndividualDTO>();
		remito.setDeposito(deposito);
		
		
		//Deposito
		//DepositoDTO deposito = new DepositoDTO(materiapedido,solicitudes,remitos);
		DepositoDTO depo = new DepositoDTO();
		remito.setDeposito(deposito);
		
		//LOCAL
		LocalDTO local=new LocalDTO(1,"Sucre 123", "Belgrano", depo);
		
		//SALON
		SalonDTO salon=new SalonDTO(2,AreaRest.salon, "Salon", local);
		//CAJA
		CajaDTO caja=new CajaDTO(2,AreaRest.Caja,salon, local);
		
		//AdministracionDTO admi= new AdministracionDTO(6, AreaRest.Administracion, planes, local);
		
		//SECTOR
		SectorDTO sector = new SectorDTO("Sector", salon);
		List<SectorDTO> sectores = new ArrayList<SectorDTO>();
		sectores.add(sector);
		
		materia.setDeposito(deposito);
		
		//PDP
		
		List<PlanDeProduccionDTO> planes= new ArrayList<PlanDeProduccionDTO>();
		AdministracionDTO admi= new AdministracionDTO(5, AreaRest.Administracion, planes, local);
		PlanDeProduccionDTO pdp = new PlanDeProduccionDTO(Estado.EnProceso);
		pdp.setAdministracion(admi);
		planes.add(pdp);
		
		//MATERIA PRIMA
		
		MateriaPrimaDTO mpe = new MateriaPrimaDTO("Papas",ue, 3000f);
		mpe.setDeposito(deposito);
		List<MateriaPrimaDTO> materiales = new ArrayList<MateriaPrimaDTO>();
		materiales.add(mpe);
		
		//SEMIELAB
		//(String tipo, String calidad, String descripcion,PlanDeProduccion pdp, Integer cantidad, Date caducidad, List<MateriaPrima> materiales,Unidad unidad) 
		//(String tipo, String calidad, String descripcion,PlanDeProduccionDTO pdp, Integer cantidad, Date caducidad, List<MateriaPrimaDTO> materiales,UnidadDTO unidad)
		SemiElaboradoDTO see = new SemiElaboradoDTO();
		SemiElaboradoDTO see2 = new SemiElaboradoDTO();
		
		//INGREDIENTE
		//Integer codigocomponente, MateriaPrimaDTO materiaprima, Integer cantidad,SemiElaboradoDTO platosemielaborado)
		IngredienteDTO ingrediente1=new IngredienteDTO (4,mpe,500,see);
		IngredienteDTO ingrediente2=new IngredienteDTO (5,mpe,700,see2);
		ingrediente1.setPlatosemielaborado(see);
		ingrediente2.setPlatosemielaborado(see2);
		
		
		List<SemiElaboradoDTO> componentes = new ArrayList<SemiElaboradoDTO>();
		componentes.add(see);
		componentes.add(see2);
		
		//ELABORADOS
		ElaboradoDTO ee = new ElaboradoDTO("Tipo","Calidad","Milanesa con Papas fritas",1,fecha, ue, componentes);
		List<ElaboradoDTO> elabs = new ArrayList<ElaboradoDTO>();
		elabs.add(ee);
		
		//PLATO
		PlatoDTO plato = new PlatoDTO("Bistec",30f,elabs,CategoriaPlato.Carnes,AreaRest.Cocina);
		
		//MOZO
		MozoDTO mozo = new MozoDTO(31604578,"Ceci","Zuki",80.4f, sector);
		List<MozoDTO> mocitos = new ArrayList<MozoDTO>();
		mocitos.add(mozo);
		//MozoDTO mozo, MesaDTO mesa,CajaDTO caja,Estado estado
		
		//MESA
		MesaDTO mesa= new MesaDTO(1,15,0,null, mozo,sector);
		
		ComandaDTO comanda=new ComandaDTO(mozo, mesa,Estado.EnProceso);
		
		
		//ITEM COMANDA
		ItemComandaDTO itemCom= new ItemComandaDTO(2, plato,EstadoItemComanda.Iniciada, comanda);
		List<ComandaDTO> comanditas = new ArrayList<ComandaDTO>();
		comanditas.add(comanda);
		
		//FACTURA
		FacturaDTO fact=new FacturaDTO(fecha,(float)1000,MedioDePago.Contado,mesa);
		//ITEMCFACTURA
		ItemFacturaDTO itemfacturita = new ItemFacturaDTO(itemCom,fact);
		
		//TEMPORADA
		Temporada temp = null;
		List<PlatoDTO> itemCarta= new ArrayList<PlatoDTO>();
		itemCarta.add(plato);
		
		//CARTA
		CartaDTO carta = new CartaDTO(fecha,temp.Primavera,itemCarta);
		plato.setCarta(carta);
		
		
		//HASTA ACA DECLARACION DE VARIABLES
		//ACA EMPIEZAN LOS LLAMADOS
		//GUARDAR COMANDA		
		/*try {
			BusinessDelegate.getInstance().grabarComanda(comanda);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ComandaException e) {
			e.printStackTrace();
		}*/
		///GUARDAR FACTURA
		try {
			BusinessDelegate.getInstance().grabarFactura(fact);
			System.out.println("Se guardo la factura");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FacturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//GRABAR ITEM COMANDA
		try {
			BusinessDelegate.getInstance().grabarItemComanda(itemCom);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (itemComandaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
