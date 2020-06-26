/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import com.api.healthcare.model.Prescription;
import com.api.healthcare.model.Speciality;
import com.api.healthcare.repository.PrescriptionRepository;
import com.api.healthcare.repository.SpecialityRepository;
import com.api.healthcare.response.GenericResponse;
import com.api.healthcare.response.ResponseRetrievePrescriptionById;
import com.api.healthcare.response.ResponseRetrieveSpecialityById;
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
public class SpecialityController {
    
    @Autowired
    private SpecialityRepository repository;
    
    @PostMapping("/speciality")
    public GenericResponse createSpeciality(@Valid @RequestBody Speciality speciality) throws NoSuchAlgorithmException, InvalidKeySpecException {        
        try{
            repository.save(speciality);
            return new GenericResponse("Operation performed successfully", true);
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
    @GetMapping("/speciality")
    public List<Speciality> GetAllSpeciality(){        
        List<Speciality> list = new ArrayList<>();
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
    
    @GetMapping("/speciality/{id}")
    public ResponseRetrieveSpecialityById retrieveSpecialityById(@PathVariable(value="id") int id){
        
        ResponseRetrieveSpecialityById resp = new ResponseRetrieveSpecialityById();
        
        try{
            Speciality speciality = repository.findSpecialityById(id);
            
            if(!speciality.equals(null)){
                resp.setSpeciality(speciality);
                resp.setSuccess(true);
                resp.setMessage("Operation performed successfully.");
            }else{
                resp.setSpeciality(null);
                resp.setSuccess(false);
                resp.setMessage("There is no data.");
            }
        }
        catch(Exception ex){
            resp.setSpeciality(null);
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }
    
    @PutMapping("/speciality/{id}")
    public GenericResponse updateSpeciality(@PathVariable(value="id") int id, 
            @Valid @RequestBody Speciality request) throws ResourceNotFoundException {       
        
        GenericResponse resp = new GenericResponse();
        
        try{
            Speciality speciality = repository.findSpecialityById(id);
        
        if(speciality != null){
            speciality.setDescription(request.getDescription());
            
            repository.save(speciality);
        }else{
            return new GenericResponse("An error has occurred", false);
        }
            
        }catch(Exception ex){
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return new GenericResponse("Operation completed successfully", true);
    }
    
    @DeleteMapping("/speciality/{id}")
    public GenericResponse DeletePrescription(@PathVariable(value="id") int id){ 
        
        try{
            Speciality speciality = repository.findSpecialityById(id);
            
            if(speciality != null){
                repository.delete(speciality);
                return new GenericResponse("Operation performed successfully", true); 
            }
            else{ return new GenericResponse("There's no data available", false);  }
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
}
