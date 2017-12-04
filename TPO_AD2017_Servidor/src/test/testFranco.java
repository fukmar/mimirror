package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//Unidad uni= UnidadDAO.getInstance().getUnidadByDescp("kilos");
		//Deposito depo= new Deposito();
		//Deposito depo=DepositoDAO.getInstancia().getDepositoByCod(2);
//		new MateriaPrima(materia.getDescripcion(), uni, materia.getCantidad(), depo).save();
		 	//String input = "27-03-1994";
	       // SimpleDateFormat parser = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	      //  Date date = parser.parse(input);
	       // date.setHours(0);
	       // date.setMinutes(0);
	       // date.setSeconds(0);
	      // // System.out.println("Desde    "+date.toString()+"  hasta   ");
	        String  fechita="2017-12-03";
	       /* Date fechadesde = new Date("12/03/2017 00:00:00");
		    Date fechahasta = new Date("12/03/2017 16:00:00");
	        
	        List <SemiElaboradoEntity> semis=new ArrayList<SemiElaboradoEntity>();
	        SemiElaboradoEntity x=new SemiElaboradoEntity(null, null, "birra", null,fechadesde , null);
	        SemiElaboradoEntity y=new SemiElaboradoEntity(null, null, "caca", null,fechahasta , null);
	        semis.add(x);
	        semis.add(y);*/
	       /* 
	        SimpleDateFormat sformat=new SimpleDateFormat("YYYY-MM-dd");
			String fromDate=null;
			String toDate=null;
			Date date1=sformat.parse(fechita);
			Date date2=sformat.parse(fechita);
			date1.setHours(0);
			date1.setMinutes(0);
			date1.setSeconds(0);
			date2.setHours(23);
			date2.setMinutes(59);
			date2.setSeconds(59);
			SessionFactory sf = HibernateUtil.getSessionFactory();
			fromDate=sformat.format(date1);
			toDate=sformat.format(date2);
			System.out.println(fromDate);
			System.out.println(toDate);
			Session s=sf.openSession();
			s.beginTransaction();
			List <SemiElaboradoEntity> semis=s.createQuery("FROM SemiElaboradoEntity semi "
					+ "WHERE semi.caducidad between ? and ? ").setString(0, fromDate).setString(1, toDate).list();
			for(SemiElaboradoEntity semiel: semis) {
				System.out.println(semiel.getDescripcion());
			}
			s.getTransaction().commit();
			s.close();*/
			
			MateriaPrima mate=new MateriaPrima("prueba", null, 15f, null);
			mate.setCodigo(1);
			mate.update();
	        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	      //  String formattedDate = formatter.format(date);
		//PlanDeProduccionEntity plan=new PlanDeProduccionEntity(fechaplan, null, null);
	}

}
