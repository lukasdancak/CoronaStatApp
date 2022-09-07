package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SlovakiaVaccinations {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    String id;    //   title: Interné id záznamu

    @Column(nullable = false)
    int dose1Count;     //title: Počet podaných prvých dávok vakcín pre daný deň

    @Column(nullable = false)
    int dose2Count;   //title: Počet podaných druhých dávok vakcín pre daný deň

    @Column(nullable = false)
    int dose1Sum;    //title: Súčet podaných prvých dávok vakcín od začiatku vakcinácie do daného dňa

    @Column(nullable = false)
    int dose2Sum;     //title: Súčet podaných druhých dávok vakcín od začiatku vakcinácie do daného dňa

    @Column(nullable = false)
    Date updatedAt;     //($date-time)    title: Čas poslednej aktualizácie záznamu
    // (čas poslednej zmeny hodnoty niektorého z atribútov záznamu)
    //example: 2020-01-13 12:34:56

    @Column(nullable = false)
    Date publishedOn;   //($date-time)     title: Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    // example: 2020-01-13


    public SlovakiaVaccinations() {
    }

    public SlovakiaVaccinations(int dose1Count, int dose2Count, int dose1Sum, int dose2Sum, Date updatedAt, Date publishedOn) {
        this.dose1Count = dose1Count;
        this.dose2Count = dose2Count;
        this.dose1Sum = dose1Sum;
        this.dose2Sum = dose2Sum;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDose1Count() {
        return dose1Count;
    }

    public void setDose1Count(int dose1Count) {
        this.dose1Count = dose1Count;
    }

    public int getDose2Count() {
        return dose2Count;
    }

    public void setDose2Count(int dose2Count) {
        this.dose2Count = dose2Count;
    }

    public int getDose1Sum() {
        return dose1Sum;
    }

    public void setDose1Sum(int dose1Sum) {
        this.dose1Sum = dose1Sum;
    }

    public int getDose2Sum() {
        return dose2Sum;
    }

    public void setDose2Sum(int dose2Sum) {
        this.dose2Sum = dose2Sum;
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
}
