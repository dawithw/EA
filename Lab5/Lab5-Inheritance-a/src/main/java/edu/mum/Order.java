package edu.mum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name="ord_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Date orderDate;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    private Customer customer;

    @OneToMany(cascade =  CascadeType.PERSIST )
    @JoinColumn(name = "order_Id")
    private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

    public Order(){}

    public Order( Date orderDate, Customer customer) {
        this.orderDate = orderDate;
        this.customer = customer;

    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(Collection<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }
    public boolean addOrderLine(OrderLine ol) {
        return orderlines.add(ol);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                ", orderlines=" + orderlines +
                '}';
    }
}
