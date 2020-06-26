/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import com.api.healthcare.model.UserAccount;
import com.api.healthcare.repository.UserRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.api.healthcare.request.LoginRequest;
import com.api.healthcare.businesslogic.Security;
import com.api.healthcare.request.UpdatePasswordRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@RestController
@RequestMapping("/security")
public class SecurityController {
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/login")
    public Boolean Login(@Valid @RequestBody LoginRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException {
        
        if(request.equals(null)){
            return false;
        }else{
            Boolean loginFlag = Security.Login(userRepository, request);
            
            if(loginFlag){ return true; }
            else{ return false; }
        }
    }
    
    @PostMapping("/changepassword")
    public Boolean UpdatePassword(@Valid @RequestBody UpdatePasswordRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException{
        
        if(request.equals(null)){
            return false;
        }else{
            Boolean flag = Security.UpdatePassword(userRepository, request);
            return true;
        }
    }
    
}
