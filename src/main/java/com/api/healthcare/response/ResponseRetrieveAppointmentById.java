/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.response;

import com.api.healthcare.model.Appointment;
import com.api.healthcare.model.Doctor;

/**
 *
 * @author cgonzalez
 */
public class ResponseRetrieveAppointmentById extends GenericResponse{
    
    private Appointment appointment;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
}
