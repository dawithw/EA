import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main (String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        //employeeLaptop();
        //flightPassenger();
        studentSchool();
    }

    private static void studentSchool() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        School school = new School("Maharishi University of Management", "Fairfield, IA");

        Student s1 = new Student("Dawit", "100-1100");
        Student s2 = new Student("Gebre", "100-1200");
        Student s3 = new Student("Andy", "100-1300");
        Student s4 = new Student("Bire", "100-1400");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);
        school.addStudent(s4);

        em.persist(school);

        em.getTransaction().commit();
        em.close();
        displayDB(new School());
    }

    public static void flightPassenger() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Passenger p1 = new Passenger("Dawit H");
        Passenger p2 = new Passenger("Gebre G");
        Passenger p3 = new Passenger("Tina X");
        Passenger p4 = new Passenger("Abraham M");

        Flight f1 = new Flight("LAX", "MIA", "UA 123");
        Flight f2 = new Flight("NYC", "DSM", "AA 201");

        f1.addPassenger(p1);
        f1.addPassenger(p2);
        f2.addPassenger(p3);
        f2.addPassenger(p4);

        em.persist(f1);
        em.persist(f2);

        em.getTransaction().commit();
        em.close();

        displayDB(new Flight());
    }

    public static void employeeLaptop() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee e1 = new Employee("Dawit Woldegiorgis", 1045);
        Employee e2 = new Employee("Assad Saad", 1083);
        Employee e3 = new Employee("Elaine Guthrie", 9045);

        Laptop l1 = new Laptop("Dell", "Inspiron", 650);
        Laptop l2 = new Laptop("HP", "Pavillon", 850);
        Laptop l3 = new Laptop("Acer", "Argon", 700);
        Laptop l4 = new Laptop("MacBook", "Pro", 2200);
        Laptop l5 = new Laptop("Lenovo", "Latitude", 1100);
        Laptop l6 = new Laptop("Microsoft", "Surface", 950);

        e1.addLaptop(l2);
        e1.addLaptop(l3);
        e1.addLaptop(l6);
        e2.addLaptop(l1);
        e2.addLaptop(l5);
        e3.addLaptop(l4);

        em.persist(e1);
        em.persist(e2);
        em.persist(e3);

        em.getTransaction().commit();
        em.close();

        displayDB(new Employee());
    }

    public static <T> void displayDB(T obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<T> list = em.createQuery("from " + obj.getClass().getName()).getResultList();
        list.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
