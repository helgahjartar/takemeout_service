package com.takemeout.util;

import java.io.File;
import java.io.InputStream;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionUtil {
  private static SessionFactory sessionFactory = null;

  public static void buildSessionFactory() {
    try {
      if (sessionFactory != null) return;
      File file = new File("hibernate.cfg.xml");
      ServiceRegistry registry  = new StandardServiceRegistryBuilder()
                                        .configure(file)
                                        .build();
      sessionFactory = new Configuration().buildSessionFactory(registry);
    } catch (Throwable ex) {
        System.err.println("Error initializing SessionFactory creation.\n" + ex);
        throw new ExceptionInInitializerError(ex);
    }
  }

  public static Session getSession() {
    if (sessionFactory == null) buildSessionFactory();
    return sessionFactory.openSession();
  }
}
