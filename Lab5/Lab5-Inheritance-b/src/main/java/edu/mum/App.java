package edu.mum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        Order o2 = new Order(new Date(),c);
       // em.persist(o1);
        Product p= new Product("Laptop","newOne");
        Product b= new Book("EA","textbook","hibernet");
        Product cc= new CD("Song","cd","TedeAfro");
        Product d= new DVD("Movie","dvd","action");

       // em.persist(p);
        OrderLine ol1 = new OrderLine(22,p);
        OrderLine ol2 = new OrderLine(34,b);
        OrderLine ol3 = new OrderLine(4,cc);
        OrderLine ol4 = new OrderLine(7,d);
        OrderLine ol5 = new OrderLine(5,b);
        o1.addOrderLine(ol1);
        o1.addOrderLine(ol2);
        o2.addOrderLine(ol3);
        o2.addOrderLine(ol4);
        o2.addOrderLine(ol5);
        c.addOrder(o1);
        c.addOrder(o2);
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


