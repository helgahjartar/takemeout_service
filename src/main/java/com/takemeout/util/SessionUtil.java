package com.takemeout.util;

import java.io.File;
import java.io.InputStream;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionUtil {
  private static SessionFactory sessionFactory = null;

  private static SessionFactory buildSessionFactory() {
    try {
      File file = new File("/etc/takemeout/hibernate.cfg.xml");
      Configuration config = new Configuration();
      config.configure(file);
      ServiceRegistryBuilder serviceBuilder = new ServiceRegistryBuilder();
      serviceBuilder.applySettings(config.getProperties());
      ServiceRegistry serviceRegistry = serviceBuilder.buildServiceRegistry();
      SessionFactory factory = config.buildSessionFactory(serviceRegistry);

      return factory;
    } catch (Throwable ex) {
        System.err.println("Error initializing SessionFactory creation. " + ex);
        throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = buildSessionFactory();
    }
    return sessionFactory;
  }
}
