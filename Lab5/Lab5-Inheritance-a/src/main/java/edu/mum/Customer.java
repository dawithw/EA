package edu.mum;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade =  CascadeType.PERSIST )
    @JoinColumn(name = "orders_Id")
    private List<Order> orders = new ArrayList<Order>();

    public Customer(){}


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Order> getOrders() {
       return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean addOrder(Order order) {
        boolean added = orders.add(order);
        if (added) {
            order.setCustomer(this);
        }
        return added;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
