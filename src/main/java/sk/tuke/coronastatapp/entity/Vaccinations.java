package sk.tuke.coronastatapp.entity;

import javax.persistence.*;

@Entity
public class Vaccinations {

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "Vaccine.id")
    int vaccineId;  // integer title: Interné id vakcíny z /api/vaccines

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "Region.id")
    int regionId;   // integer title: Interné id regiónu z regiónov z /api/ regions alebo null.
    // Hodnota null znamená, že dáta  nie sú priradené žiadnemu kraju.

    @Id
    @Column(nullable = false)
    //@GeneratedValue //??? ma to byt Generated Value ?
    String id; // string title: Interné id záznamu
    int dose1_count;    // integer title: Počet podaných prvých dávok vakcín pre daný deň, kraj a typ vakcíny

    @Column(nullable = false)
    int dose2Count;     // integer title: Počet podaných druhých dávok vakcín pre daný deň, kraj a typ vakcíny

    @Column(nullable = false)
    String updatedAt;   //string($date-time) title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty
    // niektorého z atribútov záznamu) example:2020-01-13 12:34:56

    @Column(nullable = false)
    String publishedOn; //string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    // example:2020-01-13


    public Vaccinations() {
    }

    public Vaccinations(int vaccineId, int regionId, int dose1_count, int dose2Count, String updatedAt, String publishedOn) {
        this.vaccineId = vaccineId;
        this.regionId = regionId;
        this.dose1_count = dose1_count;
        this.dose2Count = dose2Count;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getDose1_count() {
        return dose1_count;
    }

    public void setDose1_count(int dose1_count) {
        this.dose1_count = dose1_count;
    }

    public int getDose2Count() {
        return dose2Count;
    }

    public void setDose2Count(int dose2Count) {
        this.dose2Count = dose2Count;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Vaccinations{" +
                "vaccineId=" + vaccineId +
                ", regionId=" + regionId +
                ", id='" + id + '\'' +
                ", dose1_count=" + dose1_count +
                ", dose2Count=" + dose2Count +
                ", updatedAt='" + updatedAt + '\'' +
                ", publishedOn='" + publishedOn + '\'' +
                '}';
    }
}
