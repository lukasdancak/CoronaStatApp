package sk.tuke.coronastatapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalBeds {

    @ManyToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    private Hospital hospital;
    //integer title: Interné id nemocnice z /api/hospitals

    @Id
    @Column(nullable = false)
    @JsonProperty("id")
    private int id;
    //integer title: Interné id záznamu

    @Column(nullable = false)
    @JsonProperty("reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportedAt;
    //string($date-time) title:Čas, kedy záznam reportovala nemocnica example:2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu) example:2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;
    //string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované pre potreby štatistík example:2020-01-13

    @Column(nullable = false)
    @JsonProperty("capacity_all")
    private int capacityAll;
    //integer title: Maximálny počet všetkých lôžok(pre COVID aj neCOVID pacientov)

    @Column(nullable = false)
    @JsonProperty("free_all")
    private int freeAll;
    //integer title: Počet všetkých voľných lôžok

    @Column(nullable = false)
    @JsonProperty("capacity_covid")
    private int capacityCovid;
    //integer title: Maximálny počet reprofilovaných lôžok pre COVID pacientov

    @Column(nullable = false)
    @JsonProperty("occupied_jis_covid")
    private int occupiedJisCovid;
    //integer title: Lôžka na jednotke intenzívnej starostlivosti(JIS) aktuálne využité pacientami,ktorí majú COVID

    @Column(nullable = false)
    @JsonProperty("occupied_oaim_covid")
    private int occupiedOaimCovid;
    //integer title: Lôžka na oddelení anesteziológie a intenzívnej medicíny(OAIM),aktuálne využité ventilovanými
    // pacientami,ktorí majú COVID

    @Column(nullable = false)
    @JsonProperty("occupied_o2_covid")
    private int occupiedO2Covid;
    //integer title: Lôžka s kyslíkom(O2) aktuálne využité pacientami,ktorí majú COVID

    @Column(nullable = false)
    @JsonProperty("occupied_other_covid")
    private int occupiedOtherCovid;
    //integer title: Obyčajné lôžka aktuálne využité pacientami, ktorí majú COVID


    public HospitalBeds() {
    }

    public HospitalBeds(Hospital hospitalId, int id, Date reportedAt, Date updatedAt, Date publishedOn,
                        int capacityAll, int freeAll, int capacityCovid, int occupiedJisCovid, int occupiedOaimCovid,
                        int occupied_o2_covid, int occupied_other_covid) {
        this.hospital = hospitalId;
        this.id = id;
        this.reportedAt = reportedAt;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
        this.capacityAll = capacityAll;
        this.freeAll = freeAll;
        this.capacityCovid = capacityCovid;
        this.occupiedJisCovid = occupiedJisCovid;
        this.occupiedOaimCovid = occupiedOaimCovid;
        this.occupiedO2Covid = occupiedO2Covid;
        this.occupiedOtherCovid = occupiedOtherCovid;
    }

    public Hospital getHospital() {
        return hospital;
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

    public int getOccupiedO2Covid() {
        return occupiedO2Covid;
    }

    public int getOccupiedOtherCovid() {
        return occupiedOtherCovid;
    }

    @Override
    public String toString() {
        return "HospitalBeds{" +
                "hospitalId=" + hospital +
                ", id=" + id +
                ", reportedAt=" + reportedAt +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                ", capacityAll=" + capacityAll +
                ", freeAll=" + freeAll +
                ", capacityCovid=" + capacityCovid +
                ", occupiedJisCovid=" + occupiedJisCovid +
                ", occupiedOaimCovid=" + occupiedOaimCovid +
                ", occupied_o2_covid=" + occupiedO2Covid +
                ", occupied_other_covid=" + occupiedOtherCovid +
                '}';
    }
}
