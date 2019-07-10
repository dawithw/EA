package util;

import javax.persistence.EntityManager;

import domain.Person;

public class Populate {
    public static void generateEntities(EntityManager em) {
        em.getTransaction().begin();
        for(int i = 0; i < 100000; ++i) {
            if (i%10000 == 0) System.out.print(i/1000 + "% ");
            else if (i%1000 == 0) System.out.print(".");
            Person p = new Person(generateName(i));
            em.persist(p);
        }
        System.out.println("100%");
        em.getTransaction().commit();
        em.close();
        System.out.println("Done");
    }

    public static String generateName(int i) {
        return "Name " + i;
    }
}