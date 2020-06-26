/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="doctor", schema = "healthcare")
public class Doctor implements Serializable{
    
    @Id
    @Column(name="doctorid")
    private int doctorid;
    
    //@Id
    @Column(name="specialityid")
    private int specialityid;
    
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
    
    @Column(name="birthdate")
    private Date birthdate;

    public int getDoctorid() {
        return doctorid;
    }

    public int getSpecialityid() {
        return specialityid;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public void setSpecialityid(int specialityid) {
        this.specialityid = specialityid;
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

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    
}
