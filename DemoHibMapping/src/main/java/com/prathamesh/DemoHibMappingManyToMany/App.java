package com.prathamesh.DemoHibMappingManyToMany;

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
        Student s1 = new Student(101, "Gauresh", "Rane");
        Student s2 = new Student(102, "Prathamesh", "Ramane");
        Laptop l1 = new Laptop(201, "Macbook");
        Laptop l2 = new Laptop(202, "Asus");
        Laptop l3 = new Laptop(203, "Dell");
        
        s1.getLaptop().add(l1);
        s1.getLaptop().add(l2);
        s2.getLaptop().add(l1);
        s2.getLaptop().add(l3);
        
        l1.getStudent().add(s1);
        l1.getStudent().add(s2);
        l2.getStudent().add(s1);
        l3.getStudent().add(s2);
        
        
        Configuration cfg = new Configuration().configure()
        		.addAnnotatedClass(Student.class)
        		.addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
//        session.save(s1);
//        session.save(s2);
//        session.save(l1);
//        session.save(l2);
//        session.save(l3);
        
        Student s = (Student) session.get(Student.class, 101);
        System.out.println(s.getLaptop().toString());
       
        tx.commit();
      
    }
}
