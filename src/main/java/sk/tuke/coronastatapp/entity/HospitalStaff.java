package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HospitalStaff {

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "Hospital.id")
    Hospital hospitalId; //	integer title: Interné id nemocnice z /api/hospitals


    @Id
    @Column(nullable = false)
    @GeneratedValue //??? ma to byt Generated Value ?
    int id; // integer title: Interné id záznamu

    @Column(nullable = false)
    Date reportedAt; // string($date-time) title:Čas, kedy záznam reportovala nemocnica example:2020-01-13 12:34:56

    @Column(nullable = false)
    float outOfWorkRatioDoctor; // number($float) title: Percentuálny podiel doktorov, ktorí majú potvrdený COVID
    // alebo sú v karanténe z počtu všetkých doktorov

    @Column(nullable = false)
    float outOfWorkRatioNurse; // number($float) title: Percentuálny podiel sestier, ktoré majú potvrdený COVID,
    // alebo sú v karanténe z počtu všetkých sestier

    @Column(nullable = false)
    float outOfWorkRatioOther;  // number($float) title: Percentuálny podiel iných zdravotníckych pracovníkov,
    // ktorí majú potvrdený COVID alebo sú v karanténe z počtu všetkých iných zdravotníckych pracovníkov

    @Column(nullable = false)
    Date updatedAt; // string($date-time) title: Čas poslednej aktualizácie záznamu(čas poslednej zmeny hodnoty
    // niektorého z atribútov záznamu) example:2020-01-13 12:34:56

    @Column(nullable = false)
    Date publishedOn;  // string($date-time) title:Deň, pre ktorý sú dáta záznamu publikované  pre potreby štatistík
    // example:2020-01-13


    public HospitalStaff() {
    }

    public HospitalStaff(Hospital hospitalId, Date reportedAt, float outOfWorkRatioDoctor, float outOfWorkRatioNurse,
                         float outOfWorkRatioOther, Date updatedAt, Date publishedOn) {
        this.hospitalId = hospitalId;
        this.reportedAt = reportedAt;
        this.outOfWorkRatioDoctor = outOfWorkRatioDoctor;
        this.outOfWorkRatioNurse = outOfWorkRatioNurse;
        this.outOfWorkRatioOther = outOfWorkRatioOther;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HospitalStaff{" +
                "hospitalId=" + hospitalId +
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
