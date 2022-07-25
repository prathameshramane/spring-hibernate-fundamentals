package com.prathamesh.DemoHibMappingOneToMany;

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
        Laptop l1 = new Laptop(201, "Macbook");
        Laptop l2 = new Laptop(202, "Asus");
        Laptop l3 = new Laptop(203, "Dell");
        s.getLaptop().add(l1);
        s.getLaptop().add(l2);
        s.getLaptop().add(l3);
        l1.setStudent(s);
        l2.setStudent(s);
        l3.setStudent(s);
        
        Configuration cfg = new Configuration().configure()
        		.addAnnotatedClass(Student.class)
        		.addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(s);
        session.save(l1);
        session.save(l2);
        session.save(l3);
       
        tx.commit();
      
    }
}
