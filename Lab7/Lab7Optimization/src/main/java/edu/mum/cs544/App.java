package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        System.out.print("String = ");
        joinFetchData();
        System.out.print("Named Query = ");
        namedQuery();
        System.out.print("Entity Graph = ");
        entityGraph();
        System.out.print("String = ");
        joinFetchData();
        System.out.print("Named Query = ");
        namedQuery();
        System.out.print("Entity Graph = ");
        entityGraph();
        System.out.print("String = ");
        joinFetchData();
        System.out.print("Named Query = ");
        namedQuery();
        System.out.print("Entity Graph = ");
        entityGraph();
        System.out.print("String = ");
        joinFetchData();
        System.out.print("Named Query = ");
        namedQuery();
        System.out.print("Entity Graph = ");
        entityGraph();
        System.out.print("String = ");
        joinFetchData();
        System.out.print("Named Query = ");
        namedQuery();
        System.out.print("Entity Graph = ");
        entityGraph();
        System.exit(0);
    }

    private static void fetchData() {
        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
    }

    private static void joinFetchData() {
        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //StringClass queryString = new StringClass("from Owner o join fetch o.pets");
        TypedQuery<Owner> query = em.createQuery("from Owner o join fetch o.pets", Owner.class);
        //TypedQuery<Owner> query = em.createNamedQuery("Owner.Pets", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
    }

    private static void namedQuery() {
        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        TypedQuery<Owner> query = em.createNamedQuery("Owner.Pets", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
    }

    private static void entityGraph() {
        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        EntityGraph<Owner> eGraph = em.createEntityGraph(Owner.class);
        eGraph.addSubgraph("pets");
        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
        query.setHint("javax.persistence.fetchgraph", eGraph);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
    }

}
