package sk.tuke.coronastatapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VaccinationContact {

    //mnou pridana premenna id, nie je v korona.gov.sk tabulke - lebo inak ma hibernate problem. L.Dancak
    // GeneratedValue preto, lebo je to nami pridana premenna, musi byt vygenerovana
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    private Hospital hospitalId;
    //integer title: Interné id poskytovateľa zdravotnej starostlivosti

    @Column(nullable = false)
    private String substitutesPhones;
    //string title: Telefonický kontakt pre registráciu náhradníkov na očkovanie

    @Column(nullable = false)
    private String substitutesEmails;
    //string title: Emailový kontakt pre registráciu náhradníkov na očkovanie

    @Column(nullable = false)
    private String substitutesLink;
    //string title: Webstránka s informáciami pre registráciu náhradníkov na očkovanie

    @Column(nullable = false)
    private String substitutesNote;
    //string title: Dôležitá poznámka pre registráciu náhradníkov na očkovanie

    @Column(nullable = false)
    private boolean isAcceptingNewRegistrations;

    @Column(nullable = false)
    private Date updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu) example: 2020-01-13 12:34:56

    public VaccinationContact() {
    }

    public VaccinationContact(Hospital hospitalId, String substitutesPhones, String substitutesEmails,
                              String substitutesLink, String substitutesNote, boolean isAcceptingNewRegistrations,
                              Date updatedAt) {
        this.hospitalId = hospitalId;
        this.substitutesPhones = substitutesPhones;
        this.substitutesEmails = substitutesEmails;
        this.substitutesLink = substitutesLink;
        this.substitutesNote = substitutesNote;
        this.isAcceptingNewRegistrations = isAcceptingNewRegistrations;
        this.updatedAt = updatedAt;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getSubstitutesPhones() {
        return substitutesPhones;
    }

    public void setSubstitutesPhones(String substitutesPhones) {
        this.substitutesPhones = substitutesPhones;
    }

    public String getSubstitutesEmails() {
        return substitutesEmails;
    }

    public void setSubstitutesEmails(String substitutesEmails) {
        this.substitutesEmails = substitutesEmails;
    }

    public String getSubstitutesLink() {
        return substitutesLink;
    }

    public void setSubstitutesLink(String substitutesLink) {
        this.substitutesLink = substitutesLink;
    }

    public String getSubstitutesNote() {
        return substitutesNote;
    }

    public void setSubstitutesNote(String substitutesNote) {
        this.substitutesNote = substitutesNote;
    }

    public boolean isAcceptingNewRegistrations() {
        return isAcceptingNewRegistrations;
    }

    public void setAcceptingNewRegistrations(boolean acceptingNewRegistrations) {
        isAcceptingNewRegistrations = acceptingNewRegistrations;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "VaccinationContacts{" +
                "hospitalId=" + hospitalId +
                ", substitutesPhones='" + substitutesPhones + '\'' +
                ", substitutesEmails='" + substitutesEmails + '\'' +
                ", substitutesLink='" + substitutesLink + '\'' +
                ", substitutesNote='" + substitutesNote + '\'' +
                ", isAcceptingNewRegistrations=" + isAcceptingNewRegistrations +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
