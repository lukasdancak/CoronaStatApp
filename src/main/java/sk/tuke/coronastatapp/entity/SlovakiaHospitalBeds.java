package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class SlovakiaHospitalBeds {
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

    SlovakiaHospitalBeds(){}

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

    public SlovakiaHospitalBeds(int id, Date oldestReportedAt, Date newestReportedAt, Date publishedOn, int capacityAll, int freeAll, int capacityCovid, int occupiedJisCovid, int occupiedOaimCovid, int occupiedO2Covid, int occupiedOtherCovid, Date updatedAt) {
        this.id = id;
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.capacityAll = capacityAll;
        this.freeAll = freeAll;
        this.capacityCovid = capacityCovid;
        this.occupiedJisCovid = occupiedJisCovid;
        this.occupiedOaimCovid = occupiedOaimCovid;
        this.occupiedO2Covid = occupiedO2Covid;
        this.occupiedOtherCovid = occupiedOtherCovid;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "SlovakiaHospitalBeds{" +
                "id=" + id +
                ", oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
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

