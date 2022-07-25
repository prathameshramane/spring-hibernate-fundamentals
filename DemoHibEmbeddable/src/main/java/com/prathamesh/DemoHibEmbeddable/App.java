package com.prathamesh.DemoHibEmbeddable;

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
    	AlienName aname = new AlienName();
    	aname.setFname("Prathamesh");
    	aname.setLname("Ramane");
    	aname.setMname("Pradeep");
    	Alien ryder = new Alien();
    	ryder.setAid(100);
    	ryder.setAname(aname);
        ryder.setColor("Green");
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	SessionFactory sf = cfg.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
//    	session.save(ryder);
    	
//    	Alien a = (Alien) session.get(Alien.class, 100);
//    	System.out.println(a.getAname());
    	
    	tx.commit();
    }
}
