package sk.tuke.coronastatapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vaccine {

    @Id
    int id;

    public Vaccine() {
    }
}
