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

public class testHibernate {

	//----------------------->Hagan sus pruebas relacionadas a HIBERNATE aqui <-----------------------------
	public static void main(String[] args) 
	{
		
		
		
		//aca van pruebas de DB
	
		LocalEntity local=new LocalEntity("Sucre 123", "Belgrano");
		
		SalonEntity salon=new SalonEntity(1,AreaRest.salon, "Salon",local);
		UnidadEntity ue = new UnidadEntity("gramos");
	
		SectorEntity sector = new SectorEntity("Sector", salon);
		List<SectorEntity> sectores = new ArrayList<SectorEntity>();
		sectores.add(sector);
		
		CajaEntity caja=new CajaEntity(2,AreaRest.Caja,salon,local);
		
		
		
		Estado est = null;
		List<PlanDeProduccionEntity> planes= new ArrayList<PlanDeProduccionEntity>();
		AdministracionEntity admi= new AdministracionEntity(5, AreaRest.Administracion, planes, local);
		PlanDeProduccionEntity pdp = new PlanDeProduccionEntity(Estado.EnProceso);
		pdp.setAdministracion(admi);
		planes.add(pdp);
	
		
		Date fecha = new Date("10/10/2020");
		
		MateriaPrimaEntity mpe = new MateriaPrimaEntity("Descripcion",ue);
	
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
				
		ComandaEntity comandita = new ComandaEntity(mozo, mesita,caja,"Activo");
		
		ItemComandaEntity itemCom= new ItemComandaEntity(2, plato, comandita);
		
		List<ComandaEntity> comanditas = new ArrayList<ComandaEntity>();
		comanditas.add(comandita);
		
		FacturaEntity factura= new FacturaEntity(fecha, 40.4f, MedioDePago.Contado, mesita, mozo,caja);
				
		ItemFacturaEntity itemfacturita = new ItemFacturaEntity(itemCom,factura);
		
		
		List<ItemRemitoEntity> itemsremito = new ArrayList<ItemRemitoEntity>();
		ItemRemitoEntity itemremito = new ItemRemitoEntity(1);
		itemsremito.add(itemremito);
		RemitoEntity remito = new RemitoEntity(1,fecha,itemsremito);
		itemremito.setRemito(remito);
		
			
		Temporada temp = null;
		List<PlatoEntity> itemCarta= new ArrayList<PlatoEntity>();
		itemCarta.add(plato);
		CartaEntity carta = new CartaEntity(fecha,temp.Primavera,itemCarta);
		plato.setCarta(carta);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(remito);
		session.save(admi);
		session.save(plato);
		session.save(carta);
		
		session.getTransaction().commit();
		session.close();
		
		//aca terminan pruebas de DB
		
		
/*
		
		//TEST  DAO COMANDA - BUSCAR COMANDA POR CODIGO   --FUNCIONA
		ComandaEntity resultado =new ComandaEntity();
		resultado = ComandaDAO.getInstance().obtenerComanda(1); //FUNCIONA DAO obtener comanda
		System.out.println("HOLA "+resultado.getCaja().getCodArea());
		
		//TEST DAO COMANDAS ACTIVAS POR MESA MESA --FUNCIONA
		List <ComandaEntity> resultados =new ArrayList<ComandaEntity>();
		resultados=ComandaDAO.getInstance().obtenerComandasAbiertasxMesa(1); //Busco comandas abiertas de la mesa 1
		for (ComandaEntity comanda:resultados)
		{  
			System.out.println("COMANDA ABIERTA de la MESA 1: " + comanda.getCodComanda());
		}
		//
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
