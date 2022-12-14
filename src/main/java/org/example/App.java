package org.example;

//import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Laptop l1=new Laptop(1,"LenovoIdeaPad520");
        Laptop l2=new Laptop(2,"MacbookPro2021");
        Laptop l3=new Laptop(3,"Vivobookpro123");
        Laptop l4=new Laptop(4,"MacbookAir2022");

        Student st1=new Student();
        StudentName st1_name=new StudentName();
        st1_name.setF_name("Darshitkumar");
        st1_name.setM_name("Karamshibhai");
        st1_name.setL_name("Pipariya");
        st1.setName(st1_name);
        st1.setRollnum("MT2021001");
        st1.setGrade("2");


        st1.getLaptop_list().add(l1);
        st1.getLaptop_list().add(l2);
        l1.getStudents().add(st1);
        l2.getStudents().add(st1);

        Student st2=new Student();
        StudentName st2_name=new StudentName();
        st2_name.setF_name("Sajal");
        st2_name.setM_name("NA");
        st2_name.setL_name("Gupta");
        st2.setName(st2_name);
        st2.setRollnum("MT2022002");
        st2.setGrade("1");


        st2.getLaptop_list().add(l3);
        l3.getStudents().add(st2);
        l3.getStudents().add(st1);

        Student st3=new Student();
        StudentName st3_name=new StudentName();
        st3_name.setF_name("Prateek");
        st3_name.setM_name("NA");
        st3_name.setL_name("Chimval");
        st3.setName(st3_name);
        st3.setRollnum("MT2021003");
        st3.setGrade("3");


        st3.getLaptop_list().add(l4);
        l4.getStudents().add(st3);





        /*
            Creating Configuration object and configure it
            Creating ServiceRegistry object and apply configuration settings.
            Use configuration.buildSessionFactory() by passing ServiceRegistry object as argument to get the SessionFactory object.
        */

        // create the SessionFactory from hibernate.cfg.xml file in resource directory by default it uses hibernate.cfg.xml file name
        // if we have other file then we have to pass file in  .configure("hibernate.cfg.xml")
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(l1);
        session.save(l2);
        session.save(l3);
        session.save(l4);
        session.save(st1);
        session.save(st2);
        session.save(st3);
        transaction.commit();

//      fetch Data from database;

        Student student1=new Student();
        Transaction transaction1=session.beginTransaction();
        Query q1=session.createQuery("from Student where rollnum='MT2021001'");
        student1=(Student)q1.uniqueResult();

        //        student1=(Student) session.get(Student.class,"MT2021001");

        System.out.println(student1);
        transaction1.commit();
    }
}
