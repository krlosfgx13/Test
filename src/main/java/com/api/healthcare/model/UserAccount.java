/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.model;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import java.io.Serializable;
import java.util.Date;
import  javax.persistence.*;

@Entity
@Table(name="useraccount", schema = "healthcare")
public class UserAccount {
    
    @Id
    @Column(name="userid")
    private int userid;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="midname")
    private String midname;
        
    @Column(name="lastname")
    private String lastname;
            
    @Column(name="secondlastname")
    private String secondlastname;
    
    @Column(name="username")
    private String username;
                
    @Column(name="status")
    private int status;
                    
    @Column(name="attempts")
    private int attempts;
                        
    @Column(name="password")
    private String password;
                            
    @Column(name="passwordexpiration")
    private Date passwordexpiration;

    public int getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMidname() {
        return midname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSecondlastname() {
        return secondlastname;
    }
    
    public String getUsername() {
        return username;
    }

    public int getStatus() {
        return status;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getPassword() {
        return password;
    }

    public Date getPasswordexpiration() {
        return passwordexpiration;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setSecondlastname(String secondlastname) {
        this.secondlastname = secondlastname;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordexpiration(Date passwordexpiration) {
        this.passwordexpiration = passwordexpiration;
    }
    
}
