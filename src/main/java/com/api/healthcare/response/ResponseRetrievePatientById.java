/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.response;

import com.api.healthcare.model.Doctor;
import com.api.healthcare.model.Patient;

/**
 *
 * @author cgonzalez
 */
public class ResponseRetrievePatientById extends GenericResponse {
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
