/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.model;

import javax.persistence.*;

@Entity
@Table(name="prescription", schema = "healthcare")
public class Prescription {
    
    @Id
    @Column(name="prescriptionid")
    private int prescriptionid;
    
    @Column(name="patientid")
    private int patientid;
    
    @Column(name="doctorid")
    private int doctorid;
    
    @Column(name="description")
    private String description;
    
    @Column(name="appointmentid")
    private int appointmentid;    

    public int getPrescriptionid() {
        return prescriptionid;
    }

    public int getPatientid() {
        return patientid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public String getDescription() {
        return description;
    }

    public int getAppointmentid() {
        return appointmentid;
    }

    public void setPrescriptionid(int prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }
    
    
}
