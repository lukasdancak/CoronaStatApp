package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Region {

    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String abbreviation;
    @OneToMany(mappedBy = "id")
    private List<District> districts;
    @OneToMany(mappedBy = "id")
    private List<RegionAgTests> regionAgTests;

    public Region() {
    }

    public Region(int id) {
        this.id = id;
    }

    public Region(int id, String title, String code, String abbreviation) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
