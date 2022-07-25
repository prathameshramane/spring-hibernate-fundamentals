package com.prathamesh.DemoHibAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	Alien ryder = new Alien();
        ryder.setAname("Yash");
        ryder.setColor("Green");
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	SessionFactory sf = cfg.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(ryder);
    	tx.commit();
    	
    }
}
