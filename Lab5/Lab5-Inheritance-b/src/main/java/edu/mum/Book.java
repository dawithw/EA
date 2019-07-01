package edu.mum;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Book extends Product {

    private String title;


    public Book(String name, String desction, String title) {
        super(name, desction);
        this.title = title;
    }
}
