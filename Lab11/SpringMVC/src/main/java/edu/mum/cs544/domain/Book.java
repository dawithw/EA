package edu.mum.cs544.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String isbn;
    private String author;
    private double price;
}