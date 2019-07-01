package app;

import domain.Car;
import domain.Owner;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab4");

        createCars();
    }

    public static void createCars() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create owner
        Owner owner = new Owner();
        owner.setName("Dawit Woldegiorgis");
        owner.setAddress("Maharishi University, Bldg 144");

        // Create cars and persist
        Car car1 = new Car();
        car1.setBrand("Mercedes");
        car1.setPrice(40000);
        car1.setYear("2017");
        car1.setOwner(owner);
        em.persist(car1);

        Car car2 = new Car();
        car2.setBrand("Volkswagen");
        car2.setPrice(25000);
        car2.setYear("2012");
        car2.setOwner(owner);
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

    }

    public static void displayCars() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Car> cars = em.createQuery("from Cars", Car.class).getResultList();
    }
}
