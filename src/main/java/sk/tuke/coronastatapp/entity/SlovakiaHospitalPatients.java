package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SlovakiaHospitalPatients {

    @Column(nullable = false)
    Date oldestReportedAt;
    //	string($date-time) title: Najstarší čas, kedy niektorá nemocnica reportovala záznam v agregácii
    //	example: 2020-01-13 12:34:56

    @Column(nullable = false)
    Date newestReportedAt;
    //string($date-time) title: * Najnovší čas, kedy niektorá nemocnica reportovala záznam v agregácii
    //example: 2020-01-13 12:34:56

    @Column(nullable = false)
    Date publishedOn;
    //string($date-time) title: Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    //example: 2020-01-13

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
    //integer title: Počet pacientov, ktorí nemajú potvrdený COVID a nemajú ani podozrenie na COVID

    @Column(nullable = false)
    int confirmedCovid;
    //integer title: Počet pacientov, ktorí majú potvrdený COVID

    @Column(nullable = false)
    int suspectedCovid;
    //integer title: Počet pacientov, ktorí majú podozrenie na COVID

    @Column(nullable = false)
    Date updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu) example: 2020-01-13 12:34:56


    public SlovakiaHospitalPatients() {
    }

    public SlovakiaHospitalPatients(Date oldestReportedAt, Date newestReportedAt, Date publishedOn,
                                    int ventilatedCovid, int nonCovid, int confirmedCovid, int suspectedCovid,
                                    Date updatedAt) {
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SlovakiaHospitalPatients{" +
                "oldestReportedAt=" + oldestReportedAt +
                ", newestReportedAt=" + newestReportedAt +
                ", publishedOn=" + publishedOn +
                ", id=" + id +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
