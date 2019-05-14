package com.example.classdesign.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue
    private Integer userid;
    private String username;
    private String userpsw;
    private boolean isadmin;
    private String salt;

    public UserInfo() {
    }

    public UserInfo(String username, String userpsw, String salt) {
        this.username = username;
        this.userpsw = userpsw;
        this.salt = salt;
        this.isadmin= false;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpsw() {
        return userpsw;
    }

    public void setUserpsw(String userpsw) {
        this.userpsw = userpsw;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
