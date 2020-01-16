package com.domain;

import javax.persistence.*;

@Entity
public class TipGruz {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public TipGruz(String tip) {
        this.tip = tip;
    }

    private String tip;

    public TipGruz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
