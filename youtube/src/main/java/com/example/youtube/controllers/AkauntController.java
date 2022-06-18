package com.example.youtube.controllers;

import com.example.youtube.dto.AkauntDto;
import com.example.youtube.model.Korisnik;
import com.example.youtube.service.AkauntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AkauntController {

    @Autowired
    AkauntService akauntService;

    @GetMapping("/createAkaunt")
    public ModelAndView createAkauntGET(){
        return new ModelAndView("registracija", "akauntDto", new AkauntDto());
    }

    @PostMapping("/createAkaunt")
    public String createAkauntPOST(Model model, @ModelAttribute("akauntDto")AkauntDto akauntDto, HttpServletRequest request){
        System.out.println("Kontroler");
        boolean b = akauntService.registracija(akauntDto);
        if(b){
            return "login";
        }
        else{
            return "registracija";
        }
    }


}
