package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.CartaEntity;
import entities.MesaEntity;
import entities.PlatoEntity;
import hibernate.HibernateUtil;
import negocio.Carta;
import negocio.Mesa;
import negocio.Plato;

public class CartaDAO {

	private static CartaDAO instancia;
	private static SessionFactory sf=null;
		
		private CartaDAO(){}
		
		public static CartaDAO getInstance()
		{
			if(instancia == null) {
				instancia = new CartaDAO();
				sf=HibernateUtil.getSessionFactory();
			}
			return instancia;
		}
		

		public Carta obtenerCartaPorCod(int nrocarta)
		{
			Carta carta=new Carta();
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			//MesaEntity mesa=new MesaEntity();
			CartaEntity resu= (CartaEntity)session.createQuery("FROM CartaEntity c WHERE c.codigoCarta=?").setInteger(0,nrocarta).setFirstResult(0).setMaxResults(1).uniqueResult();
			carta=resu.toNegocio();
			return carta;
		}
		
		public List<Carta> getCartas()
		{
			Session session=sf.openSession();
			List<Carta> listaM=new ArrayList<Carta>();
			List<CartaEntity> resu=session.createQuery("from CartaEntity c").list();
			for(CartaEntity c:resu)
			{
				listaM.add(c.toNegocio());
			}
			session.close();
			return listaM;
		}  
		public List<Plato> getPlatosporCodCarta(int nrocarta)
		{
			Session session=sf.openSession();
			List<Plato> listaM=new ArrayList<Plato>();
			List<PlatoEntity> resu=session.createQuery("from PlatoEntity p where p.carta.codigoCarta=?").list();
			for(PlatoEntity p:resu)
			{
				listaM.add(p.toNegocio());
			}
			session.close();
			return listaM;
		}
		
}
