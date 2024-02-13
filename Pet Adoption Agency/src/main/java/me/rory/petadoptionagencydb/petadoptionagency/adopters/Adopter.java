package me.rory.petadoptionagencydb.petadoptionagency.adopters;

import jakarta.persistence.*;

@Entity
@Table(name = "adopters")
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adopterID;

    @Column(name = "adoptername", nullable = false, unique = true, length = 255)
    private String adopterName;

    @Column(nullable = false, length = 11)
    private String SSN;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(name = "phonenumber", nullable = false, length = 13)
    private String phoneNumber;

    public Integer getAdopterID() {
        return adopterID;
    }

    public void setAdopterID(Integer adopterID) {
        this.adopterID = adopterID;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "adopterID=" + adopterID +
                ", adopterName='" + adopterName + '\'' +
                ", SSN='" + SSN + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

