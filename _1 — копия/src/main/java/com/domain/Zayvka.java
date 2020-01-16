package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.util.Date;


@Entity
public class Zayvka {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String adress_to;
    private String adress_from;
    private int tonnazh;
    private Date date;
    private Integer id_tip;
    private Integer id_status;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Zayvka() {
    }

    public Zayvka(String name, String adress_to, String adress_from, int tonnazh, Date date, Integer id_tip, Integer id_status, String tel) {
        this.name = name;
        this.adress_to = adress_to;
        this.adress_from = adress_from;
        this.tonnazh = tonnazh;
        this.date = date;
        this.id_tip = id_tip;
        this.id_status = id_status;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress_to() {
        return adress_to;
    }

    public void setAdress_to(String adress_to) {
        this.adress_to = adress_to;
    }

    public String getAdress_from() {
        return adress_from;
    }

    public void setAdress_from(String adress_from) {
        this.adress_from = adress_from;
    }

    public int getTonnazh() {
        return tonnazh;
    }

    public void setTonnazh(int tonnazh) {
        this.tonnazh = tonnazh;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId_tip() {
        return id_tip;
    }

    public void setId_tip(Integer id_tip) {
        this.id_tip = id_tip;
    }

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

}
