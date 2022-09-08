package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalPatients {

    @ManyToOne
    @JoinColumn(name = "Hospital.id")
    Hospital hospital;
    //integer title: Interné id nemocnice z /api/hospitals

    @Id
    @Column(nullable = false)
    int id;
    // integer title: Interné id záznamu

    @Column(nullable = false)
    Date reportedAt;
    // string($date-time) title: Čas, kedy záznam reportovala nemocnica
    // example: 2020-01-13 12:34:56

    @Column(nullable = false)
    int ventilatedCovid;
    // integer title: Počet pacientov, ktorí majú COVID a sú na pľúcnej ventilácii

    @Column(nullable = false)
    int nonCovid;
    // integer title: Počet pacientov, ktorí nemajú potvrdený COVID a nemajú ani podozrenie na COVID

    @Column(nullable = false)
    int confirmedCovid;
    // integer title: Počet pacientov, ktorí majú potvrdený COVID

    @Column(nullable = false)
    int suspectedCovid;
    // integer title: Počet pacientov, ktorí majú podozrenie na COVID

    @Column(nullable = false)
    Date updatedAt;
    // string($date-time) title: Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu)
    //example: 2020-01-13 12:34:56

    @Column(nullable = false)
    Date publishedOn;
    // string($date-time) title: Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    // example: 2020-01-13


    public HospitalPatients() {
    }

    public HospitalPatients(Hospital hospitalId, int id, Date reportedAt, int ventilatedCovid, int nonCovid,
                            int confirmedCovid, int suspectedCovid, Date updatedAt, Date publishedOn) {
        this.hospital = hospitalId;
        this.id = id;
        this.reportedAt = reportedAt;
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

    public Date getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(Date reportedAt) {
        this.reportedAt = reportedAt;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HospitalPatients{" +
                "hospital=" + hospital +
                ", id=" + id +
                ", reportedAt=" + reportedAt +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
