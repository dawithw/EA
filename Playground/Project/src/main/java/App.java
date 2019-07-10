import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;
import util.Populate;

public class App 
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("playground");
    public static void main( String[] args )
    {
        //Populate.generateEntities(emf.createEntityManager());
        long start = System.currentTimeMillis();
        get1000Members();
        System.out.println("Retrieved 1000 memebers in " + (System.currentTimeMillis() - start) + " ms.");
    }

    public static void get1000Members() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Person> people = em.createQuery("from Person p where p.name > 'Name 1000' and p.name < 'Name 2001'", Person.class).getResultList();
        people.forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }
}
