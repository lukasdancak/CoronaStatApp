package sk.tuke.coronastatapp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DistrictHospitalBeds {

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
    @JsonProperty("capacity_all")
    private int capacityAll;

    @Column(nullable = false)
    @JsonProperty("free_all")
    private int freeAll;

    @Column(nullable = false)
    @JsonProperty("capacity_covid")
    private int capacityCovid;

    @Column(nullable = false)
    @JsonProperty("occupied_jis_covid")
    private int occupiedJisCovid;

    @Column(nullable = false)
    @JsonProperty("occupied_oaim_covid")
    private int occupiedOaimCovid;

    @Column(nullable = false)
    @JsonProperty("occupied_o2_covid")
    private int occupiedO2Covid;

    @Column(nullable = false)
    @JsonProperty("occupied_other_covid")
    private int occupiedOtherCovid;

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    public DistrictHospitalBeds() {
    }

    public DistrictHospitalBeds(Date oldestReportedAt, Date newestReportedAt, Date publishedOn, District district,
                                int id, int capacityAll, int freeAll, int capacityCovid, int occupiedJisCovid,
                                int occupiedOaimCovid, int occupiedO2Covid, int occupiedOtherCovid, Date updatedAt) {
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.district = district;
        this.id = id;
        this.capacityAll = capacityAll;
        this.freeAll = freeAll;
        this.capacityCovid = capacityCovid;
        this.occupiedJisCovid = occupiedJisCovid;
        this.occupiedOaimCovid = occupiedOaimCovid;
        this.occupiedO2Covid = occupiedO2Covid;
        this.occupiedOtherCovid = occupiedOtherCovid;
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

    public int getCapacityAll() {
        return capacityAll;
    }

    public void setCapacityAll(int capacityAll) {
        this.capacityAll = capacityAll;
    }

    public int getFreeAll() {
        return freeAll;
    }

    public void setFreeAll(int freeAll) {
        this.freeAll = freeAll;
    }

    public int getCapacityCovid() {
        return capacityCovid;
    }

    public void setCapacityCovid(int capacityCovid) {
        this.capacityCovid = capacityCovid;
    }

    public int getOccupiedJisCovid() {
        return occupiedJisCovid;
    }

    public void setOccupiedJisCovid(int occupiedJisCovid) {
        this.occupiedJisCovid = occupiedJisCovid;
    }

    public int getOccupiedOaimCovid() {
        return occupiedOaimCovid;
    }

    public void setOccupiedOaimCovid(int occupiedOaimCovid) {
        this.occupiedOaimCovid = occupiedOaimCovid;
    }

    public int getOccupiedO2Covid() {
        return occupiedO2Covid;
    }

    public void setOccupiedO2Covid(int occupiedO2Covid) {
        this.occupiedO2Covid = occupiedO2Covid;
    }

    public int getOccupiedOtherCovid() {
        return occupiedOtherCovid;
    }

    public void setOccupiedOtherCovid(int occupiedOtherCovid) {
        this.occupiedOtherCovid = occupiedOtherCovid;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "DistrictHospitalBeds{" +
                "oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", district=" + district +
                ", id=" + id +
                ", capacityAll=" + capacityAll +
                ", freeAll=" + freeAll +
                ", capacityCovid=" + capacityCovid +
                ", occupiedJisCovid=" + occupiedJisCovid +
                ", occupiedOaimCovid=" + occupiedOaimCovid +
                ", occupiedO2Covid=" + occupiedO2Covid +
                ", occupiedOtherCovid=" + occupiedOtherCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
