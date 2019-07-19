package edu.mum.cs544.service;

import javax.persistence.EntityManager;

import edu.mum.cs544.dao.EntityManagerHelper;
import edu.mum.cs544.dao.IStudentDAO;
import edu.mum.cs544.dao.StudentDAO;
import edu.mum.cs544.domain.Student;

public class StudentService implements IStudentService {
    
    private IStudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Student student = studentdao.load(studentid);
        System.out.println("getStudentgetStudentgetStudentgetStudentgetStudentgetStudent");
        em.getTransaction().commit();
        em.close();
        return student;
	}
}
