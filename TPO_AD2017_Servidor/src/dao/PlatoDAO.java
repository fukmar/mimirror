package dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MateriaPrimaEntity;
import entities.PlanDeProduccionEntity;
import entities.PlatoEntity;
import entities.UnidadEntity;
import enumns.CategoriaPlato;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.Ingrediente;
import negocio.Plato;
import negocio.SemiElaborado;

public class PlatoDAO
{
	private static PlatoDAO instancia;
	private static SessionFactory sf=null;
	
	private PlatoDAO(){}
	
	public static PlatoDAO getInstance(){
		if(instancia == null)
		{
			instancia = new PlatoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(Plato plato){

	PlatoEntity pe = plato.toEntity();
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(pe);
	session.getTransaction().commit();
	session.close();
	}
	
	public List<Plato> getPlatos()
	{
		Session session=sf.openSession();
		List<Plato> listaPlatos=new ArrayList<Plato>();
 		//List<PlatoEntity> resu=session.createCriteria("from PlatoEntity").list();
 		@SuppressWarnings("unchecked")
		List<PlatoEntity> resu=session.createQuery("from PlatoEntity").list();
		for(PlatoEntity p:resu) 
		{
			listaPlatos.add(p.toNegocio());
		}
		session.close();
		return listaPlatos;
	}
	public Plato getPlatoPorCod(Integer codPlato) 
	{
		Plato plato=new Plato();
		//SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PlatoEntity resu =(PlatoEntity) session.createQuery("from PlatoEntity p where p.codigo=?").setInteger(0, codPlato).uniqueResult();
		session.close();
		plato=resu.toNegocio();
		return plato;
	}
	public List<Plato> getPlatosparecidos(String nombre, String categoriaplato)
	{
		Session session=sf.openSession();
		List<Plato> listaPlatos=new ArrayList<Plato>();
		CategoriaPlato categoria=categoriafromString(categoriaplato);
 		//List<PlatoEntity> resu=session.createCriteria("from PlatoEntity").list();
 		@SuppressWarnings("unchecked")
		Query query=session.createQuery("from PlatoEntity p where p.categoria=? and p.nombre like ? ");
 		query.setString(1,"%"+nombre+"%");
 		query.setParameter(0,categoria);
 		@SuppressWarnings("unchecked")
		List<PlatoEntity> resu=query.list();
		for(PlatoEntity p:resu) 
		{
			listaPlatos.add(p.toNegocio());
		}
		session.close();
		return listaPlatos;
	}
	public List<Ingrediente> getIngredientes (Plato p)
	{
		List <Ingrediente> ingredientesFinal=new ArrayList <Ingrediente>();
		List <Elaborado> elaborados=p.getProductoPlato();
		for(Elaborado elab:elaborados)
		{
			List <SemiElaborado> semielab=new ArrayList <SemiElaborado>();
			semielab=elab.getComponentes();
			for(SemiElaborado s:semielab)
			{
			    List<Ingrediente> ingredientesdereceta=new ArrayList <Ingrediente>();
				ingredientesdereceta=IngredienteDAO.getInstance().getIngredientesdeSemi(s);
				for (Ingrediente idereceta:ingredientesdereceta)
				{
					int codigoabuscar=idereceta.getMateriaprima().getCodigo();
					if (ingredientesFinal.isEmpty())	
						ingredientesFinal.add(idereceta);
					else
					{
						for (Ingrediente ifinal:ingredientesFinal)
						{
							if(ifinal.getMateriaprima().getCodigo()==codigoabuscar)
							{
								int subcantidad=ifinal.getCantidad()+idereceta.getCantidad();
								ifinal.setCantidad(subcantidad);
							}
							else
							{
								ingredientesFinal.add(idereceta);
							}
					}
					}
				}
				 
			}
			
		}
		return ingredientesFinal;
	}
	public boolean HaySuficiente (List<Ingrediente> ingredientesnecesarios)
	{
		int sepuede=0;
		for(Ingrediente i:ingredientesnecesarios) 
		{
			MateriaPrimaEntity mp= new MateriaPrimaEntity();
			Session session=sf.openSession();
			mp=(MateriaPrimaEntity) session.createQuery("from MateriaPrimaEntity mp where mp.codigo=?").setInteger(0,i.getMateriaprima().getCodigo()).uniqueResult();
	 		if (mp.getCantidad()<i.getCantidad())
	 			sepuede++;
	 		session.close();
		}
		if (sepuede==0) return true;
		else return false;
	}
	
	private CategoriaPlato categoriafromString(String categoria)
	{
		return CategoriaPlato.valueOf(categoria);
	}
	
	public Long getCantidadPlatosFacturados (Plato p,Date fecha)
	{
		SimpleDateFormat sformat=new SimpleDateFormat("dd-MM-YYYY");
		String fromDate=null;
		fromDate=sformat.format(fecha);
		Session s=sf.openSession();
		s.beginTransaction();
		Long cantidaddelplato= (Long) s.createQuery("select sum(ic.cantidad) FROM ItemFacturaEntity i join i.factura f join i.itemcomanda ic  WHERE f.fecha=? and ic.plato.codigo=?").setString(0, fromDate).setInteger(1, p.getCodigo()).uniqueResult();
		s.getTransaction().commit();
		return cantidaddelplato;
	}
	//FALTA
	/*private PlatoEntity toEntity(Plato plato) {	
		return null;

	}*/
	
}

