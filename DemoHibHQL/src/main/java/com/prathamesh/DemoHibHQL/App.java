package com.prathamesh.DemoHibHQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    	  Configuration cfg = new Configuration().configure()
          		.addAnnotatedClass(Student.class);
          ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
          SessionFactory sf = cfg.buildSessionFactory(reg);
          
          Session session = sf.openSession();
          Transaction tx = session.beginTransaction();
//          
//          Query q = session.createQuery("from Student");
//          List<Student> ls = q.list();
//          for(Student s : ls) {
//        	  System.out.println(s);
//          }
          
//          Query q = session.createQuery("from Student where rollNo=103");
//          Student s = (Student)q.uniqueResult();
//          System.out.println(s);
          
          SQLQuery q = session.createSQLQuery("SELECT * FROM student");
          q.addEntity(Student.class);
          List<Student> ls = q.list();
        for(Student s : ls) {
      	  System.out.println(s);
        }
          
          tx.commit();
    }
}
