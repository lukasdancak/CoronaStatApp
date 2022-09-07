package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SlovakiaVaccinations {

    @Id
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


}
