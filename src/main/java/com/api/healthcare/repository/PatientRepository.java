/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.repository;

import com.api.healthcare.model.Appointment;
import com.api.healthcare.model.Doctor;
import com.api.healthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author cgonzalez
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("FROM Patient WHERE patientid = ?1")
    Patient findPatientById(int id);
}
