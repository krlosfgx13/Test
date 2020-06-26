/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="appointment", schema = "healthcare")
public class Appointment {
    
    @Id
    @Column(name="appointmentid")
    private int appointmentid;
    
    @Column(name="patientid")
    private int patientid;
    
    @Column(name="doctorid")
    private int doctorid;
    
    @Column(name="startdate")
    private Date startdate;
    
    @Column(name="enddate")
    private Date enddate;
    
    @Column(name="status")
    private int status;
    
    @Column(name="nextdate")
    private Date nextdate;
    
    @Column(name="remarks")
    private String remarks;
    
    @Column(name="attachments")
    private String attachment;
    

    public int getAppointmentid() {
        return appointmentid;
    }    
    
    public int getPatientid() {
        return patientid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public int getStatus() {
        return status;
    }

    public Date getNextdate() {
        return nextdate;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setNextdate(Date nextdate) {
        this.nextdate = nextdate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
