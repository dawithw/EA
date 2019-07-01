package entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.core.config.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String origin;
    private String destination;
    private String flightID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    @OrderColumn(name = "sequence")
    private List<Passenger> passengers;

    public Flight(String origin, String destination, String flightID) {
        this.origin = origin;
        this.destination = destination;
        this.flightID = flightID;
    }

    public void addPassenger(Passenger p) {
        if (passengers == null)
            passengers = new ArrayList<>();
        passengers.add(p);
    }

    public void removePassenger(Passenger p) {
        passengers.remove(p);
    }

    public String toString() {
        String str = flightID + " " + origin + " -> " + destination + " Passengers: <";
        for(Passenger p : passengers) {
            str += p + ", ";
        }
        return str.substring(0,str.length()-1) + ">";
    }
}
