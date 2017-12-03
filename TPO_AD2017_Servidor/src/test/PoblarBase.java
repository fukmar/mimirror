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
		// LOCAL - SECTOR
		LocalEntity local1=new LocalEntity("Sucre 123", "Belgrano", deposito);
		SalonEntity salon=new SalonEntity("Schnitzelei",local1);
		SalonEntity salon2=new SalonEntity("Hackethals",local1);
		SalonEntity salon3=new SalonEntity("Marjellchen",local1);
		
		CajaEntity caja=new CajaEntity(AreaRest.Caja,salon,local1);
		SectorEntity sector = new SectorEntity("Azul", salon);
		List<SectorEntity> sectores = new ArrayList<SectorEntity>();
		List <MesaEntity> mesas=new ArrayList<MesaEntity>();
		sectores.add(sector);
		salon.setSectores(sectores);
		session.save(local1);
		session.save(salon);
		session.save(salon2);
		session.save(salon3);
		
		session.save(caja);
		session.save(sector);

		//INGREDIENTES Y SEMIs
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
		IngredienteEntity ing14=new IngredienteEntity(materia3,2,semielaborado2);
		IngredienteEntity ing15=new IngredienteEntity(materia24,200,semielaborado2);
		IngredienteEntity ing16=new IngredienteEntity(materia8,50,semielaborado2);
		session.save(ing14);
		session.save(ing15);
		session.save(ing16);
		session.save(semielaborado3);
		
		SemiElaboradoEntity semielaborado4=new SemiElaboradoEntity("Carnes","Especial","Bife de Chorizo",1,fecha,ue3);
		IngredienteEntity ing17=new IngredienteEntity(materia12,500,semielaborado2);
		session.save(ing17);
		session.save(semielaborado4);
		
		SemiElaboradoEntity semielaborado5=new SemiElaboradoEntity("Carnes","Especial","Ribs de Cerdo",1,fecha,ue3);
		IngredienteEntity ing18=new IngredienteEntity(materia24,500,semielaborado2);
		session.save(ing18);
		session.save(semielaborado5);
		
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
		
		session.getTransaction().commit();
		session.close();
	}
	}
		
