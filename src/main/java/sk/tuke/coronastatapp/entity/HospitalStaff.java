package sk.tuke.coronastatapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalStaff {

    @ManyToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    @JsonProperty("hospital_id")
    private Hospital hospital;
    //	integer title: Interné id nemocnice z /api/hospitals

    @Id
    @Column(nullable = false)
    private String id;
    // integer title: Interné id záznamu

    @Column(nullable = false)
    @JsonProperty("reported_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportedAt;
    // string($date-time) title:Čas, kedy záznam reportovala nemocnica example:2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("out_of_work_ratio_doctor")
    private float outOfWorkRatioDoctor;
    // number($float) title: Percentuálny podiel doktorov, ktorí majú potvrdený COVID
    // alebo sú v karanténe z počtu všetkých doktorov

    @Column(nullable = false)
    @JsonProperty("out_of_work_ratio_nurse")
    private float outOfWorkRatioNurse;
    // number($float) title: Percentuálny podiel sestier, ktoré majú potvrdený COVID,
    // alebo sú v karanténe z počtu všetkých sestier

    @Column(nullable = false)
    @JsonProperty("out_of_work_ratio_other")
    private float outOfWorkRatioOther;  // number($float) title: Percentuálny podiel iných zdravotníckych pracovníkov,
    // ktorí majú potvrdený COVID alebo sú v karanténe z počtu všetkých iných zdravotníckych pracovníkov

    @Column(nullable = false)
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt; // string($date-time) title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty
    // niektorého z atribútov záznamu) example:2020-01-13 12:34:56

    @Column(nullable = false)
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedOn;  // string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované  pre potreby štatistík
    // example:2020-01-13


    public HospitalStaff() {
    }

    public HospitalStaff(Hospital hospitalId, String id, Date reportedAt, float outOfWorkRatioDoctor,
                         float outOfWorkRatioNurse, float outOfWorkRatioOther, Date updatedAt,
                         Date publishedOn) {
        this.hospital = hospitalId;
        this.id = id;
        this.reportedAt = reportedAt;
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
        this.outOfWorkRatioNurse = outOfWorkRatioNurse;
        this.outOfWorkRatioOther = outOfWorkRatioOther;
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

    public float getOutOfWorkRatioDoctor() {
        return outOfWorkRatioDoctor;
    }

    public void setOutOfWorkRatioDoctor(float outOfWorkRatioDoctor) {
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
    }

    public float getOutOfWorkRatioNurse() {
        return outOfWorkRatioNurse;
    }

    public void setOutOfWorkRatioNurse(float outOfWorkRatioNurse) {
        this.outOfWorkRatioNurse = outOfWorkRatioNurse;
    }

    public float getOutOfWorkRatioOther() {
        return outOfWorkRatioOther;
    }

    public void setOutOfWorkRatioOther(float outOfWorkRatioOther) {
        this.outOfWorkRatioOther = outOfWorkRatioOther;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HospitalStaff{" +
                "hospitalId=" + hospital +
                ", id=" + id +
                ", reportedAt='" + reportedAt + '\'' +
                ", outOfWorkRatioDoctor=" + outOfWorkRatioDoctor +
                ", outOfWorkRatioNurse=" + outOfWorkRatioNurse +
                ", outOfWorkRatioOther=" + outOfWorkRatioOther +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
