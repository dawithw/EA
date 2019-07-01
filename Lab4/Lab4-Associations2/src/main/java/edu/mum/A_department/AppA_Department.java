package edu.mum.A_department;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppA_Department {

    private static EntityManagerFactory emf;


    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
         EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
       Department department = new Department("computer Scince");
       Employee employee1 = new Employee("Kebede Hailu","2322344543");
        Employee employee2 = new Employee("Blen Tadese", "4324362738");
        department.addEmployee(employee1);
        department.addEmployee(employee2);
        employee1.setDepartment(department);
        employee2.setDepartment(department);
        em.persist(department);
        em.getTransaction().commit();
        em.close();
        em = emf.createEntityManager();
       em.getTransaction().begin();

        @SuppressWarnings("unchecked")
        Collection<Department> departmentList = em.createQuery("from Department").getResultList();
        for (Department dept : departmentList) {
            System.out.println("department name = " + dept.getName());
            for (Employee empl : dept.getEmployeelist()) {
                System.out.println("employee name= " + empl.getName());
            }
        }
        System.out.println("---- now the reverse -----");
        @SuppressWarnings("unchecked")
        Collection<Employee> employeeList = em.createQuery("from Employee").getResultList();
        for (Employee empl : employeeList) {
            System.out.println("employee name= " + empl.getName());
            System.out.println("department name = " + empl.getDepartment().getName());
        }

        em.getTransaction().commit();
        em.close();
    }
}
