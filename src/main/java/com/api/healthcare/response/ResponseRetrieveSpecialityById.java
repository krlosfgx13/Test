/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.response;

import com.api.healthcare.model.Prescription;
import com.api.healthcare.model.Speciality;

/**
 *
 * @author cgonzalez
 */
public class ResponseRetrieveSpecialityById extends GenericResponse {
    
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
