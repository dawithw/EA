/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.F_office;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
//@Table(name="Office")
public class Office {

    @Id
    private String rn;
    private String building;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees = new ArrayList<Employee>();

    public Office() {
    }

    public Office(String rn, String building) {
        this.rn = rn;
        this.building = building;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String roomnumber) {
        this.rn = roomnumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
        e.setOffice(this);
    }

    public void removeEmployee(Employee e) {
        this.employees.remove(e);
        e.setOffice(null);
    }
//    public void addCar(Car car) {
//        cars.add(car);
//        car.setPerson(this);
//    }
}
