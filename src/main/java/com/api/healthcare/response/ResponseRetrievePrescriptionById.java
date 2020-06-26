/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.response;

import com.api.healthcare.model.Patient;
import com.api.healthcare.model.Prescription;

/**
 *
 * @author cgonzalez
 */
public class ResponseRetrievePrescriptionById extends GenericResponse {
    
    private Prescription prescription;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    
}
