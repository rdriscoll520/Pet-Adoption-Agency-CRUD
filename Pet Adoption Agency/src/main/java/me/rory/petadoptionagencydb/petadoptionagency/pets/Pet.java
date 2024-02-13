package me.rory.petadoptionagencydb.petadoptionagency.pets;
import jakarta.persistence.*;
    @Entity
    @Table(name = "pets")
    public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer petID;

        @Column(name = "petname", nullable = false, length = 255)
        private String petName;

        @Column(nullable = false, length = 255)
        private String species;

        @Column(nullable = false, length = 255)
        private String breed;

        @Column(nullable = false)
        private Integer age;

        @Column(nullable = false, length = 1)
        private String sex;

        @Column(name = "adoptionstatus", nullable = false, length = 50)
        private String adoptionStatus = "Available";

        public Integer getPetID() {
            return petID;
        }

        public void setPetID(Integer petID) {
            this.petID = petID;
        }

        public String getPetName() {
            return petName;
        }

        public void setPetName(String petName) {
            this.petName = petName;
        }

        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAdoptionStatus() {
            return adoptionStatus;
        }

        public void setAdoptionStatus(String adoptionStatus) {
            this.adoptionStatus = adoptionStatus;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "petID=" + petID +
                    ", petName='" + petName + '\'' +
                    ", species='" + species + '\'' +
                    ", breed='" + breed + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    ", adoptionStatus='" + adoptionStatus + '\'' +
                    '}';
        }


}
