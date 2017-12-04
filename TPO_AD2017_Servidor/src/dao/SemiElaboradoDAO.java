package dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemComandaEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
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
		SessionFactory sf = HibernateUtil.getSessionFactory();
		fromDate=sformat.format(fecha);
		System.out.println("LA FECHA ES:"+fecha+" "+fromDate);
		Session s=sf.openSession();
		s.beginTransaction();
	
		Long semicantidad=(Long) s.createQuery("select sum(semi.cantidad) FROM ItemFacturaEntity i "
				+ "join i.factura f "
				+ "join i.itemcomanda ic "
				+ "join ic.plato p "
				+ "join p.productoPlato e "
				+ "join e.componentes semi "
				+ "WHERE f.fecha=? and semi.codigoProd=?").setString(0, fromDate).setInteger(1, see.getCodigoProd()).uniqueResult();
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
		SemiElaboradoEntity resu =(SemiElaboradoEntity) session.createQuery("from PlatoEntity p where p.codPlato=?").setInteger(0, codsemi).uniqueResult();
		semi=resu.toNegocio();
		session.close();
		return semi;
	}
	
	
}

