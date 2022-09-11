package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SlovakiaVaccination {

    @Id
    @Column(nullable = false)
    private String id;
    //string title: Interné id záznamu

    @Column(nullable = false)
    private int dose1Count;
    //integer title: Počet podaných prvých dávok vakcín pre daný deň

    @Column(nullable = false)
    private int dose2Count;
    //integer title: Počet podaných druhých dávok vakcín pre daný deň

    @Column(nullable = false)
    private int dose1Sum;
    //integer title: Súčet podaných prvých dávok vakcín od začiatku vakcinácie do daného dňa

    @Column(nullable = false)
    private int dose2Sum;
    //integer title: Súčet podaných druhých dávok vakcín od začiatku vakcinácie do daného dňa

    @Column(nullable = false)
    private int updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu) example: 2020-01-13 12:34:56

    @Column(nullable = false)
    private String publishedOn;
    //string($date-time) title: Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    //example: 2020-01-13


    public SlovakiaVaccination() {
    }

    public SlovakiaVaccination(String id, int dose1Count, int dose2Count,
                               int dose1Sum, int dose2Sum, int updatedAt, String publishedOn) {
        this.id = id;
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

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    @Override
    public String toString() {
        return "SlovakiaVaccination{" +
                "id='" + id + '\'' +
                ", dose1Count=" + dose1Count +
                ", dose2Count=" + dose2Count +
                ", dose1Sum=" + dose1Sum +
                ", dose2Sum=" + dose2Sum +
                ", updatedAt=" + updatedAt +
                ", publishedOn='" + publishedOn + '\'' +
                '}';
    }
}
