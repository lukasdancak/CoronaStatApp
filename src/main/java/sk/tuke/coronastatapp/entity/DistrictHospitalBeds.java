package sk.tuke.coronastatapp.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;


public class DistrictHospitalBeds {
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
    private int districtId;


    @Column(nullable = false)
    private int ventilatedCovid;

    @Column(nullable = false)
    private int nonCovid;

    @Column(nullable = false)
    private int confirmedCovid;


    @Column(nullable = false)
    private int suspectedCovid;


    @Column(nullable = false)
    private Date updatedAt;


    public DistrictHospitalBeds() {
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

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
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

    public DistrictHospitalBeds(int id, Date oldestReportedAt, Date newestReportedAt, Date publishedOn, int districtId, int ventilatedCovid, int nonCovid, int confirmedCovid, int suspectedCovid, Date updatedAt) {
        this.id = id;
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.districtId = districtId;
        this.ventilatedCovid = ventilatedCovid;
        this.nonCovid = nonCovid;
        this.confirmedCovid = confirmedCovid;
        this.suspectedCovid = suspectedCovid;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "DistrictHospitalBeds{" +
                "id=" + id +
                ", oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", districtId=" + districtId +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}


