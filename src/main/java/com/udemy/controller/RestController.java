package com.udemy.controller;

import com.udemy.model.ContactModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    
    @GetMapping("/checkrest")
    public ResponseEntity<ContactModel> checkRest() {
        ContactModel contactModel = new ContactModel(3, "Sasuke", "Uchiha", "7777", "Manizales");
        return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
    }
}
