package com.example.youtube.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/test")
    public String testController(){
        return "test";
    }

    @GetMapping("/kontakt")
    public ModelAndView kontaktMapa(){
        return new ModelAndView("kontakt");

    }
}
