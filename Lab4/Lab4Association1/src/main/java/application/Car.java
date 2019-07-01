package application;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Car {
	@Id
	@GeneratedValue
	private long id;
	private String brand;
	private String year;
	private double price;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;

	public Car() {
	}

	public Car(String brand, String year, double price) {
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	public String toString() {
	    String desc = "Brand: " + brand +
                "  Year: " + year +
                "  Price: " + price +
                "  Owner: [" + owner + "]";
	    return desc;
    }
}
