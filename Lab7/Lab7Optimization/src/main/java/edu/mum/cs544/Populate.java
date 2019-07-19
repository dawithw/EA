package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populate {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        for (int x = 0; x < 100000; x++) {
            if (x%1000 == 0) {
                if (x%10000 == 0) System.out.print(x/1000 + "%"); else System.out.print(".");
            }
            Owner owner = new Owner("Frank" + x);
            List<Pet> petlist = new ArrayList<Pet>();
            for (int y = 0; y < 10; y++) {
                Pet pet = new Pet("Garfield" + x + "-" + y);
                petlist.add(pet);
            }
            owner.setPets(petlist);
            em.persist(owner);
        }
        System.out.println("100%");
        em.getTransaction().commit();
        em.close();
    }

}
