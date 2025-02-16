package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setAid(105);
        a1.setAname("Soumik");
        a1.setTech("JAVA");

        SessionFactory factory = new Configuration().addAnnotatedClass(Alien.class).configure().buildSessionFactory();
        Session session = factory.openSession();

        // Transaction to create an entry
        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        transaction.commit();

        // Commented out: Update operation
        /*
        Transaction transactionUpdate = session.beginTransaction();
        a1.setAname("Updated Name");
        session.update(a1);
        transactionUpdate.commit();
        */

        // Commented out: Delete operation
        /*
        Transaction transactionDelete = session.beginTransaction();
        session.delete(a1);
        transactionDelete.commit();
        */

        // Commented out: Read operation
        /*
        Transaction transactionRead = session.beginTransaction();
        Alien retrievedAlien = session.get(Alien.class, 104);
        System.out.println(retrievedAlien);
        transactionRead.commit();
        */

        session.close();
        factory.close();
    }
}
