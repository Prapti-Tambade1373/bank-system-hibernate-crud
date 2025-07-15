package com.bankCongig;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.bankmodel.Account;

public class HibernateUtil {

	public static SessionFactory factory;
	
	public static SessionFactory getSessionFactory()
	{
		Configuration cfg=new Configuration();
		Properties properties=new Properties();
		
		//Database Properties
		properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL,"jdbc:mysql://localhost:3306/BankProject");
		properties.put(Environment.USER,"root");
		properties.put(Environment.PASS,"Aditya@5974#20");
		
		//Hibernate properties
		
		properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL57Dialect");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL,false);
		properties.put(Environment.HBM2DDL_AUTO,"create");
		properties.put(Environment.USE_SECOND_LEVEL_CACHE,false);
		properties.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory");
		
		//Setting up the properties
		cfg.setProperties(properties);
		
		//Mapping class
		cfg.addAnnotatedClass(Account.class);
		
		ServiceRegistry registry=new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(registry);
		
		return factory;
		
	}
	
}