package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegionHospitalPatients {

    @Column(nullable = false)
    Date oldestReportedAt;
    //string($date-time) title: Najstarší čas, kedy niektorá nemocnica reportovala záznam v agregácii
    //example:2020-01-13 12:34:56

    @Column(nullable = false)
    Date newestReportedAt;
    //string($date-time) title: *Najnovší čas, kedy niektorá nemocnica reportovala záznam v agregácii
    // example:2020-01-13 12:34:56

    @Column(nullable = false)
    Date publishedOn;
    //string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    // example:2020-01-13

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "Region.id")
    int regionId;
    //integer title: Interné id regiónu z regiónov z /api/regions alebo null.Hodnota null znamená, že dáta nie sú
    // priradené žiadnemu kraju.

    @Id
    @GeneratedValue
    @Column(nullable = false)
    int id;
    //integer title: Interné id záznamu

    @Column(nullable = false)
    int ventilatedCovid;
    //integer title: Počet pacientov, ktorí majú COVID a sú na pľúcnej ventilácii

    @Column(nullable = false)
    int nonCovid;
    //integer title: Počet pacientov, ktorí nemajú potvrdený  COVID a nemajú ani podozrenie na COVID

    @Column(nullable = false)
    int confirmedCovid;
    //integer title: Počet pacientov, ktorí majú potvrdený COVID

    @Column(nullable = false)
    int suspectedCovid;
    //integer title: Počet pacientov, ktorí majú podozrenie na COVID

    @Column(nullable = false)
    int updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu) example:2020-01-13 12:34:56


    public RegionHospitalPatients() {
    }

    public RegionHospitalPatients(Date oldestReportedAt, Date newestReportedAt, Date publishedOn, int regionId,
                                  int ventilatedCovid, int nonCovid, int confirmedCovid, int suspectedCovid,
                                  int updatedAt) {
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.regionId = regionId;
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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
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

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RegionHospitalPatients{" +
                "oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", regionId=" + regionId +
                ", id=" + id +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
