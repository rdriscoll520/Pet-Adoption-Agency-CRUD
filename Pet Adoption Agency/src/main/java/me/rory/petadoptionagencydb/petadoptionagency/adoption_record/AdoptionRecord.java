package me.rory.petadoptionagencydb.petadoptionagency.adoption_record;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "adoption_record")
public class AdoptionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordID;

    @Column(nullable = false)
    private Integer petID;

    @Column(nullable = false)
    private Integer adopterID;

    @Temporal(TemporalType.DATE)
    @Column(name = "adoptiondate", nullable = false)
    private LocalDate adoptionDate;

    @Column(nullable = false)
    private Integer staffID;

    public Integer getRecordID() {
        return recordID;
    }

    public void setRecordID(Integer recordID) {
        this.recordID = recordID;
    }

    public Integer getPetID() {
        return petID;
    }

    public void setPetID(Integer petID) {
        this.petID = petID;
    }

    public Integer getAdopterID() {
        return adopterID;
    }

    public void setAdopterID(Integer adopterID) {
        this.adopterID = adopterID;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    // Getters and setters are not shown but should be included

    @Override
    public String toString() {
        return "AdoptionRecord{" +
                "recordID=" + recordID +
                ", petID=" + petID +
                ", adopterID=" + adopterID +
                ", adoptionDate=" + adoptionDate +
                ", staffID=" + staffID +
                '}';
    }
}

