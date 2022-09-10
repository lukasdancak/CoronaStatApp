package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vaccination {


    @ManyToOne
    @JoinColumn(name = "Vaccine.id", nullable = false)
    private Vaccine vaccine;
    // integer title: Interné id vakcíny z /api/vaccines


    @ManyToOne
    @JoinColumn(name = "Region.id", nullable = false)
    private Region region;
    // integer title: Interné id regiónu z regiónov z /api/ regions alebo null.
    // Hodnota null znamená, že dáta  nie sú priradené žiadnemu kraju.

    @Id
    @Column(nullable = false)
    // preco je to String, ked v HospitalStaff je interne ID integer ?
    private String id;
    // string title: Interné id záznamu

    @Column(nullable = false)
    private int dose1_count;
    // integer title: Počet podaných prvých dávok vakcín pre daný deň, kraj a typ vakcíny

    @Column(nullable = false)
    private int dose2Count;
    // integer title: Počet podaných druhých dávok vakcín pre daný deň, kraj a typ vakcíny

    @Column(nullable = false)
    private Date updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty
    // niektorého z atribútov záznamu) example:2020-01-13 12:34:56

    @Column(nullable = false)
    private Date publishedOn;
    //string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    // example:2020-01-13


    public Vaccination() {
    }

    public Vaccination(Vaccine vaccineId, Region regionId, String id, int dose1_count,
                       int dose2Count, Date updatedAt, Date publishedOn) {
        this.vaccine = vaccineId;
        this.region = regionId;
        this.id = id;
        this.dose1_count = dose1_count;
        this.dose2Count = dose2Count;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vaccinations{" +
                "vaccineId=" + vaccine +
                ", regionId=" + region +
                ", id='" + id + '\'' +
                ", dose1_count=" + dose1_count +
                ", dose2Count=" + dose2Count +
                ", updatedAt='" + updatedAt + '\'' +
                ", publishedOn='" + publishedOn + '\'' +
                '}';
    }
}
