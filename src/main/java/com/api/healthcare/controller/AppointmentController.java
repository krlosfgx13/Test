/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import com.api.healthcare.model.Appointment;
import com.api.healthcare.model.Patient;
import com.api.healthcare.repository.AppointmentRepository;
import com.api.healthcare.repository.PatientRepository;
import com.api.healthcare.response.GenericResponse;
import com.api.healthcare.response.ResponseRetrieveAppointmentById;
import com.api.healthcare.response.ResponseRetrievePatientById;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class AppointmentController {
    
    @Autowired
    AppointmentRepository repository;
    
    @PostMapping("/appointment")
    public GenericResponse createAppointment(@Valid @RequestBody Appointment appointment) {        
        //DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        //Appointment a = new Appointment();
        //java.util.Date d = new java.util.Date();
        //d.getTime();
        
        try{
            /*java.sql.Date startdate = Date.valueOf(dateformat.format(appointment.getStartdate()));
            java.sql.Date enddate = Date.valueOf(dateformat.format(appointment.getEnddate()));
            java.sql.Date nextdate = Date.valueOf(dateformat.format(appointment.getNextdate()));*/
            
            /*a.setPattientid(1);
            a.setDoctorid(1);
            a.setStartdate(startdate);
            a.setEnddate(enddate);
            a.setStatus(2);
            a.setNextdate(nextdate);
            a.setRemarks("");
            a.setAttachement(null);*/
            
            //appointment.setPattientid(1);
            /*appointment.setStartdate(startdate);
            appointment.setEnddate(enddate);
            appointment.setNextdate(nextdate);*/
            //appointment.setStartdate(d);
            repository.save(appointment);
            return new GenericResponse("Operation performed successfully", true);
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
    @GetMapping("/appointment")
    public List<Appointment> GetAllAppointments(){
        List<Appointment> list = new ArrayList<>();
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
    
    @GetMapping("/appointment/{id}")
    public ResponseRetrieveAppointmentById retrieveAppointmentById(@PathVariable(value="id") int id){
        
        ResponseRetrieveAppointmentById resp = new ResponseRetrieveAppointmentById();
        
        try{
            Appointment appointment = repository.findAppointmentById(id);
            
            if(!appointment.equals(null)){
                resp.setAppointment(appointment);
                resp.setSuccess(true);
                resp.setMessage("Operation performed successfully.");
            }else{
                resp.setAppointment(null);
                resp.setSuccess(false);
                resp.setMessage("There is no data.");
            }
        }
        catch(Exception ex){
            resp.setAppointment(null);
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }
    
    @PutMapping("/appointment/{id}")
    public GenericResponse updatePatient(@PathVariable(value="id") int id, 
            @Valid @RequestBody Appointment request) throws ResourceNotFoundException {       
        
        GenericResponse resp = new GenericResponse();
        
        try{
            Appointment appointment = repository.findAppointmentById(id);
        
        if(appointment != null){
            appointment.setPatientid(request.getPatientid());
            appointment.setDoctorid(request.getDoctorid());
            appointment.setStartdate(request.getStartdate());
            appointment.setEnddate(request.getEnddate());
            appointment.setStatus(request.getStatus());
            appointment.setNextdate(request.getNextdate());
            appointment.setRemarks(request.getRemarks());
            appointment.setAttachment(request.getAttachment());
            
            repository.save(appointment);
        }else{
            return new GenericResponse("An error has occurred", false);
        }
            
        }catch(Exception ex){
            resp.setSuccess(false);
            resp.setMessage(ex.getMessage());
        }
        return new GenericResponse("Operation completed successfully", true);
    }
    
    @DeleteMapping("/appointment/{id}")
    public GenericResponse DeleteAppointment(@PathVariable(value="id") int id){ 
        
        try{
            Appointment appointment = repository.findAppointmentById(id);
            
            if(appointment != null){
                repository.delete(appointment); 
                return new GenericResponse("Operation performed successfully", true); 
            }
            else{ return new GenericResponse("There's no data available", false);  }
        }catch(Exception ex){
            return new GenericResponse(ex.getMessage(), false);
        }
    }
    
}
