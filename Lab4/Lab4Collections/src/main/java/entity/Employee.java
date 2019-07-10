package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long empId;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @OrderBy(value = "brand")
    private Set<Laptop> laptops;

    public Employee(String name, long id) {
        this.name = name;
        this.empId = id;
    }

    public void addLaptop(Laptop l) {
        if (laptops == null) {
            laptops = new HashSet<Laptop>();
        }
        if (laptops.add(l))
                l.setOwner(this);
    }

    public void removeLaptop(Laptop l) {
        if (laptops.remove(l))
            l.setOwner(null);
    }

    public String toString() {
        String str = "Employee ID: " + empId + "  Name: " + name + "  Laptops: | ";
        for(Laptop l : laptops) {
            str += l.toString() + " | ";
        }
        return str;
    }
}
