package dao;
import java.text.SimpleDateFormat;
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
	public Long getSemiElaboradosFacturados (SemiElaborado see,Date fecha)
	{
		SimpleDateFormat sformat=new SimpleDateFormat("dd-MM-YYYY");
		String fromDate=null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		fromDate=sformat.format(fecha);
		Session s=sf.openSession();
		s.beginTransaction();
		List <SemiElaboradoEntity> semis=s.createQuery("select semi FROM ItemFacturaEntity i "
				+ "join i.factura f "
				+ "join i.itemcomanda ic "
				+ "join ic.plato p "
				+ "join p.productoPlato e "
				+ "join e.componentes semi "
				+ "WHERE f.fecha=? and semi.codigoProd=?").setString(0, fromDate).setInteger(1, see.getCodigoProd()).list();
		s.getTransaction().commit();
		int cantidad=0;
		for (SemiElaboradoEntity semi: semis)
		{
			cantidad=semi.getCantidad()+cantidad;
		}
		s.beginTransaction();
		List <ItemComandaEntity> items=s.createQuery("select ic FROM ItemFacturaEntity i "
				+ "join i.factura f "
				+ "join i.itemcomanda ic "
				+ "join ic.plato p "
				+ "join p.productoPlato e "
				+ "join e.componentes semi "
				+ "WHERE f.fecha=? and semi.codigoProd=?").setString(0, fromDate).setInteger(1, see.getCodigoProd()).list();
		int cantidaditem=0;
		for (ItemComandaEntity item: items)
		{
			cantidaditem=item.getCantidad()+cantidaditem;
		}
		
		s.getTransaction().commit();
		Long cantidaddelsemi=(long) cantidad*cantidaditem;
		return cantidaddelsemi;
	}
}

