package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.*;
import enumns.*;
import hibernate.HibernateUtil;
import negocio.*;


public class UnidadDAO {
	
private static UnidadDAO instancia;
private static SessionFactory sf=null;
	
	private UnidadDAO(){}
	
	public static UnidadDAO getInstance()
	{
		if(instancia == null)
		{
			instancia = new UnidadDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void save(Unidad unidad){ 

		UnidadEntity uni = unidad.toEntity();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(uni);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Unidad> getUnidades()
	{
		List<Unidad> unidades=new ArrayList<Unidad>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
 		@SuppressWarnings("unchecked")
		List<UnidadEntity> uniEnt=session.createQuery("from UnidadEntity").list();
		for(UnidadEntity uniuni:uniEnt) 
		{
			unidades.add(uniuni.toNegocio());
		}
		session.close();
		return unidades;
	}
	public Unidad getUnidadByDescp(String descp) 
	{
		Unidad unidad=new Unidad();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		UnidadEntity uni= new UnidadEntity();
		uni=(UnidadEntity) session.createQuery("FROM UnidadEntity uni WHERE uni.descripcion=?").setString(0,descp).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		unidad=uni.toNegocio();
		return unidad;
	}
	
	public Unidad getUnidadByCod(Integer codUnidad)
	{
		Unidad unidad=new Unidad();
		Session session=sf.openSession();
		UnidadEntity resu=(UnidadEntity) session.createQuery("from UnidadEntity u where u.codigoUni=?").setInteger(0, codUnidad).uniqueResult();
		unidad=resu.toNegocio();
		session.close();
		return unidad;
	}
	
}
