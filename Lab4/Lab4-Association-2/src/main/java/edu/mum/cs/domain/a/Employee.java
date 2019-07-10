package edu.mum.cs.domain.a;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String empId;
    @ManyToOne
    // @JoinColumn(name = "employee_id")
    private Department department;

    public Employee(String name, String empId) {
        this.name = name;
        this.empId = empId;
    }
}