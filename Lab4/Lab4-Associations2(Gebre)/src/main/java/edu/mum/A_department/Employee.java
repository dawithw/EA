package edu.mum.A_department;

import edu.mum.F_office.Office;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeenumber;
    private String name;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Office office;

    public Employee() {
    }

    public Employee(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public long getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(long employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public Office getOffice() {
//        return office;
//    }
//
//    public void setOffice(Office office) {
//        this.office = office;
//    }

}
