/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.healthcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cgonzalez
 */
@RestController
@RequestMapping("/api")
public class TestController {
    
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World of healthcare!";
    }
}
