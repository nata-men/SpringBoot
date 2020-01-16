package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statuses {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String status_name;

    public Statuses(String status_name) {
        this.status_name = status_name;
    }

    public Statuses() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}
