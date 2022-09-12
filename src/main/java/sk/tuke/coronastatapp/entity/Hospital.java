package sk.tuke.coronastatapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Hospital {

    @Id
    @Column(nullable = false)
    private int id;
    @JsonProperty("city_id")
    @ManyToOne
    @JoinColumn(name = "City.id", nullable = false)
    private City city;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String code;

    public Hospital() {
    }

    public Hospital(int id, City city, String title, String code) {
        this.id = id;
        this.city = city;
        this.title = title;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", city=" + city +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
