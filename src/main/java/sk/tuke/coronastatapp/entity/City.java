package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @Column(nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "District.id", nullable = false)
    private District district;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String code;
    @OneToMany(mappedBy = "id")
    private List<Hospital> hospitals;

    public City() {
    }

    public City(int id, District district, String title, String code) {
        this.id = id;
        this.district = district;
        this.title = title;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public District getDistrict() {
        return district;
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

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", district=" + district +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
