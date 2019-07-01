/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.D_customer;

import java.util.Date;
import javax.persistence.*;

//@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    public Reservation() {
    }

    public Reservation(Date date) {
        this.date = date;
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



}
