package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Student;

public interface IStudentDAO {
	public Student load(long studentid);
}
