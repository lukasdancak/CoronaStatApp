package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class District {

    @Id
    @Column(nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "Region.id", nullable = false)
    private Region region;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String code;
    @OneToMany(mappedBy = "id")
    private List<DistrictAgTests> districtAgTests;
    @OneToMany(mappedBy = "id")
    private List<City> cities;

    public District() {
    }

    public District(int id, Region region, String title, String code) {
        this.id = id;
        this.region = region;
        this.title = title;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public Region getRegion() {
        return region;
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

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", region=" + region +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
