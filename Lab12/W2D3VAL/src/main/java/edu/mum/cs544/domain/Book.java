package edu.mum.cs544.domain;

import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    @SafeHtml
    private String title;
    @ISBN
    private String isbn;
    @NotBlank
    @SafeHtml
    private String author;
    @Positive
    private double price;
}