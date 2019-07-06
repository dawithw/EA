package edu.mum.cs.domain.a;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "departments_id")
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee e) {
        if (employees == null)
            employees = new ArrayList<>();
        // e.setDepartment(this);
        employees.add(e);
    }

    public void removeEmployee(Employee e) {
        employees.remove(e);
    }
}