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

    private String med_Name;

    public Medicines() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMed_Name() {
        return med_Name;
    }

    public void setMed_Name(String med_Name) {
        this.med_Name = med_Name;
    }
}



//TODO med_name being created in db and being pulled instead of medname
