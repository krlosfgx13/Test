/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author cgonzalez
 */
@Entity
@Table(name="patient", schema = "healthcare")
public class Patient {
    
    @Id
    @Column(name="patientid")
    private int patientid;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="midname")
    private String midname;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="secondlastname")
    private String secondlastname;
    
    @Column(name="gender")
    private char gender;
    
    @Column(name="dpi")
    private String dpi;
    
    @Column(name="birthdate")
    private Date birthdate;

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }
    
    @Column(name="phonenumber")
    private String phonenumber;

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
    
    @Column(name="emailaddress")
    private String emailaddress;

    public int getPatientid() {
        return patientid;
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

    public char getGender() {
        return gender;
    }

    public String getDpi() {
        return dpi;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
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

    public void setSecondlastname(String secondlastname) {
        this.secondlastname = secondlastname;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
