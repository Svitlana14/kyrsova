package com.joreijarr.studycontrol.containers;

public class notesContainer {
    public String client, product, note_date, note_time;


    public notesContainer() {
    }

    public notesContainer(String client, String product, String note_date, String note_time) {
        this.client = client;
        this.product = product;
        this.note_date = note_date;
        this.note_time = note_time;
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
