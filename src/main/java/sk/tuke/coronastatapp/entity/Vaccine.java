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
    private String manufactured;


    public Vaccine() {
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

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public Vaccine(int id, String title, String manufactured) {
        this.id = id;
        this.title = title;
        this.manufactured = manufactured;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manufactured='" + manufactured + '\'' +
                '}';
    }
}
