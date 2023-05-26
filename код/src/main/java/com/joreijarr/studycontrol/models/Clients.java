package com.joreijarr.studycontrol.models;

import javax.persistence.*;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long client_id;

    public String full_name, dob, email, phone;


    public Clients(String full_name, String dob, String email, String phone) {
        this.full_name = full_name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public Clients() {
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
