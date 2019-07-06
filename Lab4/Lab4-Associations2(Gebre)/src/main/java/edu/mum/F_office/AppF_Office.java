package edu.mum.F_office;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppF_Office {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Employee employee1 = new Employee("Tariku Abreham", "87976544567");
        Employee employee2 = new Employee("Hareg Reda", "7886767876");
        Office office = new Office("V47", "veryHall");

        office.addEmployee(employee1);
        office.addEmployee(employee2);
        em.persist(office);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        Collection<Office> officeList = em.createQuery("from Office ").getResultList();
        for (Office off : officeList) {
            System.out.println("Office Location: " + off.getRn()+" in building: "+ off.getBuilding());
            for (Employee emp : off.getEmployees()) {
                System.out.println("laptop brand= " + emp.getName()+" "+ emp.getPhone());
            }
        }

        em.getTransaction().commit();
                em.close();
            }
        }

