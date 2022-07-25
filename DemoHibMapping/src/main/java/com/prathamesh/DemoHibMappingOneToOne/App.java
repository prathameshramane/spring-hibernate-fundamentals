package com.prathamesh.DemoHibMappingOneToOne;

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
        Student s = new Student(101, "Gauresh", "Rane");
        Laptop l = new Laptop(201, "Macbook");
        s.setLaptop(l);
        
        Configuration cfg = new Configuration().configure()
        		.addAnnotatedClass(Student.class)
        		.addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(l);
        session.save(s);
        
        tx.commit();
        
    }
}
