/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.response;

/**
 *
 * @author cgonzalez
 */
public class GenericResponse {
    
    private String message;
    private boolean success;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public GenericResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
    
    public GenericResponse(){
        
    }
}
