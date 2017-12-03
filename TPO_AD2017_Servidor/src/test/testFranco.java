package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bd.BusinessDelegate;
import dao.*;
import dto.PlatoDTO;
import entities.*;
import enumns.AreaRest;
import enumns.Estado;
import enumns.MedioDePago;
import enumns.Temporada;
import hibernate.HibernateUtil;
import negocio.Comanda;
import negocio.Deposito;
import negocio.Factura;
import negocio.Local;
import negocio.MateriaPrima;
import negocio.Mesa;
import negocio.Mozo;
import negocio.Plato;
import negocio.Salon;
import negocio.Sector;
import negocio.Unidad;

public class testFranco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unidad uni= UnidadDAO.getInstance().getUnidadByDescp("kilos");
		//Deposito depo= new Deposito();
		Deposito depo=DepositoDAO.getInstancia().getDepositoByCod(2);
//		new MateriaPrima(materia.getDescripcion(), uni, materia.getCantidad(), depo).save();
	}

}
