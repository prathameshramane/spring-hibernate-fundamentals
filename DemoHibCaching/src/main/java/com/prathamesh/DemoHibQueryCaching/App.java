package com.prathamesh.DemoHibQueryCaching;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(reg);
        
        Session s1 = sf.openSession();
        Transaction tx1 = s1.beginTransaction();
        
        Query q1 = s1.createQuery("from Alien where aid=100");
        q1.setCacheable(true);
        Alien a1 = (Alien) q1.uniqueResult();
        System.out.println(a1);
        
        tx1.commit();
        
        
        Session s2 = sf.openSession();
        Transaction tx2 = s2.beginTransaction();
        
        Query q2 = s2.createQuery("from Alien where aid=100");
        q2.setCacheable(true);
        Alien a2 = (Alien) q2.uniqueResult();
        System.out.println(a2);
        
        tx2.commit();
    }
}
