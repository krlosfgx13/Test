/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import com.api.healthcare.model.UserAccount;
import com.api.healthcare.repository.UserRepository;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.healthcare.components.PasswordHash;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api")
public class UserAccountController {
    
    @Autowired
    private UserRepository repository;
    
    @GetMapping("/users")
    public List<UserAccount> GetAllUsersJPA(){
        return repository.findAll();
    }
    
    @PostMapping("/users")
    public UserAccount createUser(@Valid @RequestBody UserAccount user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PasswordHash pbkdf2 = new PasswordHash();
        String hashedPassword = pbkdf2.createHash(user.getPassword());        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        Date date = cal.getTime();
        user.setPasswordexpiration(date);
        user.setPassword(hashedPassword);        
        return repository.save(user);
    }
    
    @PutMapping("/users")
    public ResponseEntity<UserAccount> UpdateUserAccount(@Valid @RequestBody UserAccount user){
        
        UserAccount userAccount = repository.findByUserName(user.getUsername());
        
        userAccount.setFirstname(user.getFirstname());
        userAccount.setMidname(user.getMidname());
        userAccount.setLastname(user.getLastname());
        userAccount.setSecondlastname(user.getSecondlastname());
        userAccount.setUsername(user.getUsername());
        repository.save(userAccount);
        
        return ResponseEntity.ok(userAccount);
    }
    
    @DeleteMapping("/users")
    public Boolean DeleteUserAccount(@Valid @RequestBody UserAccount user){
        
        try{
            UserAccount userAccount = repository.findByUserName(user.getUsername());
            repository.delete(userAccount);
            
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
