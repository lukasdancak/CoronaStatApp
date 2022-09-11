package sk.tuke.coronastatapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SlovakiaHospitalPatients {

    @Column(nullable = false)
    private String oldestReportedAt;
    // string($date-time) title: Najstarší čas, kedy niektorá nemocnica reportovala záznam v agregácii
    //example: 2020-01-13 12:34:56

    @Column(nullable = false)
    private String newestReportedAt;
    //string($date-time) title: * Najnovší čas, kedy niektorá nemocnica reportovala záznam v agregácii
    //example: 2020-01-13 12:34:56

    @Column(nullable = false)
    private String publishedOn;
    //string($date-time) title: Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík
    //example: 2020-01-13

    @Id
    @Column(nullable = false)
    private int id;
    //integer title: Interné id záznamu

    @Column(nullable = false)
    private int ventilatedCovid;
    //integer title: Počet pacientov, ktorí majú COVID a sú na pľúcnej ventilácii

    @Column(nullable = false)
    private int nonCovid;
    //integer title: Počet pacientov, ktorí nemajú potvrdený COVID a nemajú ani podozrenie na COVID

    @Column(nullable = false)
    private int confirmedCovid;
    //integer title: Počet pacientov, ktorí majú potvrdený COVID

    @Column(nullable = false)
    private int suspectedCovid;
    //integer title: Počet pacientov, ktorí majú podozrenie na COVID

    @Column(nullable = false)
    private int updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého z atribútov záznamu)
    //example: 2020-01-13 12:34:56


    public SlovakiaHospitalPatients() {
    }

    public SlovakiaHospitalPatients(String oldestReportedAt, String newestReportedAt, String publishedOn,
                                    int id, int ventilatedCovid, int nonCovid, int confirmedCovid,
                                    int suspectedCovid, int updatedAt) {
        this.oldestReportedAt = oldestReportedAt;
        this.newestReportedAt = newestReportedAt;
        this.publishedOn = publishedOn;
        this.id = id;
        this.ventilatedCovid = ventilatedCovid;
        this.nonCovid = nonCovid;
        this.confirmedCovid = confirmedCovid;
        this.suspectedCovid = suspectedCovid;
        this.updatedAt = updatedAt;
    }

    public String getOldestReportedAt() {
        return oldestReportedAt;
    }

    public void setOldestReportedAt(String oldestReportedAt) {
        this.oldestReportedAt = oldestReportedAt;
    }

    public String getNewestReportedAt() {
        return newestReportedAt;
    }

    public void setNewestReportedAt(String newestReportedAt) {
        this.newestReportedAt = newestReportedAt;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
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

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "SlovakiaHospitalPatients{" +
                "oldestReportedAt='" + oldestReportedAt + '\'' +
                ", newestReportedAt='" + newestReportedAt + '\'' +
                ", publishedOn='" + publishedOn + '\'' +
                ", id=" + id +
                ", ventilatedCovid=" + ventilatedCovid +
                ", nonCovid=" + nonCovid +
                ", confirmedCovid=" + confirmedCovid +
                ", suspectedCovid=" + suspectedCovid +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
