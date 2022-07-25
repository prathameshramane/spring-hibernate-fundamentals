package com.prathamesh.DemoHib;


import java.util.List;

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
        Alien ryder = new Alien();
        ryder.setAid(103);
        ryder.setAname("Vinita");
        ryder.setColor("Red");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
// 		Saving into database
// 		session.save(ryder); 
        
//			Get by ID
//        Alien a = (Alien) session.get(Alien.class, 100);
//        System.out.println(a);
        
//        Get list of data
//        Query query = session.createQuery("from Alien");
//        List<Alien> ls = query.list();
//        for(Alien a : ls) {
//        	System.out.println(a);
//        }
        
//        Update Color
//        Alien a = (Alien) session.get(Alien.class, 100);
//        a.setColor("Cyan");
        
//        Delete Record
        Alien a = (Alien) session.get(Alien.class, 100);
        session.delete(a);
        
        
        transaction.commit();
        
    }
}
