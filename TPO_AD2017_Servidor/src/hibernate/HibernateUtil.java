package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.*;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(PlanDeProduccionEntity.class);
             config.addAnnotatedClass(UnidadEntity.class);
             config.addAnnotatedClass(ProductoEntity.class);
             config.addAnnotatedClass(MateriaPrimaEntity.class);
             config.addAnnotatedClass(SemiElaboradoEntity.class);
             config.addAnnotatedClass(ElaboradoEntity.class);
             config.addAnnotatedClass(PlatoEntity.class);
             config.addAnnotatedClass(ItemComandaEntity.class);
             config.addAnnotatedClass(ComandaEntity.class);
             config.addAnnotatedClass(SectorEntity.class);
             config.addAnnotatedClass(MesaEntity.class);
             config.addAnnotatedClass(MozoEntity.class);
             config.addAnnotatedClass(ItemFacturaEntity.class);
             config.addAnnotatedClass(FacturaEntity.class);
             config.addAnnotatedClass(LocalEntity.class);
             config.addAnnotatedClass(AreaRestaurantEntity.class);
             config.addAnnotatedClass(CajaEntity.class);
             config.addAnnotatedClass(SalonEntity.class);
             config.addAnnotatedClass(LocalEntity.class);

             

             
             
             
            
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}