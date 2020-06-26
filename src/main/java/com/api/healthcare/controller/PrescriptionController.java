/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import com.api.healthcare.model.Patient;
import com.api.healthcare.model.Prescription;
import com.api.healthcare.repository.PatientRepository;
import com.api.healthcare.repository.PrescriptionRepository;
import com.api.healthcare.response.GenericResponse;
import com.api.healthcare.response.ResponseRetrievePatientById;
import com.api.healthcare.response.ResponseRetrievePrescriptionById;
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
public class PrescriptionController {
    
    @Autowired
    private PrescriptionRepository repository;
    
    @PostMapping("/prescription")
    public GenericResponse createPrescription(@Valid @RequestBody Prescription prescription) throws NoSuchAlgorithmException, InvalidKeySpecException {        
        try{
            repository.save(prescription);
            return new GenericResponse("Operation performed successfully", true);
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
    @GetMapping("/prescription")
    public List<Prescription> GetAllPrescriptions(){        
        List<Prescription> list = new ArrayList<>();
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
    
    @GetMapping("/prescription/{id}")
    public ResponseRetrievePrescriptionById retrievePatientById(@PathVariable(value="id") int id){
        
        ResponseRetrievePrescriptionById resp = new ResponseRetrievePrescriptionById();
        
        try{
            Prescription prescription = repository.findPrescriptionById(id);
            
            if(!prescription.equals(null)){
                resp.setPrescription(prescription);
                resp.setSuccess(true);
                resp.setMessage("Operation performed successfully.");
            }else{
                resp.setPrescription(null);
                resp.setSuccess(false);
                resp.setMessage("There is no data.");
            }
        }
        catch(Exception ex){
            resp.setPrescription(null);
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }
    
    @PutMapping("/prescription/{id}")
    public GenericResponse updatePrescription(@PathVariable(value="id") int id, 
            @Valid @RequestBody Prescription request) throws ResourceNotFoundException {       
        
        GenericResponse resp = new GenericResponse();
        
        try{
            Prescription prescription = repository.findPrescriptionById(id);
        
        if(prescription != null){
            prescription.setPatientid(request.getPatientid());
            prescription.setDoctorid(request.getDoctorid());
            prescription.setDescription(request.getDescription());
            prescription.setAppointmentid(request.getAppointmentid());
            
            repository.save(prescription);
        }else{
            return new GenericResponse("An error has occurred", false);
        }
            
        }catch(Exception ex){
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return new GenericResponse("Operation completed successfully", true);
    }
    
    @DeleteMapping("/prescription/{id}")
    public GenericResponse DeletePrescription(@PathVariable(value="id") int id){ 
        
        try{
            Prescription prescription = repository.findPrescriptionById(id);
            
            if(prescription != null){
                repository.delete(prescription);
                return new GenericResponse("Operation performed successfully", true); 
            }
            else{ return new GenericResponse("There's no data available", false);  }
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
}
