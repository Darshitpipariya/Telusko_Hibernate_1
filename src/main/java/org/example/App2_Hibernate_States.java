package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App2_Hibernate_States {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Laptop.class);

        ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory=configuration.buildSessionFactory(registry);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student s=new Student();
        StudentName s_name=new StudentName("fname "+1,"mname "+1,"lname "+1);
        s.setName(s_name);
        s.setGrade("1");
        s.setRollnum("MT202201");
        session.save(s);
        s.setName(new StudentName("Darshit","Karamshibhai","pipariya"));//this will be udated as it is in persistnat state
        transaction.commit();
        //detach object "s"  after commit we don't need detach method
        session.detach(s);
        s.setGrade("10");//not updated in database as it is detached state to store it we have to go back to persitant state


    }
}
