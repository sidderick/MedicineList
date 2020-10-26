package com.nhsbsa.medicinelist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicines {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String medName;

    public Medicines() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }
}



//TODO med_name being created in db and being pulled instead of medname
