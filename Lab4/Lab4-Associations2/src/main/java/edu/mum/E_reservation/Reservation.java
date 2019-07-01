/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.E_reservation;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Reservation() {
    }



    public Reservation(Date date, Book book) {
        this.date = date;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }



}
