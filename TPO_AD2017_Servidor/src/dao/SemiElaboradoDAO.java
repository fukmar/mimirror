package dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.IngredienteEntity;
import entities.ItemComandaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Ingrediente;
import negocio.Plato;
import negocio.SemiElaborado;

public class SemiElaboradoDAO {

	
private static SemiElaboradoDAO instancia;
	
	private SemiElaboradoDAO(){}
	
	public static SemiElaboradoDAO getInstance(){
		if(instancia == null)
			instancia = new SemiElaboradoDAO();
		return instancia;
	}
	
	public void save(SemiElaborado semielab){

	SemiElaboradoEntity see = (semielab.toEntitySemi());
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(see);
	session.getTransaction().commit();
	session.close();
	}
	public Long getSemiElaboradoFacturados (SemiElaborado see,Date fecha)
	{
		SimpleDateFormat sformat=new SimpleDateFormat("yyyy/MM/dd");

		String fromDate=null;

		String tosDate=null;
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha); 
	    calendar.add(Calendar.DAY_OF_YEAR, 2);
		Calendar calendar2 = Calendar.getInstance();
	    calendar2.setTime(fecha); 
	    calendar2.add(Calendar.DAY_OF_YEAR, -1);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		tosDate=sformat.format(calendar.getTime());
		fromDate=sformat.format(calendar2.getTime());
		System.out.println("LA FECHA ES:"+fromDate);
		System.out.println("LA FECHA ES:"+tosDate);
		Session s=sf.openSession();
		s.beginTransaction();
	
		Long semicantidad=(Long) s.createQuery("select sum(semi.cantidad) FROM ItemFacturaEntity i "
				+ "join i.factura f "
				+ "join i.itemcomanda ic "
				+ "join ic.plato p "
				+ "join p.productoPlato e "
				+ "join e.componentes semi "
				+ "WHERE  f.fecha between ? and ?  and semi.codigoProd=?").setString(0, fromDate).setString(1,tosDate).setInteger(2, see.getCodigoProd()).uniqueResult();
		s.getTransaction().commit();
		return semicantidad;
	}
	public List<SemiElaborado> getSemis()
	{	
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		List<SemiElaborado> listaSemi=new ArrayList<SemiElaborado>();
 		//List<PlatoEntity> resu=session.createCriteria("from PlatoEntity").list();
 		@SuppressWarnings("unchecked")
		List<SemiElaboradoEntity> resu=session.createQuery("from SemiElaboradoEntity").list();
		for(SemiElaboradoEntity p:resu) 
		{
			listaSemi.add(p.toNegocio());
		}
		session.close();
		return listaSemi;
	}
	public SemiElaborado getSemisPorCod(Integer codsemi) 
	{
		SemiElaborado semi=new SemiElaborado();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		SemiElaboradoEntity resu =(SemiElaboradoEntity) session.createQuery("from SemiElaboradoEntity s where s.codigoProd=?").setInteger(0, codsemi).uniqueResult();
		semi=resu.toNegocio();
		session.close();
		return semi;
	}
	public List<Ingrediente> getIngredientesPorSemis(Integer codsemi)
	{
		List<Ingrediente> ingredientes=new ArrayList <Ingrediente>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<IngredienteEntity> resu = session.createQuery("from IngredienteEntity i where i.platosemielaborado.codigoProd=?").setInteger(0, codsemi).list();
		for (IngredienteEntity i: resu)
		{
			ingredientes.add(i.toNegocio());
		}
		session.close();
		return ingredientes;
	}
	
}

