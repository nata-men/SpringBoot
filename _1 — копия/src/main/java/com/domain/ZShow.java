package com.domain;

import java.util.Date;

public class ZShow {
    private Integer id_zs;
    private String name;
    private String adress_to;
    private String adress_from;
    private int tonnazh;
    private Date date;
    private String tip;
    private String status;
    private String tel;

    public ZShow(Integer id_zs, String name, String adress_to, String adress_from, int tonnazh, Date date, String tip, String status, String tel) {
        this.id_zs = id_zs;
        this.name = name;
        this.adress_to = adress_to;
        this.adress_from = adress_from;
        this.tonnazh = tonnazh;
        this.date = date;
        this.tip = tip;
        this.status = status;
        this.tel = tel;
    }

    public ZShow() {
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId_zs() {
        return id_zs;
    }

    public void setId_zs(Integer id_zs) {
        this.id_zs = id_zs;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
