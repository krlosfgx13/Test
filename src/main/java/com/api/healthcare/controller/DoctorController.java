/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import com.api.healthcare.components.PasswordHash;
import com.api.healthcare.model.Doctor;
import com.api.healthcare.model.UserAccount;
import com.api.healthcare.repository.DoctorRepository;
import com.api.healthcare.repository.UserRepository;
import com.api.healthcare.response.GenericResponse;
import com.api.healthcare.response.ResponseRetrieveDoctorById;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class DoctorController {
    
    @Autowired
    private DoctorRepository repository;
    
    @PostMapping("/doctor")
    public GenericResponse createDoctor(@Valid @RequestBody Doctor doctor) throws NoSuchAlgorithmException, InvalidKeySpecException {        
        try{
            repository.save(doctor);
            return new GenericResponse("Operation performed successfully", true);
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
    @GetMapping("/doctor")
    public List<Doctor> GetAllDoctors(){        
        List<Doctor> list = new ArrayList<>();
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
    
    @GetMapping("/doctor/{id}")
    public ResponseRetrieveDoctorById retrieveDoctorById(@PathVariable(value="id") int id){
        
        ResponseRetrieveDoctorById resp = new ResponseRetrieveDoctorById();
        
        try{
            Doctor doctor = repository.findDoctorById(id);
            
            if(!doctor.equals(null)){
                resp.setDoctor(doctor);
                resp.setSuccess(true);
                resp.setMessage("Operation performed successfully.");
            }else{
                resp.setDoctor(null);
                resp.setSuccess(false);
                resp.setMessage("There is no data.");
            }
        }
        catch(Exception ex){
            resp.setDoctor(null);
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }
    
    @PutMapping("/doctor/{id}")
    public GenericResponse updateDoctor(@PathVariable(value="id") int id, 
            @Valid @RequestBody Doctor request) throws ResourceNotFoundException {       
        
        GenericResponse resp = new GenericResponse();
        
        try{
            Doctor doctor = repository.findDoctorById(id);
        
        if(doctor != null){
            doctor.setFirstname(request.getFirstname());
            doctor.setLastname(request.getLastname());
            doctor.setMidname(request.getMidname());
            doctor.setSecondlastname(request.getSecondlastname());
            doctor.setSpecialityid(request.getSpecialityid());
            doctor.setGender(request.getGender());
            doctor.setBirthdate(request.getBirthdate());
            
            repository.save(doctor);
        }else{
            return new GenericResponse("An error has occurred", false);
        }
            
        }catch(Exception ex){
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return new GenericResponse("Operation completed successfully", true);
    }
    
    @DeleteMapping("/doctor/{id}")
    public GenericResponse DeleteDoctor(@PathVariable(value="id") int id){ 
        
        try{
            Doctor doctor = repository.findDoctorById(id);
            
            if(doctor != null){
                repository.delete(doctor); 
                return new GenericResponse("Operation performed successfully", true); 
            }
            else{ return new GenericResponse("There's no data available", false);  }
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
}
