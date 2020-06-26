/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import com.api.healthcare.model.Patient;
import com.api.healthcare.repository.DoctorRepository;
import com.api.healthcare.repository.PatientRepository;
import com.api.healthcare.response.GenericResponse;
import com.api.healthcare.response.ResponseRetrieveDoctorById;
import com.api.healthcare.response.ResponseRetrievePatientById;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cgonzalez
 */
@RestController
@RequestMapping("/api")
public class PatientController {
    
    @Autowired
    private PatientRepository repository;
    
    @PostMapping("/patient")
    public GenericResponse createPatient(@Valid @RequestBody Patient patient) throws NoSuchAlgorithmException, InvalidKeySpecException {        
        try{
            repository.save(patient);
            return new GenericResponse("Operation performed successfully", true);
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
    @GetMapping("/patient")
    public List<Patient> GetAllPatients(){        
        List<Patient> list = new ArrayList<>();
        try{
            list = repository.findAll();
            if(!list.isEmpty()){
                return list;
            }
        }catch(Exception ex){
            return list;
        }
        return list;
    }
    
    @GetMapping("/patient/{id}")
    public ResponseRetrievePatientById retrievePatientById(@PathVariable(value="id") int id){
        
        ResponseRetrievePatientById resp = new ResponseRetrievePatientById();
        
        try{
            Patient patient = repository.findPatientById(id);
            
            if(!patient.equals(null)){
                resp.setPatient(patient);
                resp.setSuccess(true);
                resp.setMessage("Operation performed successfully.");
            }else{
                resp.setPatient(null);
                resp.setSuccess(false);
                resp.setMessage("There is no data.");
            }
        }
        catch(Exception ex){
            resp.setPatient(null);
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }
    
    @PutMapping("/patient/{id}")
    public GenericResponse updatePatient(@PathVariable(value="id") int id, 
            @Valid @RequestBody Patient request) throws ResourceNotFoundException {       
        
        GenericResponse resp = new GenericResponse();
        
        try{
            Patient patient = repository.findPatientById(id);
        
        if(patient != null){
            patient.setFirstname(request.getFirstname());
            patient.setLastname(request.getLastname());
            patient.setMidname(request.getMidname());
            patient.setSecondlastname(request.getSecondlastname());
            patient.setDpi(request.getDpi());
            patient.setGender(request.getGender());
            patient.setBirthdate(request.getBirthdate());
            patient.setPhonenumber(request.getPhonenumber());
            patient.setEmailaddress(request.getEmailaddress());
            
            repository.save(patient);
        }else{
            return new GenericResponse("An error has occurred", false);
        }
            
        }catch(Exception ex){
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return new GenericResponse("Operation completed successfully", true);
    }
    
    @DeleteMapping("/patient/{id}")
    public GenericResponse DeletePatient(@PathVariable(value="id") int id){ 
        
        try{
            Patient patient = repository.findPatientById(id);
            
            if(patient != null){
                repository.delete(patient); 
                return new GenericResponse("Operation performed successfully", true); 
            }
            else{ return new GenericResponse("There's no data available", false);  }
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
}
