package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.*;
import dao.ComandaDAO;
import dao.PlatoDAO;
import entities.*;
import enumns.AreaRest;
import enumns.Estado;
import enumns.MedioDePago;
import enumns.Temporada;
import hibernate.HibernateUtil;
import negocio.Deposito;

public class testHibernate {

	//----------------------->Hagan sus pruebas relacionadas a HIBERNATE aqui <-----------------------------
	public static void main(String[] args) 
	{
		
		
		
		//aca van pruebas de DB
		UnidadEntity ue = new UnidadEntity("gramos");
		
		Date fecha = new Date("10/10/2020");
		
		
		MateriaPrimaEntity materia = new MateriaPrimaEntity("PapasAlDeposito",ue, 1000f);
		List<MateriaPrimaEntity> materiapedido = new ArrayList<MateriaPrimaEntity>();
		materiapedido.add(materia);
	
		List<ItemRemitoEntity> itemsremito = new ArrayList<ItemRemitoEntity>();
		ItemRemitoEntity itemremito = new ItemRemitoEntity(1);
		itemsremito.add(itemremito);
		RemitoEntity remito = new RemitoEntity(1,fecha,itemsremito);
		itemremito.setRemito(remito);
		
		List<RemitoEntity> remitos = new ArrayList<RemitoEntity>();
		remitos.add(remito);
		
		List<SolicitudInsumoEntity> solicitudes = new ArrayList<SolicitudInsumoEntity>();
	
		
		
		DepositoEntity deposito = new DepositoEntity(materiapedido,solicitudes,remitos);
		
		remito.setDeposito(deposito);
		
		LocalEntity local=new LocalEntity("Sucre 123", "Belgrano", deposito);
		
		SalonEntity salon=new SalonEntity(1,AreaRest.salon, "Salon",local);
	
		CajaEntity caja=new CajaEntity(2,AreaRest.Caja,salon,local);
			
		SectorEntity sector = new SectorEntity("Sector", salon);
		List<SectorEntity> sectores = new ArrayList<SectorEntity>();
		sectores.add(sector);
		
		SolicitudInsumoEntity solicitud = new SolicitudInsumoEntity(100,materia,caja,"Responsable",1,fecha,fecha,"Motivo");
		
		materia.setDeposito(deposito);
		solicitud.setDeposito(deposito);
		
		solicitudes.add(solicitud);
			
		List<PlanDeProduccionEntity> planes= new ArrayList<PlanDeProduccionEntity>();
		AdministracionEntity admi= new AdministracionEntity(5, AreaRest.Administracion, planes, local);
		PlanDeProduccionEntity pdp = new PlanDeProduccionEntity(Estado.EnProceso);
		pdp.setAdministracion(admi);
		planes.add(pdp);
	
		MateriaPrimaEntity mpe = new MateriaPrimaEntity("Papas",ue, 1000f);
		mpe.setDeposito(deposito);
		List<MateriaPrimaEntity> materiales = new ArrayList<MateriaPrimaEntity>();
		materiales.add(mpe);
			
		SemiElaboradoEntity see = new SemiElaboradoEntity("Tipo","Calidad","Descripcion",pdp,1,fecha,materiales,ue);
		
		List<SemiElaboradoEntity> componentes = new ArrayList<SemiElaboradoEntity>();
		componentes.add(see);
		
		ElaboradoEntity ee = new ElaboradoEntity("Tipo","Calidad","Pizza",pdp,1,fecha, ue, componentes);
		
		
		List<ElaboradoEntity> elabs = new ArrayList<ElaboradoEntity>();
		elabs.add(ee);
		
		PlatoEntity plato = new PlatoEntity("Plato",13f,elabs);
			
		MozoEntity mozo = new MozoEntity(31575032,"Nahuelito","Grisoluble",80.4f, sector);
		
		List<MozoEntity> mocitos = new ArrayList<MozoEntity>();
		mocitos.add(mozo);
	
		MesaEntity mesita = new MesaEntity(0,15,0,mozo,sector);
		
		List<MesaEntity> mesitas = new ArrayList<MesaEntity>();
		mesitas.add(mesita);
				
		ComandaEntity comandita = new ComandaEntity(mozo, mesita,caja,Estado.Terminado);
		ComandaEntity comandita2 = new ComandaEntity(mozo, mesita,caja,Estado.EnProceso);
		ComandaEntity comandita3 = new ComandaEntity(mozo, mesita,caja,Estado.EnProceso);
		ItemComandaEntity itemCom2= new ItemComandaEntity(2, plato, comandita2);
		ItemComandaEntity itemCom3= new ItemComandaEntity(5, plato, comandita3);
		ItemComandaEntity itemCom= new ItemComandaEntity(2, plato, comandita);
		
		List<ComandaEntity> comanditas = new ArrayList<ComandaEntity>();
		comanditas.add(comandita);
		comanditas.add(comandita2);
		comanditas.add(comandita3);
		
		FacturaEntity factura= new FacturaEntity(fecha, 40.4f, MedioDePago.Contado, mesita, mozo,caja);
				
		ItemFacturaEntity itemfacturita = new ItemFacturaEntity(itemCom,factura);
		
				
		Temporada temp = null;
		List<PlatoEntity> itemCarta= new ArrayList<PlatoEntity>();
		itemCarta.add(plato);
		CartaEntity carta = new CartaEntity(fecha,temp.Primavera,itemCarta);
		plato.setCarta(carta);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*NO BORRAR ESTE ORDEN DE GUARDADO*/
		
		session.save(deposito);
		session.save(remito);
		session.save(solicitud);
		session.save(materia);
		
		session.save(local);
		session.save(salon);
		session.save(sector);
		session.save(admi);
		session.save(mozo);
		session.save(plato);
		session.save(carta);
		session.save(mesita);
		session.save(itemCom);
		session.save(itemCom2);
		
		session.save(comandita);
		session.save(comandita2);
		session.save(itemCom3);
		session.save(comandita3);
		session.save(factura);
		
		/*NO BORRAR ESTE ORDEN DE GUARDADO*/
		
		session.getTransaction().commit();
		session.close();
		
		//aca terminan pruebas de DB
		
		

		
		/* //TEST  DAO COMANDA - BUSCAR COMANDA POR CODIGO   --FUNCIONA
		ComandaEntity resultado =new ComandaEntity();
		resultado = ComandaDAO.getInstance().obtenerComanda(1); //FUNCIONA DAO obtener comanda
		System.out.println("HOLA "+resultado.getCaja().getCodArea());*/
		
		//TEST DAO COMANDAS ACTIVAS POR MESA MESA --FUNCIONA
		List <ComandaEntity> resultados =new ArrayList<ComandaEntity>();
		int codigomesaelegida=1;
		resultados=ComandaDAO.getInstance().obtenerComandasAbiertasxMesa(codigomesaelegida); //Busco comandas abiertas de la mesa 1
		System.out.println(" MESA" +codigomesaelegida);
		for (ComandaEntity comanda:resultados)
		{  
			System.out.println("Codigo Comanda: "+comanda.getCodComanda());
			List <ItemComandaEntity> items =new ArrayList<ItemComandaEntity>();
			items=ItemComandaDAO.getInstance().obtenerItemComandasAbiertasxMesa(comanda.getCodComanda());
			for (ItemComandaEntity item:items)
			{
			System.out.println("Plato: "+item.getPlato().getNombre()+" y la cantidad es :"+item.getCantidad());
			}
		}
		//
		/*
		//TEST DAO OBTENER PLATO POR ID  --FUNCIONA
		PlatoEntity platoelegido=new PlatoEntity();
		platoelegido=PlatoDAO.getInstance().getPlatoPorId(8);
		System.out.println("EL PLATO BUSCADO ES: "+platoelegido.getNombre());
		
		// 
		
		*/
		
		
		
		/*--------------->----------->separador de bajo presupuesto<------------------<------------------------*/				  
		  /*
 	public List<DTO> funcion() throws RemoteException {
		// TODO Auto-generated method stub
		return manejoNegocio.getInstance().getUnidades();
	}
 
 	/*ABAJO SCRIPT PARA BORRAR TABLAS EN BASE DE DATOS,LO CORRES APUNTANDO A LA BASE Y LISTO*/	
		
		/*
		 * 
		 * 

	DECLARE @Sql NVARCHAR(500) DECLARE @Cursor CURSOR
	
	SET @Cursor = CURSOR FAST_FORWARD FOR
	SELECT DISTINCT sql = 'ALTER TABLE [' + tc2.TABLE_NAME + '] DROP [' + rc1.CONSTRAINT_NAME + ']'
	FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS rc1
	LEFT JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc2 ON tc2.CONSTRAINT_NAME =rc1.CONSTRAINT_NAME
	
	OPEN @Cursor FETCH NEXT FROM @Cursor INTO @Sql
	
	WHILE (@@FETCH_STATUS = 0)
	BEGIN
	Exec sp_executesql @Sql
	FETCH NEXT FROM @Cursor INTO @Sql
	END
	
	CLOSE @Cursor DEALLOCATE @Cursor
	GO
	
	EXEC sp_MSforeachtable 'DROP TABLE ?'
	GO
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		/*--------------->----------->separador de bajo presupuesto<------------------<------------------------*/				
	}

}
