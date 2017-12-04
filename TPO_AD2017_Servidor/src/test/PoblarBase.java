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
import dto.DepositoDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import entities.*;
import enumns.AreaRest;
import enumns.CategoriaPlato;
import enumns.Estado;
import enumns.EstadoItemComanda;
import enumns.EstadoRemito;
import enumns.EstadoSolicitud;
import enumns.MedioDePago;
import enumns.Temporada;
import hibernate.HibernateUtil;
import negocio.Comanda;
import negocio.Deposito;
import negocio.Elaborado;
import negocio.Factura;
import negocio.Ingrediente;
import negocio.ItemComanda;
import negocio.Local;
import negocio.Mesa;
import negocio.Mozo;
import negocio.PlanDeProduccion;
import negocio.Plato;
import negocio.Remito;
import negocio.Salon;
import negocio.Sector;
import negocio.SemiElaborado;
import negocio.Usuarios;
 
public class PoblarBase {

	//----------------------->Hagan sus pruebas relacionadas a HIBERNATE aqui <-----------------------------
	public static void main(String[] args) 
	{		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		//aca van pruebas de DB
		
		//Creacion de unidades
		UnidadEntity ue = new UnidadEntity("gms");
		UnidadEntity ue2 = new UnidadEntity("ml");
		UnidadEntity ue3 = new UnidadEntity("unid.");
		session.save(ue);
		session.save(ue2);
		session.save(ue3);
		
		//Creacion de usuarios
		UsuariosEntity usu = new UsuariosEntity("admin","admin","N","G",AreaRest.Administracion);
		UsuariosEntity usu1 = new UsuariosEntity("mozo","mozo","N","G",AreaRest.salon);
		UsuariosEntity usu2 = new UsuariosEntity("cocina","cocina","N","G",AreaRest.Cocina);
		UsuariosEntity usu3 = new UsuariosEntity("caja","caja","N","G",AreaRest.Caja);
		UsuariosEntity usu4 = new UsuariosEntity("bar","bar","N","G",AreaRest.Barra);
		session.save(usu);
		session.save(usu1);
		session.save(usu2);
		session.save(usu3);
		session.save(usu4);
		
		//Deposito
		Date fecha = new Date("12/03/2017");
		DepositoEntity deposito=new DepositoEntity ();
		session.save(deposito);

		//MateriasPrimas
		
		MateriaPrimaEntity materia = new MateriaPrimaEntity("Carne Picada de Ternera",ue, 10000f,deposito);
		MateriaPrimaEntity materia2 = new MateriaPrimaEntity("Carne Picada de Cerdo",ue, 10000f,deposito);
		MateriaPrimaEntity materia3 = new MateriaPrimaEntity("Huevos",ue3, 1000f,deposito);
		MateriaPrimaEntity materia4 = new MateriaPrimaEntity("Manteca",ue, 1000f,deposito);
		MateriaPrimaEntity materia5 = new MateriaPrimaEntity("Agua Gasificada 1L",ue3, 100f,deposito);
		MateriaPrimaEntity materia6 = new MateriaPrimaEntity("Leche 1L",ue3, 100f,deposito);
		MateriaPrimaEntity materia7 = new MateriaPrimaEntity("Pimenton",ue, 1000f,deposito);
		MateriaPrimaEntity materia8 = new MateriaPrimaEntity("Oregano",ue, 1000f,deposito);
		MateriaPrimaEntity materia9 = new MateriaPrimaEntity("Pimienta",ue, 1000f,deposito);
		MateriaPrimaEntity materia10 = new MateriaPrimaEntity("Condimento para Pizza",ue, 1000f,deposito);
		MateriaPrimaEntity materia11 = new MateriaPrimaEntity("Pan Rallado",ue, 1000f,deposito);
		MateriaPrimaEntity materia12 = new MateriaPrimaEntity("Bifes de Chorizo",ue3, 100f,deposito);
		MateriaPrimaEntity materia13 = new MateriaPrimaEntity("Coca Cola 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia14 = new MateriaPrimaEntity("Sprite 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia15 = new MateriaPrimaEntity("Pepsi 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia16 = new MateriaPrimaEntity("Pepsi Max 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia17 = new MateriaPrimaEntity("Sprite Zero 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia18 = new MateriaPrimaEntity("Coca Cola Zero 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia19 = new MateriaPrimaEntity("Agua Mineral 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia20 = new MateriaPrimaEntity("Agua Mineral con Gas 360ml",ue3, 100f,deposito);
		MateriaPrimaEntity materia21 = new MateriaPrimaEntity("Cafe",ue, 10000f,deposito);
		MateriaPrimaEntity materia22 = new MateriaPrimaEntity("Te con Limon",ue3, 100f,deposito);
		MateriaPrimaEntity materia23 = new MateriaPrimaEntity("Te con Miel",ue3, 100f,deposito);
		MateriaPrimaEntity materia24 = new MateriaPrimaEntity("Cordero",ue, 100000f,deposito);
		MateriaPrimaEntity materia25 = new MateriaPrimaEntity("Costillas de Cerdo",ue, 100000f,deposito);
		MateriaPrimaEntity materia26 = new MateriaPrimaEntity("Papa",ue, 1000f,deposito);
		session.save(materia);
		session.save(materia2);
		session.save(materia3);
		session.save(materia4);
		session.save(materia5);
		session.save(materia6);
		session.save(materia7);
		session.save(materia8);
		session.save(materia9);
		session.save(materia10);
		session.save(materia11);
		session.save(materia12);
		session.save(materia13);
		session.save(materia14);
		session.save(materia15);
		session.save(materia16);
		session.save(materia17);
		session.save(materia18);
		session.save(materia19);
		session.save(materia20);
		session.save(materia21);
		session.save(materia22);
		session.save(materia23);
		session.save(materia24);
		session.save(materia25);
		session.save(materia26);
		// LOCAL - SECTOR
		LocalEntity local1=new LocalEntity("Sucre 123", "Belgrano", deposito);
		SalonEntity salon=new SalonEntity("Schnitzelei",local1);
		SalonEntity salon2=new SalonEntity("Hackethals",local1);
		SalonEntity salon3=new SalonEntity("Marjellchen",local1);
		
		CajaEntity caja=new CajaEntity(AreaRest.Caja,salon,local1);
		SectorEntity sector = new SectorEntity("Azul", salon);
		List<SectorEntity> sectores = new ArrayList<SectorEntity>();
		List <MesaEntity> mesas=new ArrayList<MesaEntity>();
		
		//MOZOS
		MozoEntity mozo1=new MozoEntity(18005145, "Nahuel", "GrisOliva",Float.parseFloat("5"));
		MozoEntity mozo2=new MozoEntity(27005175, "Flavio", "Perez",Float.parseFloat("7"));
		MozoEntity mozo3=new MozoEntity(25645785, "Juan", "Porcelo",Float.parseFloat("9"));
		session.save(mozo1);
		session.save(mozo2);
		session.save(mozo3);
		
		
		//MESAS
		MesaEntity mesa1=new  MesaEntity(0, 4, 0, mozo1, sector);
		MesaEntity mesa2=new  MesaEntity(0, 4, 0, mozo2, sector);
		MesaEntity mesa3=new  MesaEntity(0, 6, 0, mozo2, sector);
		MesaEntity mesa4=new  MesaEntity(0, 6, 0, mozo3, sector);
		MesaEntity mesa5=new  MesaEntity(0, 8, 0, mozo3, sector);
		
		
		
		sectores.add(sector);
		salon.setSectores(sectores);
		session.save(local1);
		session.save(salon);
		session.save(salon2);
		session.save(salon3);
		
		session.save(caja);
		session.save(sector);
		session.save(mesa1);
		session.save(mesa2);
		session.save(mesa3);
		session.save(mesa4);
		session.save(mesa5);

		//INGREDIENTES Y SEMIs
		//SOLIDOS
		SemiElaboradoEntity semielaborado1=new SemiElaboradoEntity("Carnes","Especial","Albondigas de cerdo",1,fecha,ue3);
		IngredienteEntity ing1=new IngredienteEntity(materia3,2,semielaborado1);
		IngredienteEntity ing2=new IngredienteEntity(materia4,20,semielaborado1);
		IngredienteEntity ing3=new IngredienteEntity(materia2,200,semielaborado1);
		IngredienteEntity ing4=new IngredienteEntity(materia8,50,semielaborado1);
		session.save(ing1);
		session.save(ing2);
		session.save(ing3);
		session.save(ing4);
		
		session.save(semielaborado1);
		
		SemiElaboradoEntity semielaborado2=new SemiElaboradoEntity("Carnes","Especial","Albondigas de carne",1,fecha,ue3);
		IngredienteEntity ing5=new IngredienteEntity(materia3,2,semielaborado2);
		IngredienteEntity ing6=new IngredienteEntity(materia4,20,semielaborado2);
		IngredienteEntity ing7=new IngredienteEntity(materia,200,semielaborado2);
		IngredienteEntity ing8=new IngredienteEntity(materia8,50,semielaborado2);
		session.save(ing5);
		session.save(ing6);
		session.save(ing7);
		session.save(ing8);
		session.save(semielaborado2);
		
		SemiElaboradoEntity semielaborado3=new SemiElaboradoEntity("Carnes","Especial","Cordero Braseado",1,fecha,ue3);
		IngredienteEntity ing14=new IngredienteEntity(materia3,2,semielaborado3);
		IngredienteEntity ing15=new IngredienteEntity(materia24,200,semielaborado3);
		IngredienteEntity ing16=new IngredienteEntity(materia8,50,semielaborado3);
		session.save(ing14);
		session.save(ing15);
		session.save(ing16);
		session.save(semielaborado3);
		
		SemiElaboradoEntity semielaborado4=new SemiElaboradoEntity("Carnes","Especial","Bife de Chorizo",1,fecha,ue3);
		IngredienteEntity ing17=new IngredienteEntity(materia12,500,semielaborado4);
		session.save(ing17);
		session.save(semielaborado4);
		
		SemiElaboradoEntity semielaborado5=new SemiElaboradoEntity("Carnes","Especial","Ribs de Cerdo",1,fecha,ue3);
		IngredienteEntity ing18=new IngredienteEntity(materia24,500,semielaborado5);
		session.save(ing18);
		session.save(semielaborado5);
		
		SemiElaboradoEntity semielaborado6=new SemiElaboradoEntity("Acompañamientos","Especial","Papas Fritas",1,fecha,ue3);
		IngredienteEntity ing19=new IngredienteEntity(materia26,500,semielaborado6);
		session.save(ing19);
		session.save(semielaborado6);
		
		
		//-----------------BEBIDAS-----------------
		SemiElaboradoEntity cocacola=new SemiElaboradoEntity("Bebidas","Especial","Coca Cola 360cm3",1,fecha,ue3);
		IngredienteEntity ing9=new IngredienteEntity(materia13,1,cocacola);
		session.save(ing9);
		session.save(cocacola);
		
		SemiElaboradoEntity pepsi=new SemiElaboradoEntity("Bebidas","Especial","Pepsi 360cm3",1,fecha,ue3);
		IngredienteEntity ing10=new IngredienteEntity(materia15,1,pepsi);
		session.save(ing10);
		session.save(pepsi);
		
		SemiElaboradoEntity pepsimax=new SemiElaboradoEntity("Bebidas","Especial","Pepsi Max 360cm3",1,fecha,ue3);
		IngredienteEntity ing11=new IngredienteEntity(materia16,1,pepsi);
		session.save(ing11);
		session.save(pepsimax);
		
		SemiElaboradoEntity cocazero=new SemiElaboradoEntity("Bebidas","Especial","Coca Zero 360cm3",1,fecha,ue3);
		IngredienteEntity ing12=new IngredienteEntity(materia18,1,pepsi);
		session.save(ing12);
		session.save(cocazero);
		
		SemiElaboradoEntity spritezero=new SemiElaboradoEntity("Bebidas","Especial","Sprite Zero 360cm3",1,fecha,ue3);
		IngredienteEntity ing13=new IngredienteEntity(materia17,1,pepsi);
		session.save(ing13);
		session.save(spritezero);
		
	//ELABORADOS
		//ELABORADO 1
		List<SemiElaboradoEntity> semis= new ArrayList<SemiElaboradoEntity>();
		semis.add(semielaborado1);
		PlanDeProduccionEntity pdp1= new PlanDeProduccionEntity(fecha, Estado.EnProceso);
		ItemPlanProduccionEntity itempdp1=new ItemPlanProduccionEntity(semielaborado1, 1, 0, pdp1); 
		List<ItemPlanProduccionEntity> itemspdp1= new ArrayList<ItemPlanProduccionEntity>();
		itemspdp1.add(itempdp1);
		pdp1.setItemspdp(itemspdp1);
		ElaboradoEntity comida1= new ElaboradoEntity("Especial", "De Exportacion", "Albondigas de Cerdo", pdp1, 15, fecha, ue, semis);
		session.save(comida1);
		
		
		//ELABORADO 2
		List<SemiElaboradoEntity> semis2= new ArrayList<SemiElaboradoEntity>();
		semis2.add(semielaborado2);
		PlanDeProduccionEntity pdp2= new PlanDeProduccionEntity(fecha, Estado.EnProceso);
		ItemPlanProduccionEntity itempdp3=new ItemPlanProduccionEntity(semielaborado2, 1, 0, pdp2); 
		List<ItemPlanProduccionEntity> itemspdp2= new ArrayList<ItemPlanProduccionEntity>();
		itemspdp2.add(itempdp3);
		pdp2.setItemspdp(itemspdp2);
		ElaboradoEntity comida2= new ElaboradoEntity("Especial", "De Exportacion", "Albondigas de carne", pdp2, 10, fecha, ue2, semis2);
		session.save(comida2);
		
		
		//ELABORADO 3
		List<SemiElaboradoEntity> semis3= new ArrayList<SemiElaboradoEntity>();
		semis3.add(semielaborado3);
		PlanDeProduccionEntity pdp3= new PlanDeProduccionEntity(fecha, Estado.EnProceso);
		ItemPlanProduccionEntity itempdp5=new ItemPlanProduccionEntity(semielaborado3, 1, 0, pdp3); 
		List<ItemPlanProduccionEntity> itemspdp3= new ArrayList<ItemPlanProduccionEntity>();
		itemspdp3.add(itempdp5);
		pdp3.setItemspdp(itemspdp3);
		ElaboradoEntity comida3= new ElaboradoEntity("Especial", "De Exportacion", "Cordero Braseado", pdp3, 6, fecha, ue2, semis3);
		session.save(comida3);
		
		//ELABORADO 4
		List<SemiElaboradoEntity> semis4= new ArrayList<SemiElaboradoEntity>();
		semis4.add(semielaborado4);
		PlanDeProduccionEntity pdp4= new PlanDeProduccionEntity(fecha, Estado.EnProceso);
		ItemPlanProduccionEntity itempdp7=new ItemPlanProduccionEntity(semielaborado4, 1, 0, pdp4); 
		List<ItemPlanProduccionEntity> itemspdp4= new ArrayList<ItemPlanProduccionEntity>();
		itemspdp4.add(itempdp7);
		pdp4.setItemspdp(itemspdp4);
		ElaboradoEntity comida4= new ElaboradoEntity("Especial", "De Exportacion", "Bife de Chorizo", pdp4, 7, fecha, ue2, semis4);
		session.save(comida4);
		
		
		//ELABORADO 5
		List<SemiElaboradoEntity> semis5= new ArrayList<SemiElaboradoEntity>();
		semis5.add(semielaborado6);
		PlanDeProduccionEntity pdp5= new PlanDeProduccionEntity(fecha, Estado.EnProceso);
		ItemPlanProduccionEntity itempdp9=new ItemPlanProduccionEntity(semielaborado6, 1, 0, pdp5); 
		List<ItemPlanProduccionEntity> itemspdp5= new ArrayList<ItemPlanProduccionEntity>();
		itemspdp5.add(itempdp9);
		pdp5.setItemspdp(itemspdp5);
		ElaboradoEntity comida5= new ElaboradoEntity("Comun", "Crujientes", "Papas Fritas", pdp5, 7, fecha, ue2, semis5);
		session.save(comida5);
		
		//ELABORADO 6 
		List<SemiElaboradoEntity> semis6= new ArrayList<SemiElaboradoEntity>();
		semis6.add(spritezero);
		PlanDeProduccionEntity pdp6= new PlanDeProduccionEntity(fecha, Estado.EnProceso);
		ItemPlanProduccionEntity itempdp10=new ItemPlanProduccionEntity(spritezero, 1, 0, pdp6); 
		List<ItemPlanProduccionEntity> itemspdp6= new ArrayList<ItemPlanProduccionEntity>();
		itemspdp6.add(itempdp10);
		pdp6.setItemspdp(itemspdp6);
		ElaboradoEntity comida6= new ElaboradoEntity("Bebida", "Fria", "Sprite Zero 360cm3", pdp6, 7, fecha, ue3, semis6);
		session.save(comida6);
		
		//ELABORADO 6 
		List<SemiElaboradoEntity> semis7= new ArrayList<SemiElaboradoEntity>();
		semis7.add(cocacola);
		PlanDeProduccionEntity pdp7= new PlanDeProduccionEntity(fecha, Estado.EnProceso);
		ItemPlanProduccionEntity itempdp11=new ItemPlanProduccionEntity(cocacola, 1, 0, pdp7); 
		List<ItemPlanProduccionEntity> itemspdp7= new ArrayList<ItemPlanProduccionEntity>();
		itemspdp7.add(itempdp11);
		pdp7.setItemspdp(itemspdp7);
		ElaboradoEntity comida7= new ElaboradoEntity("Bebida", "Fria", "Coca Cola 360cm3", pdp7, 7, fecha, ue3, semis7);
		session.save(comida7);
		
		
	//PLATOS
		//PLATO 1
		List<ElaboradoEntity> elabs1= new ArrayList<ElaboradoEntity>();
		elabs1.add(comida1);
		elabs1.add(comida5);
		PlatoEntity plato1= new PlatoEntity("Albondigas de Cerdo con Papas Fritas", 400, AreaRest.Cocina, CategoriaPlato.Carnes, elabs1);
		session.save(plato1);
		
		
		//PLATO 2 
		List<ElaboradoEntity> elabs2= new ArrayList<ElaboradoEntity>();
		elabs2.add(comida2);
		elabs2.add(comida5);
		PlatoEntity plato2= new PlatoEntity("Albondigas de carne con Papas Fritas", 350, AreaRest.Cocina, CategoriaPlato.Carnes, elabs2);
		session.save(plato2);
		
		//PLATO 3
		List<ElaboradoEntity> elabs3= new ArrayList<ElaboradoEntity>();
		elabs3.add(comida3);
		elabs3.add(comida5);
		PlatoEntity plato3= new PlatoEntity("Cordero braseado con Papas Fritas", 500, AreaRest.Cocina, CategoriaPlato.Carnes, elabs3);
		session.save(plato3);
		
		//PLATO 4
		List<ElaboradoEntity> elabs4= new ArrayList<ElaboradoEntity>();
		elabs4.add(comida6);
		PlatoEntity plato4= new PlatoEntity("Sprite Zero 360cm3", 50, AreaRest.Barra, CategoriaPlato.Bebida, elabs4);
		session.save(plato4);
		
		//PLATO 5
		List<ElaboradoEntity> elabs5= new ArrayList<ElaboradoEntity>();
		elabs5.add(comida7);
		PlatoEntity plato5= new PlatoEntity("Coca Cola 360cm3", 50, AreaRest.Barra, CategoriaPlato.Bebida, elabs5);
		session.save(plato5);
		
		
		
	//CARTA
		//CARTA 1 
		List<PlatoEntity> platos=new ArrayList<PlatoEntity>();
		platos.add(plato1);
		platos.add(plato2);
		platos.add(plato3);
		platos.add(plato4);
		platos.add(plato5);
		CartaEntity carta= new CartaEntity(fecha, Temporada.Verano, platos);
		session.save(carta);
		plato1.setCarta(carta);
		plato2.setCarta(carta);
		plato3.setCarta(carta);
		plato4.setCarta(carta);
		plato5.setCarta(carta);
		session.update(plato1);
		session.update(plato2);
		session.update(plato3);
		session.update(plato4);
		session.update(plato5);

		
		session.getTransaction().commit();
		session.close();
	}
	}
		
