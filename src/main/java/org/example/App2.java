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
public class App2
{
    public static void main( String[] args )
    {
        System.out.println("Hello World");
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        for(int i=0;i<10;i++){
            Student s=new Student();
            StudentName s_name=new StudentName("fname "+i,"mname "+i,"lname "+i);
            s.setName(s_name);
            s.setGrade(""+i);
            s.setRollnum("MT20220"+i);
            session.save(s);
        }
        transaction.commit();
        session.close();

        // fetch data by Query
        Session s=sessionFactory.openSession();
        Transaction t=s.beginTransaction();
        Query q=s.createQuery("from Student ");
        List<Student> students=q.list();
        for(Student st:students){
            System.out.println(st);
        }

        Query q1=s.createQuery("from Student where rollnum between 'MT202205' and 'MT202209'");
        List<Student> students1=q1.list();
        for(Student st:students1){
            System.out.println(st);
        }

        Query q2=s.createQuery("select name from Student where rollnum='MT202205'");
        StudentName stu=(StudentName) q2.uniqueResult();
        System.out.println(stu);

        t.commit();


    }
}
