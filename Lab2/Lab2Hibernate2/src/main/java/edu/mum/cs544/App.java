package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        initPersistenceContext();
        printStudents();
        addStudent();
        printStudents();
    }

    public static void initPersistenceContext() {
        emf = Persistence.createEntityManagerFactory("simpsons");
    }

    public static void printStudents() {

        //Open a EntityManager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Retrieve all students from the database and display their names important: your query needs to be: from edu.mum.cs544.Students
        List<Students> students = em.createQuery("from edu.mum.cs544.Students", Students.class).getResultList();
        for (Students student : students) {
            System.out.println(student.getName());
        }
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();
    }

    public static void addStudent() {

        // Open a EntityManager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Add an extra student to the database (you can choose his / her name)
        Students newStudent = new Students();
        newStudent.setId(109);
        newStudent.setName("Dawit");
        newStudent.setEmail("dawit@fox.com");
        newStudent.setPassword("dawit");

        em.persist(newStudent);

        // Close the EntityManager
        em.getTransaction().commit();
        em.close();
    }
}
