package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.IngredienteEntity;
import entities.MateriaPrimaEntity;
import entities.PlatoEntity;
import enumns.CategoriaPlato;
import hibernate.HibernateUtil;
import negocio.Ingrediente;
import negocio.MateriaPrima;
import negocio.Plato;
import negocio.SemiElaborado;

public class IngredienteDAO {
	private static IngredienteDAO instancia;
	private static SessionFactory sf=null;
	
	private IngredienteDAO(){}
	
	public static IngredienteDAO getInstance(){
		if(instancia == null)
		{
			instancia = new IngredienteDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	public List<Ingrediente> getIngredientesdeSemi (SemiElaborado semielab)
	{
		int codsemielab=semielab.getNumero();
		Session session=sf.openSession();
		List<Ingrediente> receta=new ArrayList<Ingrediente>();

		Query query=session.createQuery("from IngredienteEntity i where i.platosemielaborado.codigoProd=?");
 		query.setInteger(0,codsemielab);
 		@SuppressWarnings("unchecked")
		List<IngredienteEntity> resultado=query.list();
		for(IngredienteEntity p:resultado) 
		{
			receta.add(p.toNegocio());
		}
		session.close();
		return receta;	
	}
	public boolean HaySuficiente (SemiElaborado semielab)
	{
		int sepuede=0;
		List<Ingrediente> receta=IngredienteDAO.getInstance().getIngredientesdeSemi(semielab);
		for(Ingrediente i:receta) 
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
}
