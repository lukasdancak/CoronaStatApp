package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalBeds {

    @ManyToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    private Hospital hospitalId;
    //integer title: Interné id nemocnice z /api/hospitals

    @Id
    @Column(nullable = false)
    private int id;
    //integer title: Interné id záznamu

    @Column(nullable = false)
    private Date reportedAt;
    //string($date-time) title:Čas, kedy záznam reportovala nemocnica example:2020-01-13 12:34:56

    @Column(nullable = false)
    private Date updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu) example:2020-01-13 12:34:56

    @Column(nullable = false)
    private Date publishedOn;
    //string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík example:2020-01-13

    @Column(nullable = false)
    private int capacityAll;
    //integer title: Maximálny počet všetkých lôžok(pre COVID aj neCOVID pacientov)

    @Column(nullable = false)
    private int freeAll;
    //integer title: Počet všetkých voľných lôžok

    @Column(nullable = false)
    private int capacityCovid;
    //integer title: Maximálny počet reprofilovaných lôžok pre COVID pacientov

    @Column(nullable = false)
    private int occupiedJisCovid;
    //integer title: Lôžka na jednotke intenzívnej starostlivosti(JIS) aktuálne využité pacientami,ktorí majú COVID

    @Column(nullable = false)
    private int occupiedOaimCovid;
    //integer title: Lôžka na oddelení anesteziológie a intenzívnej medicíny(OAIM),aktuálne využité ventilovanými
    // pacientami,ktorí majú COVID

    @Column(nullable = false)
    private int occupied_o2_covid;
    //integer title: Lôžka s kyslíkom(O2) aktuálne využité pacientami,ktorí majú COVID

    @Column(nullable = false)
    private int occupied_other_covid;
    //integer title: Obyčajné lôžka aktuálne využité pacientami, ktorí majú COVID


    public HospitalBeds() {
    }

    public HospitalBeds(Hospital hospitalId, int id, Date reportedAt, Date updatedAt, Date publishedOn,
                        int capacityAll, int freeAll, int capacityCovid, int occupiedJisCovid, int occupiedOaimCovid,
                        int occupied_o2_covid, int occupied_other_covid) {
        this.hospitalId = hospitalId;
        this.id = id;
        this.reportedAt = reportedAt;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
        this.capacityAll = capacityAll;
        this.freeAll = freeAll;
        this.capacityCovid = capacityCovid;
        this.occupiedJisCovid = occupiedJisCovid;
        this.occupiedOaimCovid = occupiedOaimCovid;
        this.occupied_o2_covid = occupied_o2_covid;
        this.occupied_other_covid = occupied_other_covid;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public int getId() {
        return id;
    }

    public Date getReportedAt() {
        return reportedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public int getCapacityAll() {
        return capacityAll;
    }

    public int getFreeAll() {
        return freeAll;
    }

    public int getCapacityCovid() {
        return capacityCovid;
    }

    public int getOccupiedJisCovid() {
        return occupiedJisCovid;
    }

    public int getOccupiedOaimCovid() {
        return occupiedOaimCovid;
    }

    public int getOccupied_o2_covid() {
        return occupied_o2_covid;
    }

    public int getOccupied_other_covid() {
        return occupied_other_covid;
    }

    @Override
    public String toString() {
        return "HospitalBeds{" +
                "hospitalId=" + hospitalId +
                ", id=" + id +
                ", reportedAt=" + reportedAt +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                ", capacityAll=" + capacityAll +
                ", freeAll=" + freeAll +
                ", capacityCovid=" + capacityCovid +
                ", occupiedJisCovid=" + occupiedJisCovid +
                ", occupiedOaimCovid=" + occupiedOaimCovid +
                ", occupied_o2_covid=" + occupied_o2_covid +
                ", occupied_other_covid=" + occupied_other_covid +
                '}';
    }
}
