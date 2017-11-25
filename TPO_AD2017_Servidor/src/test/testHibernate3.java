package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bd.BusinessDelegate;
import controlador.Controlador;
import dao.*;
import dto.ComandaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import entities.*;
import enumns.AreaRest;
import enumns.Estado;
import enumns.EstadoItemRemito;
import enumns.MedioDePago;
import enumns.Temporada;
import hibernate.HibernateUtil;
import negocio.Comanda;
import negocio.Deposito;
import negocio.Elaborado;
import negocio.Factura;
import negocio.Ingrediente;
import negocio.Local;
import negocio.Mesa;
import negocio.Mozo;
import negocio.Plato;
import negocio.Salon;
import negocio.Sector;
import negocio.SemiElaborado;

public class testHibernate3 {

	//----------------------->Hagan sus pruebas relacionadas a HIBERNATE aqui <-----------------------------
	public static void main(String[] args) 
	{
		
		
		
		//aca van pruebas de DB
		UnidadEntity ue = new UnidadEntity("gramos");
		
		Date fecha = new Date("10/10/2020");
		
		
		MateriaPrimaEntity materia = new MateriaPrimaEntity("PapasAlDeposito",ue, 1000f);
		List<MateriaPrimaEntity> materiapedido = new ArrayList<MateriaPrimaEntity>();
		materiapedido.add(materia);

		
		
		
		//DepositoEntity deposito = new DepositoEntity(materiapedido,solicitudes,remitos);
		
		
	
		List<ItemRemitoEntity> itemsremito = new ArrayList<ItemRemitoEntity>();
		RemitoEntity remito = new RemitoEntity(1,fecha,itemsremito);
		
		
		List<RemitoEntity> remitos = new ArrayList<RemitoEntity>();
		remitos.add(remito);
		DepositoEntity deposito = new DepositoEntity();
		remito.setDeposito(deposito);
		
		LocalEntity local=new LocalEntity("Sucre 123", "Belgrano", deposito);
		SalonEntity salon=new SalonEntity(2,AreaRest.salon, "Salon",local);
		CajaEntity caja=new CajaEntity(2,AreaRest.Caja,salon,local);
			
		SectorEntity sector = new SectorEntity("Sector", salon);
		List<SectorEntity> sectores = new ArrayList<SectorEntity>();
		sectores.add(sector);
		
		materia.setDeposito(deposito);
		//solicitud.setDeposito(deposito);
		
		//solicitudes.add(solicitud);
			
		List<PlanDeProduccionEntity> planes= new ArrayList<PlanDeProduccionEntity>();
		AdministracionEntity admi= new AdministracionEntity(5, AreaRest.Administracion, planes, local);
		PlanDeProduccionEntity pdp = new PlanDeProduccionEntity(Estado.EnProceso);
		pdp.setAdministracion(admi);
		planes.add(pdp);
	
		MateriaPrimaEntity mpe = new MateriaPrimaEntity("Papas",ue, 3000f);
		mpe.setDeposito(deposito);
		List<MateriaPrimaEntity> materiales = new ArrayList<MateriaPrimaEntity>();
		materiales.add(mpe);
		ItemRemitoEntity itemremito = new ItemRemitoEntity(mpe,1,EstadoItemRemito.Procesado,null);
		itemremito.setRemito(remito);
		itemsremito.add(itemremito);
		SolicitudIndividualEntity solicitud = new SolicitudIndividualEntity(caja, "Jorge", 1, fecha, fecha, "faltante", mpe, null, 20);
		SemiElaboradoEntity see = new SemiElaboradoEntity("Guarnicion","Extrema","Papas Fritas",pdp,1,fecha,ue);
		SemiElaboradoEntity see2 = new SemiElaboradoEntity("Guarnicion","Extrema","Milanesa",pdp,1,fecha,ue);
		IngredienteEntity ingrediente1=new IngredienteEntity (mpe,500);
		IngredienteEntity ingrediente2=new IngredienteEntity (mpe,700);
		ingrediente1.setPlatosemielaborado(see);
		ingrediente2.setPlatosemielaborado(see2);
		List<SemiElaboradoEntity> componentes = new ArrayList<SemiElaboradoEntity>();
		componentes.add(see);
		componentes.add(see2);
		
		ElaboradoEntity ee = new ElaboradoEntity("Tipo","Calidad","Milanesa con Papas fritas",pdp,1,fecha, ue, componentes);
		
		
		List<ElaboradoEntity> elabs = new ArrayList<ElaboradoEntity>();
		elabs.add(ee);
		
		PlatoEntity plato = new PlatoEntity("Milanesa con Papas Fritas",13f,elabs);
			
		MozoEntity mozo = new MozoEntity(31575032,"Nahuelito","Grisoluble",5.4f, sector);
		
		List<MozoEntity> mocitos = new ArrayList<MozoEntity>();
		mocitos.add(mozo);
	
		MesaEntity mesita = new MesaEntity(0,15,0,mozo,sector);
		
		List<MesaEntity> mesitas = new ArrayList<MesaEntity>();
		mesitas.add(mesita);
				
		ComandaEntity comandita = new ComandaEntity(mozo, mesita/*,caja,*/,Estado.Terminado); //de aca solo comente caja porque tambien lo comente en el cosntuctor
		ComandaEntity comandita2 = new ComandaEntity(mozo, mesita/*,caja*/,Estado.EnProceso);
		ComandaEntity comandita3 = new ComandaEntity(mozo, mesita,/*caja,*/Estado.EnProceso);
		ItemComandaEntity itemCom2= new ItemComandaEntity(1, plato, comandita2);
		ItemComandaEntity itemCom3= new ItemComandaEntity(5, plato, comandita3);
		ItemComandaEntity itemCom= new ItemComandaEntity(2, plato, comandita);
		
		List<ComandaEntity> comanditas = new ArrayList<ComandaEntity>();
		comanditas.add(comandita);
		comanditas.add(comandita2);
		comanditas.add(comandita3);
		FacturaEntity factura2= new FacturaEntity(fecha, 20, MedioDePago.Contado, mesita);
		FacturaEntity factura= new FacturaEntity(fecha, 40.4f, MedioDePago.Contado, mesita);
		
		
				
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
		
		/*session.save(deposito);
		session.save(remito);
		session.save(solicitud);
		session.save(materia);
		
		//DSECOMENTAR PARA CREAR BASE
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
		sesion.save(factura2);
		session.save(factura);

		
		/*NO BORRAR ESTE ORDEN DE GUARDADO*/
		   
		session.save(admi);
		session.save(deposito);
		session.save(mesita);
		session.save(comandita2);
		session.save(itemCom);
		session.save(itemCom2);
		session.save(itemCom3);
		session.save(factura);
		session.save(solicitud);
		session.save(remito);
		//int idsector=mozo.getSector().getCodSector();
		
		//System.out.println(mozito.getNombre());
		//Mesa mesita10=MesaDAO.getInstance().getMesaN(comandita2.getMesa().getCodMesa());
		//Comanda comandanueva=new Comanda(mozito,mesita10,comandita2.getEstado());
		//ComandaDTO comandanuevaDTO=comandanueva.toDTO();
	//	Controlador.getInstance().guardarComanda(comandanuevaDTO);
		//Sector sector1=SectorDAO.getInstance().getSector(mozo.getSector().getCodSector());
		//System.out.println(sectorent.getDescripcion());
		//session.save(pdp);
		//session.save(ue);
	//	session.getTransaction().commit();
		
		session.save(see);
		session.save(see2);
		session.save(mpe);
		session.save(ingrediente1);
		session.save(ingrediente2);
		session.save(ee);
		session.save(plato);
		//session.save(ingrediente1);
		//session.save(deposito);
		//session.getTransaction().commit();
		//session.save(mozo);
		//session.save(plato);
		session.getTransaction().commit();
		session.close();
		
		
		
		//aca terminan pruebas de DB
		
		
		//test ceci
		
		/*List<Plato> listaPlatos=PlatoDAO.getInstance().getPlatos();
		for(Plato p:listaPlatos) 
		{
			System.out.print(p.getNombre());
			
		}
		
		//EL DAO funciona ok
		
		*/
		
		//Mozo mozob=MozoDAO.getInstancia().getMozosByCod(31575032);
		//System.out.println("El mozo buscado es "+mozob.getNombre());
		//Mesa mesab=MesaDAO.getInstance().getMesaN(1);
		//System.out.println("La mesa buscada es "+mesab.getCodMesa());
		//ambos buscar funcionan OK
		
		
		/* //TEST  DAO COMANDA - BUSCAR COMANDA POR CODIGO   --FUNCIONA
		ComandaEntity resultado =new ComandaEntity();
		resultado = ComandaDAO.getInstance().obtenerComanda(1); //FUNCIONA DAO obtener comanda
		System.out.println("HOLA "+resultado.getCaja().getCodArea());*/
		
	

		
		/* AHORA PROBAMOS PASAR TODOS LOS ITEMS DE LAS COMANDAS ACTIVAS SIN FACTURAR EN UNA MESA DETERMINADA, USAMOS MESA 1 y DEBERIA
		 * PASARNOS LOS ITEMCOMANDAS DE LA COMANDA 2 y 3. ADEMAS CREARNOS LOS ITEM FACTURA y ASOCIARLOS A LA FACTURA QUE CREEMOS

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
		 * test push
		 */
		
		/*--------------->----------->separador de bajo presupuesto<------------------<-----------------------*/				


	/*
		ComandaDTO comanda1=new ComandaDTO();
		Integer codigomozo=comandita2.getMozo().getDni();
		System.out.println(codigomozo);
		Mozo mozito=MozoDAO.getInstancia().getMozosByCodEntity(codigomozo);
		System.out.println(mozito.getApellido());
		Mesa mesita10=MesaDAO.getInstance().getMesaN(comandita2.getMesa().getCodMesa());
		System.out.println(mesita10.getCapacidad());
		MesaDTO mesadto=mesita10.toDTO();
		MozoDTO mozodto=mozito.toDTO();
		comanda1.setMesa(mesadto);
		comanda1.setMozo(mozodto);
		comanda1.setEstado(comandita2.getEstado());
		Controlador.getInstance().guardarComanda(comanda1);*/
		//PRUEBO DAO RECETA INGREDIENTES//
		List<Ingrediente> receta= IngredienteDAO.getInstance().getIngredientesdeSemi(see.toNegocio());
		System.out.println(see.getDescripcion()+ " esta compuesto de: ");
		for(Ingrediente i:receta) 
		{
			System.out.println("Materia Prima: "+ i.getMateriaprima().getDescripcion() + " Cantidad: "+ i.getCantidad()+" "+i.getMateriaprima().getUnidadUso().getDescripcion());
		}
		//
		
		//PRUEBO HAY SUFICIENTE PARA EL SEMI Y FUNCIONA//
		boolean test=IngredienteDAO.getInstance().HaySuficiente(see.toNegocio());
		System.out.println(test);
		//
		
		//PRUEBO DAO PARA COMPOSICION DE PLATO FUNCIONA //
		List<Ingrediente>composicion=PlatoDAO.getInstance().getIngredientes(plato.toNegocio());
		System.out.println(composicion.get(0).getMateriaprima().getDescripcion());
		for(Ingrediente i:composicion) 
		{
			System.out.println("Materia Prima: "+ i.getMateriaprima().getDescripcion() + " Cantidad: "+ i.getCantidad()+" "+i.getMateriaprima().getUnidadUso().getDescripcion());
		}
		//DAO VERIFICA SI SE PUEDE HACER EL PLATO O NO FUNCIONA
		boolean sepuedehacer=PlatoDAO.getInstance().HaySuficiente(composicion);
		System.out.println(sepuedehacer);
		//DAO verifica Cantidad en existencia de una materiaprima//
		float cantidad=MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(mpe.toNegocio());
		System.out.println("Quedan "+cantidad+" de "+mpe.getDescripcion());
		
		//DAO REDUCCION STOCK FUNCIONA :) VAMOS!!
		System.out.println(itemCom2.getPlato().getNombre());
		System.out.println("Necesita para hacerse:");
		List <Ingrediente> recetaplato=PlatoDAO.getInstance().getIngredientes(itemCom2.getPlato().toNegocio());
		for (Ingrediente i: recetaplato)
		{
			System.out.println(i.getCantidad()+" "+i.getMateriaprima().getUnidadUso().getDescripcion()+" "+i.getMateriaprima().getDescripcion());
		}
		ItemComandaDAO.getInstance().reducirstockxItemComanda(itemCom2.toNegocio());
		System.out.println("Ahora quedan:");
		for (Ingrediente i: recetaplato)
		{
			System.out.println("Quedan :"+MateriaPrimaDAO.getInstance().getCantidadMateriaPrima(i.getMateriaprima())+" "+i.getMateriaprima().getUnidadUso().getDescripcion()+" de "+i.getMateriaprima().getDescripcion());
		}
		
		//TEST DAO FACTURACION FUNCIONA OK LUEGO DE PASAR A NEGOCIO! TODO EN ORDEN.  CAMBIOS..FACTURA COMO DIJO ZUKI NO TIENE ASOCIADA CAJA - NO TIENE SENTIDO y LE SUMAMOS COMPLEJIDAD. NO LLEGAMOS
		// VERIFICAR QUE PREVIO A LA EJECUCION CREO LA FACTURA CON LO IMPORTANTE y LUEGO EJECUTO PARA EL CALCULO y SE ME CREAN LOS ITEMFACTURA A PARTIR DE ITEMCOMANDA. LA FACTURA TENDRA LA MESA y EL DAO
		// BUSCA LAS COMANDAS ABIERTAS PARA ESA MESA Y LAS FACTURA.  LUEGO PASA A COMANDA CERRADA ESTOS ITEMS
		System.out.println(factura.getCodFactura());
		FacturaDAO.getInstance().CerrarFactura(factura);
		factura=FacturaDAO.getInstance().obtenerFacturaByNro(factura.getCodFactura());
	    System.out.println("El total de la factura nro "+factura.getCodFactura()+" es de ARS "+ factura.getImporte());

	    //VER COMISIONES MOZO POR LISTADO FUNCIONA YESS!  Habria que hacer un view pero va...
	    List<String[]> resultado=MozoDAO.getInstancia().ResultadoComisiones();
	    
	    for(String[] resultadoitem:resultado)
	    	{
	    	for (String resultadoaux:resultadoitem)
	    	{
	    		System.out.println(resultadoaux);
	    	}
	    }
	    
	   // /DAO para ver Comision segun fecha desde y HASTA FUNCIONA YESSSS Habria que hacer un view pero va... //
	    Date fechadesde = new Date("10/10/2019");
	    Date fechahasta = new Date("10/10/2020");
	    List<String[]> resultado2=MozoDAO.getInstancia().ResultadoComisiones(fechadesde,fechahasta);
	    
	    for(String[] resultadoitem:resultado2)
	    	{
	    	for (String resultadoaux:resultadoitem)
	    	{
	    		System.out.println(resultadoaux);
	    	}
	    }
	    //CHECK DAO GET MESA
	    Mesa m=MesaDAO.getInstance().getMesaN(1);
	    System.out.println(m.getCodMesa());
}
}
