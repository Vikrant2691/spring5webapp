package guru.springframework.spring5webapp.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String AddressLine1;
    private String city;
    private String state;
    private String zip;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher_address;

    public Address(String addressLine1, String city, String state, String zip) {
        AddressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Publisher getPublisher_address() {
        return publisher_address;
    }

    public void setPublisher_address(Publisher publisher_address) {
        this.publisher_address = publisher_address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
