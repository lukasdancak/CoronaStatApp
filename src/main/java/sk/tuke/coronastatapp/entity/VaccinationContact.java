package sk.tuke.coronastatapp.entity;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
// TypeDef je tu kvoli tomu, lebo List<String> v entite prepajam na stlpcek databazy typu array text[]
//riesenie od vladmihalcea.com: https://vladmihalcea.com/postgresql-array-java-list/
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class VaccinationContact implements Serializable {

    //mnou pridana premenna id, nie je v korona.gov.sk tabulke - pridana, lebo inak ma hibernate problem. L.Dancak
    // GeneratedValue preto, lebo je to nami pridana premenna, musi byt vygenerovana
//    @Id
//    @GeneratedValue
//    private int id;


    @OneToOne
    @JoinColumn(name = "Hospital.id", nullable = false)
    @Id
    private Hospital hospital;
    //integer title: Interné id poskytovateľa zdravotnej starostlivosti

    /***********************************
     // !!! substitutesPhones a substitutesEmails su v databaze ako array
     // pre namapovanie som pouzil riesenie od vladmihalcea.com:
     //https://vladmihalcea.com/postgresql-array-java-list/
     // v Entite to mozem mapovat na obycajnu array, alebo List, mapujem na List
     ******************************/

    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    private List<String> substitutesPhones;
    //string title: Telefonický kontakt pre registráciu náhradníkov na očkovanie


    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    private List<String> substitutesEmails;
    //string title: Emailový kontakt pre registráciu náhradníkov na očkovanie


    private String substitutesLink;
    //string title: Webstránka s informáciami pre registráciu náhradníkov na očkovanie
    //moze byt null


    private String substitutesNote;
    //string title: Dôležitá poznámka pre registráciu náhradníkov na očkovanie
    //moze byt null

    @Column(nullable = false)
    private boolean isAcceptingNewRegistrations;

    @Column(nullable = false)
    private Date updatedAt;
    //string($date-time) title: Čas poslednej aktualizácie záznamu (čas poslednej zmeny hodnoty niektorého
    // z atribútov záznamu) example: 2020-01-13 12:34:56

    public VaccinationContact() {
    }

    public VaccinationContact(Hospital hospitalId, List<String> substitutesPhones, List<String> substitutesEmails,
                              String substitutesLink, String substitutesNote, boolean isAcceptingNewRegistrations,
                              Date updatedAt) {
        this.hospital = hospitalId;
        this.substitutesPhones = substitutesPhones;
        this.substitutesEmails = substitutesEmails;
        this.substitutesLink = substitutesLink;
        this.substitutesNote = substitutesNote;
        this.isAcceptingNewRegistrations = isAcceptingNewRegistrations;
        this.updatedAt = updatedAt;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<String> getSubstitutesPhones() {
        return substitutesPhones;
    }

    public void setSubstitutesPhones(List<String> substitutesPhones) {
        this.substitutesPhones = substitutesPhones;
    }

    public List<String> getSubstitutesEmails() {
        return substitutesEmails;
    }

    public void setSubstitutesEmails(List<String> substitutesEmails) {
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
        return "VaccinationContact{" +
                ", hospitalId=" + hospital +
                ", substitutesPhones='" + substitutesPhones + '\'' +
                ", substitutesEmails='" + substitutesEmails + '\'' +
                ", substitutesLink='" + substitutesLink + '\'' +
                ", substitutesNote='" + substitutesNote + '\'' +
                ", isAcceptingNewRegistrations=" + isAcceptingNewRegistrations +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
