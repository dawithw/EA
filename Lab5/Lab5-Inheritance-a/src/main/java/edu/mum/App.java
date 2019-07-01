package edu.mum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        Customer c = new Customer("Dawit", "Kebede");
        Order o1 = new Order(new Date(),c);
       // em.persist(o1);
        Product p= new Product("Laptop","newOne");
       // em.persist(p);
        OrderLine ol1 = new OrderLine(2,p);
        o1.addOrderLine(ol1);
        c.addOrder(o1);
        em.persist(c);
       // em.persist(p);
        em.getTransaction().commit();
        em.close();

        em= emf.createEntityManager();
        em.getTransaction().begin();


        @SuppressWarnings("unchecked")
        List<Order> orderList = em.createQuery("from Order").getResultList();
        for (Order order : orderList) {
           System.out.println(order.getCustomer());
        }
        em.getTransaction().commit();
        em.close();

    }


    }


