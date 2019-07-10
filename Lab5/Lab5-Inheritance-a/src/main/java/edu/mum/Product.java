package edu.mum;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String desction;

    public Product(){}


    public Product(String name, String desction) {

        this.name = name;
        this.desction = desction;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesction() {
        return desction;
    }

    public void setDesction(String desction) {
        this.desction = desction;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desction='" + desction + '\'' +
                '}';
    }
}
