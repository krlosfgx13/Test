/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.response;

import com.api.healthcare.model.Doctor;
import java.util.List;


/**
 *
 * @author cgonzalez
 */
public class ResponseRetrieveDoctorById extends GenericResponse{
    
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
