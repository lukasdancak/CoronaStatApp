package sk.tuke.coronastatapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalPatients {

    @ManyToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    @JsonProperty("hospital_id")
    private Hospital hospital;
    //integer title: Interné id nemocnice z /api/hospitals

    @Id
    @JsonProperty("id")
    @Column(nullable = false)
    private int id;
    // integer title: Interné id záznamu

    @Column(nullable = false)
    @JsonProperty("oldest_reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date oldestReportedAt;

    @Column(nullable = false)
    @JsonProperty("ventilated_covid")
    private int ventilatedCovid;
    // integer title: Počet pacientov, ktorí majú COVID a sú na pľúcnej ventilácii

    @Column(nullable = false)
    @JsonProperty("non_covid")
    private int nonCovid;
    // integer title: Počet pacientov, ktorí nemajú potvrdený COVID a nemajú ani podozrenie na COVID

    @Column(nullable = false)
    @JsonProperty("confirmed_covid")
    private int confirmedCovid;
    // integer title: Počet pacientov, ktorí majú potvrdený COVID

    @Column(nullable = false)
    @JsonProperty("suspected_covid")
    private int suspectedCovid;
    // integer title: Počet pacientov, ktorí majú podozrenie na COVID

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @Column(nullable = false)
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;


    public HospitalPatients() {}

    public HospitalPatients(Hospital hospital, int id, Date oldestReportedAt, int ventilatedCovid, int nonCovid,
                            int confirmedCovid, int suspectedCovid, Date updatedAt, Date publishedOn) {
        this.hospital = hospital;
        this.id = id;
        this.oldestReportedAt = oldestReportedAt;
        this.ventilatedCovid = ventilatedCovid;
        this.nonCovid = nonCovid;
        this.confirmedCovid = confirmedCovid;
        this.suspectedCovid = suspectedCovid;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
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

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    @Override
    public String toString() {
        return "HospitalPatients{" +
                "hospital=" + hospital +
                ", id=" + id +
                ", oldestReportedAt=" + oldestReportedAt +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
