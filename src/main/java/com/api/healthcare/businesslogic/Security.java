/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.businesslogic;

import com.api.healthcare.request.LoginRequest;
import com.api.healthcare.components.PasswordHash;
import com.api.healthcare.controller.SecurityController;
import com.api.healthcare.model.UserAccount;
import com.api.healthcare.repository.UserRepository;
import com.api.healthcare.request.UpdatePasswordRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class Security /*extends SecurityController*/ {
   
    public static Boolean Login(UserRepository repository, LoginRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException{
        PasswordHash pbkdf2 = new PasswordHash();
        
        //look for the username in the db by using the username.        
        try{
            UserAccount user = new UserAccount();
            user = repository.findByUserName(request.getUsername());
        
            if(user.getUsername() != null){

                Boolean checkPassword = pbkdf2.validatePassword(request.getPassword(), user.getPassword());

                if(checkPassword){ return true; }
                else{ return false; }            
            }else { 
                return false; 
            }
        }catch(Exception ex){
            //set some error message.
            System.out.println(ex.getMessage());
            return false;
        }               
    }

    public static Boolean UpdatePassword(UserRepository repository, UpdatePasswordRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException{
        
        PasswordHash pbkdf2 = new PasswordHash();
        String password = repository.findPassword(request.getUsername());        
        
        if(password != null){
            //check current password.
            Boolean flag = pbkdf2.validatePassword(request.getPassword(), password); 
            
            if(flag){
                //check if the password isn't the same as the current password in the db.
                Boolean checkPassword = pbkdf2.validatePassword(request.getNewpassword(), password);

                if(checkPassword){
                    return false;
                }else{
                    UserAccount userAccount = repository.findByUserName(request.getUsername());

                    userAccount.setPassword(pbkdf2.createHash(request.getNewpassword()));
                    repository.save(userAccount);
                    return true;
                }
            }else{
                //password doesn't match.
                return false;
            }            
                        
        }else{
            return false;
        }
    }
}
