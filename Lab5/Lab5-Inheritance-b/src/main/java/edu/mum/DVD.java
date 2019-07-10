package edu.mum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DVD extends Product{

    private String genre;

    public DVD(String name, String desction, String genre) {
        super(name, desction);
        this.genre = genre;
    }
}
