package com.nhsbsa.medicinelist;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medicine {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    public Medicine() {

    }

    public Medicine(int i, String spring_in_action) {
    }

    public static int size() {
        return 0;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}

