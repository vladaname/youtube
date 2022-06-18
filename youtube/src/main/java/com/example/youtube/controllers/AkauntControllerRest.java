package com.example.youtube.controllers;

import com.example.youtube.dto.AkauntDto;
import com.example.youtube.service.AkauntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AkauntControllerRest {
    @Autowired
    AkauntService akauntService;


@PostMapping("/createAcount")
    public String createAcount(@RequestBody AkauntDto akauntDto){

    boolean b = akauntService.registracija(akauntDto);
    if(b){
        return "Success registration";
    }
    else{
        return "Registration failure";
    }
}
}
