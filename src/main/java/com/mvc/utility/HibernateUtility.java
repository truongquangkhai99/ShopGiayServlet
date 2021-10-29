package com.mvc.utility;

import com.entities.CategoryEntity;
import com.entities.KhachEntity;
import com.entities.ProductEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtility {
    private final static SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties pros = new Properties();
        pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        pros.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        pros.put(Environment.URL, "jdbc:mysql://localhost:3306/shopgiaymaster");
        pros.put(Environment.USER, "root");
        pros.put(Environment.PASS, "ngolokante3");

        conf.setProperties(pros);
        conf.addAnnotatedClass(KhachEntity.class);
        conf.addAnnotatedClass(CategoryEntity.class);
        conf.addAnnotatedClass(ProductEntity.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}
