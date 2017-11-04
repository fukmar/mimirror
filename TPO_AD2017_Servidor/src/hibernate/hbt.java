package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.*;
 
public class hbt
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(LocalEntity.class)
             .addAnnotatedClass(PlanDeProduccionEntity.class)
             .addAnnotatedClass(UnidadEntity.class)
             .addAnnotatedClass(MozoEntity.class)
             .addAnnotatedClass(ProductoEntity.class)
             .addAnnotatedClass(MateriaPrimaEntity.class)
             .addAnnotatedClass(SemiElaboradoEntity.class)
             .addAnnotatedClass(ElaboradoEntity.class)
             .addAnnotatedClass(PlatoEntity.class);
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