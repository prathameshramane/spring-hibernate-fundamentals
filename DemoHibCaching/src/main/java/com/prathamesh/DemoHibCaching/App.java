package com.prathamesh.DemoHibCaching;

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
        
        //First Level Caching By Default
        Alien a1 = (Alien) s1.get(Alien.class, 100);
        System.out.println(a1);
        Alien a2 = (Alien) s1.get(Alien.class, 100);
        System.out.println(a2);
        
        tx1.commit();
        
        
        Session s2 = sf.openSession();
        Transaction tx2 = s2.beginTransaction();
        
        //Second Level Caching Through EhCache
        Alien a3 = (Alien) s2.get(Alien.class, 100);
        System.out.println(a3);
        Alien a4 = (Alien) s2.get(Alien.class, 100);
        System.out.println(a4);
        
        tx2.commit();
    }
}
