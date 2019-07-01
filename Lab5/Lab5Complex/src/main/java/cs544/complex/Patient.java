package cs544.complex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name="address")
//@SecondaryTables({
//    @SecondaryTable(name = "address",
//            pkJoinColumns = {
//                @PrimaryKeyJoinColumn(name = "patient_id", referencedColumnName = "id")}
//    )})
public class Patient {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;
    @Column(name="NAME")
    private String name;
    @Column(table = "address",name="STREET")
    private String street;
    @Column(table = "address",name="ZIP")
    private String zip;
    @Column(table = "address",name="CITY")
    private String city;

    public Patient() {
    }

    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "name=" + name + "  address=" + street + ", " + city + " " + zip;
    }
}
