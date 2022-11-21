package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Student st1=new Student();
        StudentName st1_name=new StudentName();
        st1_name.setF_name("Darshitkumar");
        st1_name.setM_name("Karamshibhai");
        st1_name.setL_name("Pipariya");
        st1.setName(st1_name);
        st1.setRollnum("MT2021001");
        st1.setGrade("2");


        /*
            Creating Configuration object and configure it
            Creating ServiceRegistry object and apply configuration settings.
            Use configuration.buildSessionFactory() by passing ServiceRegistry object as argument to get the SessionFactory object.
        */

        // create the SessionFactory from hibernate.cfg.xml file in resource directory by default it uses hibernate.cfg.xml file name
        // if we have other file then we have to pass file in  .configure("hibernate.cfg.xml")
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(st1);
        transaction.commit();


//        Student st2=new Student();
//        Transaction transaction1=session.beginTransaction();
//        st2=(Student) session.get(Student.class,"MT2022035");
//        transaction1.commit();
//
//        System.out.println(st2);

    }
}
