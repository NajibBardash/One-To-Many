package se.yrgo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Employee;
import se.yrgo.domain.Employer;

/**
 * This main-class creates a SessionFactory.
 * Then at first run we should have "create" in the hibernate.cfg.xml
 * to create the employers, employees and adding employees to an employer.
 * In the second run change to "update" to retrieve the list of employees from the employer.
 */
public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Employer employer = new Employer("Spotify AB");
        Employee employee = new Employee("Najib Bardash");
        Employee employee2 = new Employee("Eva Larsson");

        employer.addEmployee(employee);
        employer.addEmployee(employee2);

        session.save(employer);
        session.save(employee);
        session.save(employee2);

//        Employer employer = session.get(Employer.class, 1L);
//
//        for (Employee employee : employer.getEmployees()) {
//            System.out.println(employee);
//        }

        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}