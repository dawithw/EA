package edu.mum.cs544.dao;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;

import edu.mum.cs544.domain.Course;
import edu.mum.cs544.domain.Student;

public class StudentDAO implements IStudentDAO {

	public Student load(long studentid) {
        EntityManager em = EntityManagerHelper.getCurrent();
        EntityGraph<Student> graph = em.createEntityGraph(Student.class);
        graph.addAttributeNodes("firstname");
        graph.addAttributeNodes("lastname");
        Subgraph<Course> courselist = graph.addSubgraph("courselist");
        courselist.addAttributeNodes("name");
        courselist.addAttributeNodes("grade");
        TypedQuery<Student> query = em.createQuery("from Student s where s.id=:studentId",Student.class);
        query.setParameter("studentId", studentid);
        query.setHint("javax.persistence.fetchgraph",graph);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
	}
}
