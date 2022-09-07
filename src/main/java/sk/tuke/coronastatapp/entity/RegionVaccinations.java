package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegionVaccinations {

    @ManyToOne
    @JoinColumn(name = "Region.id")
    int regionId;
    //    title: Interné id regiónu z regiónov z /api/regions alebo null.
    // Hodnota null znamená, že dáta nie sú priradené žiadnemu kraju.

    @Id
    @GeneratedValue // toto nie je iste
    @Column(nullable = false)
    String id; //   Preco je to string ???
    // title: Interné id záznamu

    @Column(nullable = false)
    int dose1Count; //    title: Počet podaných prvých dávok vakcín pre daný deň a kraj

    @Column(nullable = false)
    int dose2Count; // title: Počet podaných druhých dávok vakcín pre daný deň a kraj

    @Column(nullable = false)
    int dose1Sum; // title: Súčet podaných prvých dávok vakcín od začiatku vakcinácie do daného dňa pre daný kraj

    @Column(nullable = false)
    int dose2Sum; // title: Súčet podaných druhých dávok vakcín od začiatku vakcinácie do daného dňa pre daný kraj

    @Column(nullable = false)
    Date updatedAt; //string($date-time)
    // title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu)  example:2020-01-13 12:34:56

    @Column(nullable = false)
    Date publishedOn;   // string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    //example:2020-01-13


    public RegionVaccinations() {
    }

    public RegionVaccinations(int regionId, int dose1Count, int dose2Count, int dose1Sum, int dose2Sum, Date updatedAt, Date publishedOn) {
        this.regionId = regionId;
        this.dose1Count = dose1Count;
        this.dose2Count = dose2Count;
        this.dose1Sum = dose1Sum;
        this.dose2Sum = dose2Sum;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
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

    @Override
    public String toString() {
        return "RegionVaccinations{" +
                "regionId=" + regionId +
                ", id='" + id + '\'' +
                ", dose1Count=" + dose1Count +
                ", dose2Count=" + dose2Count +
                ", dose1Sum=" + dose1Sum +
                ", dose2Sum=" + dose2Sum +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
