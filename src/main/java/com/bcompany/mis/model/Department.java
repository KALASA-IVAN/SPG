package com.bcompany.mis.model;

import javax.persistence.*;

@Entity
@Table(name="Department")

public class Department {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dId;
    private String name;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(){

    }

    public Department(Integer dId, String name) {
        this.dId = dId;
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }
}
