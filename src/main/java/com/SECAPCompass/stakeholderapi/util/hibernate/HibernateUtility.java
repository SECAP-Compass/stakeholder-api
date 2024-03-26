package com.SECAPCompass.stakeholderapi.util.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.SECAPCompass.stakeholderapi.model.*;

public class HibernateUtility {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Comment.class)
                    .addAnnotatedClass(Stakeholder.class)
                    .addAnnotatedClass(Topic.class); // Add the User entity mapping

            return configuration.buildSessionFactory(
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build()
            );
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
