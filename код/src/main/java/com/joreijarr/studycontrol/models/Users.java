package com.joreijarr.studycontrol.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    public Users() {
    }



    public Users(String user_login, String user_password, String user_fullname) {
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_fullname = user_fullname;
    }



    private String user_login, user_password, user_fullname;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

}
