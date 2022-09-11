package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class RegionHospitalBeds {
    @Id
    @Column(nullable = false)
    private int id;


    @Column(nullable = false)
    private Date oldestReportedAt;

    @Column(nullable = false)
    private Date newestReportedAt;

    @Column(nullable = false)
    private Date publishedOn;

    @Column(nullable = false)
    private int regionId;

    @Column(nullable = false)
    private int capacityAll;

    @Column(nullable = false)
    private int freeAll;

    @Column(nullable = false)
    private int capacityCovid;

    @Column(nullable = false)
    private int occupiedJisCovid;

    @Column(nullable = false)
    private int occupiedOaimCovid;


    @Column(nullable = false)
    private int occupiedO2Covid;

    @Column(nullable = false)
    private int occupiedOtherCovid;

    @Column(nullable = false)
    private Date updatedAt;

    public RegionHospitalBeds(int id, Date oldestReportedAt, Date newestReportedAt, Date publishedOn, int regionId, int capacityAll, int freeAll, int capacityCovid, int occupiedJisCovid, int occupiedOaimCovid, int occupiedO2Covid, int occupiedOtherCovid, Date updatedAt) {
        this.id = id;
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.regionId = regionId;
        this.capacityAll = capacityAll;
        this.freeAll = freeAll;
        this.capacityCovid = capacityCovid;
        this.occupiedJisCovid = occupiedJisCovid;
        this.occupiedOaimCovid = occupiedOaimCovid;
        this.occupiedO2Covid = occupiedO2Covid;
        this.occupiedOtherCovid = occupiedOtherCovid;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
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
        return "RegionHospitalBeds{" +
                "id=" + id +
                ", oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", regionId=" + regionId +
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
