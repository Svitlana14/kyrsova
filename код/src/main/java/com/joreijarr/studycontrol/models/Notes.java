package com.joreijarr.studycontrol.models;


import javax.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long note_id;

    public String client, product, note_date, note_time;


    public Notes() {
    }

    public Notes(String client, String product, String note_date, String note_time) {
        this.client = client;
        this.product = product;
        this.note_date = note_date;
        this.note_time = note_time;
    }

    public Long getNote_id() {
        return note_id;
    }

    public void setNote_id(Long note_id) {
        this.note_id = note_id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getNote_date() {
        return note_date;
    }

    public void setNote_date(String note_date) {
        this.note_date = note_date;
    }

    public String getNote_time() {
        return note_time;
    }

    public void setNote_time(String note_time) {
        this.note_time = note_time;
    }
}
