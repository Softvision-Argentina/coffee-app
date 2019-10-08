package main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 4894729030347835498L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private int documentNumber;
    private int quantityOfPurchases;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getQuantityOfPurchases() {
        return quantityOfPurchases;
    }

    public void setQuantityOfPurchases(int quantityOfPurchases) {
        this.quantityOfPurchases = quantityOfPurchases;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client(long id, String firstName, String lastName, int documentNumber, int quantityOfPurchases, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
        this.quantityOfPurchases = quantityOfPurchases;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", documentNumber=" + documentNumber +
                ", quantityOfPurchases=" + quantityOfPurchases +
                ", address='" + address + '\'' +
                '}';
    }
}
