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

  private static SessionFactory buildSessionFactory() {
    try {
      // File file = new File("/etc/takemeout/hibernate.cfg.xml");
      // Configuration config = new Configuration();
      // config.configure(file);
      // ServiceRegistryBuilder serviceBuilder = new ServiceRegistryBuilder();
      // serviceBuilder.applySettings(config.getProperties());
      // ServiceRegistry serviceRegistry = serviceBuilder.buildServiceRegistry();
      // SessionFactory factory = config.buildSessionFactory(serviceRegistry);

      File file = new File("/etc/takemeout/hibernate.cfg.xml");
      ServiceRegistry registry  = new StandardServiceRegistryBuilder()
                                        .configure(file)
                                        .build();

      SessionFactory factory = new Configuration().buildSessionFactory(registry);

      return factory;
    } catch (Throwable ex) {
        System.err.println("Error initializing SessionFactory creation.\n" + ex);
        throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = buildSessionFactory();
    }
    return sessionFactory;
  }

  public static Session getSession() {
    if (sessionFactory == null) {
      sessionFactory = buildSessionFactory();
    }
    return sessionFactory.openSession();
  }
}
