package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ElaboradoEntity;
import entities.IngredienteEntity;
import entities.PlatoEntity;
import entities.SemiElaboradoEntity;
import entities.UnidadEntity;
import hibernate.HibernateUtil;
import negocio.Elaborado;
import negocio.Ingrediente;
import negocio.Plato;
import negocio.SemiElaborado;

public class ElaboradoDAO {

	
private static ElaboradoDAO instancia;
private static SessionFactory sf=null;
	private ElaboradoDAO(){}
	
	public static ElaboradoDAO getInstance(){
		if(instancia == null)
			instancia = new ElaboradoDAO();
		return instancia;
	}
	
	public void save(Elaborado elab){

	ElaboradoEntity ee = elab.toEntity();//cz
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(ee);
	session.getTransaction().commit();
	session.close();
	}
	
	/*public List<Ingrediente> getIngredientesdeElaborado (Elaborado elab)
	{
		List <SemiElaborado> semisde1=elab.getComponentes();
		Session session=sf.openSession();
		List<Ingrediente> receta=new ArrayList<Ingrediente>();

		Query query=session.createQuery("i.materiaprima.codigo, sum(i.cantidad) from IngredienteEntity i where i.platosemielaborado.codigoProd=? group by i.materiaprima");
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
	public boolean sepuedehacerelaborado (Elaborado elab)
	{
		List <SemiElaborado> semisde1=elab.getComponentes();
		int testeo=0;
		for(SemiElaborado semi:semisde1) 
	{
		System.out.println(semi.get);
		boolean test2=IngredienteDAO.getInstance().HaySuficiente(semi);
		if (test2=false) 
			testeo++;
	}
	if (testeo>0)
		System.out.println("No se puede");
	else
	System.out.println("Se puede hacer");
	
}
	*/
	/*//FALTA
	private ElaboradoEntity toEntity(Elaborado elab) {	
		return null;

	}*/
	
}
