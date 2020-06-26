/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.model;

import javax.persistence.*;

@Entity
@Table(name="speciality", schema = "healthcare")
public class Speciality {
    
    @Id
    @Column(name="specialityid")
    private int specialityid;
    
    @Column(name="description")
    private String description;

    public int getSpecialityid() {
        return specialityid;
    }

    public String getDescription() {
        return description;
    }

    public void setSpecialityid(int specialityid) {
        this.specialityid = specialityid;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
