package edu.mum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "oline_table")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quenttity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    public OrderLine(){}

    public OrderLine(int quenttity,  Product product) {
        this.quenttity = quenttity;

        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuenttity() {
        return quenttity;
    }

    public void setQuenttity(int quenttity) {
        this.quenttity = quenttity;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "quenttity=" + quenttity +
                ", product=\n\t" + product +
                '}';
    }
}
