package edu.mum.cs544.service;

import edu.mum.cs544.domain.Student;

public interface IStudentService {
    public Student getStudent(long studentId);
}