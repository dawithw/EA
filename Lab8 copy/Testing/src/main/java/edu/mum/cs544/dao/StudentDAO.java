package main.java.edu.mum.cs544.dao;

import javax.persistence.EntityManager;

import edu.mum.cs544.domain.Student;

public class StudentDAO implements IStudentDAO {

	public Student load(long studentid) {
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.find(Student.class, studentid);
	}
}
