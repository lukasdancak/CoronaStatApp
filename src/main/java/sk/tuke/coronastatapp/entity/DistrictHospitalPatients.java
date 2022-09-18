package sk.tuke.coronastatapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DistrictHospitalPatients {

    @Column(nullable = false)
    @JsonProperty("oldest_reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date oldestReportedAt;

    @Column(nullable = false)
    @JsonProperty("newest_reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newestReportedAt;

    @Column(nullable = false)
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;

    @ManyToOne
    @JoinColumn(name = "District.id", nullable = true)
    //title: Interné id okresu z /api/districts alebo null. Hodnota null znamená, že dáta nie sú priradené žiadnemu okresu.
    @JsonProperty("district_id")
    private District district;

    @Id
    @JsonProperty("id")
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    @JsonProperty("ventilated_covid")
    private int ventilatedCovid;

    @Column(nullable = false)
    @JsonProperty("non_covid")
    private int nonCovid;

    @Column(nullable = false)
    @JsonProperty("confirmed_covid")
    private int confirmedCovid;

    @Column(nullable = false)
    @JsonProperty("suspected_covid")
    private int suspectedCovid;

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    public DistrictHospitalPatients() {
    }

    public DistrictHospitalPatients(Date oldestReportedAt, Date newestReportedAt, Date publishedOn,
                                    District district, int id, int ventilatedCovid, int nonCovid, int confirmedCovid,
                                    int suspectedCovid, Date updatedAt) {
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.district = district;
        this.id = id;
        this.ventilatedCovid = ventilatedCovid;
        this.nonCovid = nonCovid;
        this.confirmedCovid = confirmedCovid;
        this.suspectedCovid = suspectedCovid;
        this.updatedAt = updatedAt;
    }

    public Date getOldestReportedAt() {
        return oldestReportedAt;
    }

    public void setOldestReportedAt(Date oldestReportedAt) {
        this.oldestReportedAt = oldestReportedAt;
    }

    public Date getNewestReportedAt() {
        return newestReportedAt;
    }

    public void setNewestReportedAt(Date newestReportedAt) {
        this.newestReportedAt = newestReportedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentilatedCovid() {
        return ventilatedCovid;
    }

    public void setVentilatedCovid(int ventilatedCovid) {
        this.ventilatedCovid = ventilatedCovid;
    }

    public int getNonCovid() {
        return nonCovid;
    }

    public void setNonCovid(int nonCovid) {
        this.nonCovid = nonCovid;
    }

    public int getConfirmedCovid() {
        return confirmedCovid;
    }

    public void setConfirmedCovid(int confirmedCovid) {
        this.confirmedCovid = confirmedCovid;
    }

    public int getSuspectedCovid() {
        return suspectedCovid;
    }

    public void setSuspectedCovid(int suspectedCovid) {
        this.suspectedCovid = suspectedCovid;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "DistrictHospitalPatients{" +
                "oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", district=" + district +
                ", id=" + id +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}