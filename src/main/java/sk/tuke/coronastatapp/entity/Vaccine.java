package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vaccine {
    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String manufacturer;


    public Vaccine() {
    }

    public Vaccine(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Vaccine(int id, String title, String manufacturer) {
        this.id = id;
        this.title = title;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
