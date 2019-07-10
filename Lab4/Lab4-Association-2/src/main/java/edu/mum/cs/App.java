package edu.mum.cs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.mum.cs.domain.a.Department;
import edu.mum.cs.domain.a.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    private static EntityManagerFactory emf;
    public static void main( String[] args )
    {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee e1 = new Employee("Dawit","100-100");
        Employee e2 = new Employee("Alex", "100-201");
        Employee e3 = new Employee("Gebre", "100-402");

        Department d1 = new Department("ComPro");

        em.persist(d1);

        em.getTransaction().commit();
        em.close();
    }
}
