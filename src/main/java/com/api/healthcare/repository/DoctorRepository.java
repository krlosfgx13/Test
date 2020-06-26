/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.repository;

import com.api.healthcare.model.Appointment;
import com.api.healthcare.model.Doctor;
import com.api.healthcare.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cgonzalez
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    
    @Query("FROM Doctor WHERE doctorid = ?1")
    Doctor findDoctorById(int id);
    
}
