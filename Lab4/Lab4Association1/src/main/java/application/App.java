package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Owner owner = new Owner("Dawit Woldegiorgis","1000 N 4th St, Fairfield, IA 52557");

        Car car1 = new Car("BMW", "2015", 30221.00);
        car1.setOwner(owner);
        Car car2 = new Car("Mercedes", "2012", 24088.00);
        car2.setOwner(owner);

        em.persist(car2);
        em.persist(car1);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println(car);
        }
        em.getTransaction().commit();
        em.close();
    }
}

