package me.rory.petadoptionagencydb.petadoptionagency.pethistory;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name = "pethistory")
public class PetHistory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer historyID;

        @Column(nullable = false)
        private Integer petID;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Temporal(TemporalType.DATE)
        @Column(name = "entrydate", nullable = false)
        private Date entryDate;

        @Lob
        @Column(nullable = true)
        private String notes;

        public Integer getHistoryID() {
                return historyID;
        }

        public void setHistoryID(Integer historyID) {
                this.historyID = historyID;
        }

        public Integer getPetID() {
                return petID;
        }

        public void setPetID(Integer petID) {
                this.petID = petID;
        }

        public Date getEntryDate() {
                return entryDate;
        }

        public void setEntryDate(Date entryDate) {
                this.entryDate = entryDate;
        }

        public String getNotes() {
                return notes;
        }

        public void setNotes(String notes) {
                this.notes = notes;
        }

        @Override
        public String toString() {
                return "PetHistory{" +
                        "historyID=" + historyID +
                        ", petID=" + petID +
                        ", entryDate=" + entryDate +
                        ", notes='" + notes + '\'' +
                        '}';
        }
    }

