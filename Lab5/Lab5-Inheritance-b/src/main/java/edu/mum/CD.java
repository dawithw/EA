package edu.mum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class CD extends Product {
    private String artist;


    public CD(String name, String desction, String artist) {
        super(name, desction);
        this.artist = artist;
    }
}
