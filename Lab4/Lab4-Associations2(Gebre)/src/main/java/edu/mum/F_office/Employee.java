package edu.mum.F_office;


import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long en;
    private String name;
    private String phone;
    @ManyToOne
    @JoinTable(name = "employee_office_bitable")
    private Office office;

    public Employee() {
    }

    public Employee(String name, String phone) {
        this.name = name;
        this.phone = phone;
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

}
