package edu.mum.E_reservation;




import edu.mum.E_reservation.Reservation;

import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppE_Reservation {

    private static EntityManagerFactory emf;


    public static void main(String[] args) throws Exception {
       emf= Persistence.createEntityManagerFactory("cs544");
        EntityManager em= emf.createEntityManager();
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = new Book("123432123", "Java Patterns", "Sam Cooke");
        em.persist(book);
        Reservation reservation1= new Reservation(new Date(),book);
        em.persist(reservation1);
        Reservation reservation2= new Reservation(new Date(),book);
        em.persist(reservation2);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
       @SuppressWarnings("unchecked")
        Collection<Reservation> reservations = em.createQuery("from Reservation ").getResultList();
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getBook().getAuthor()+" "+reservation.getBook().getTitle()+" "+
                    reservation.getBook().getIsbn()+" "+ reservation.getDate());

        }

        em.getTransaction().commit();
        em.close();
    }
}
