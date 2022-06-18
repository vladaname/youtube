package com.example.youtube.controllers;

import com.example.youtube.dto.AkauntDto;
import com.example.youtube.dto.KorisnikDto;
import com.example.youtube.dto.VideoDto;
import com.example.youtube.model.Akaunt;
import com.example.youtube.model.Korisnik;
import com.example.youtube.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class KorisnikController {
    @Autowired
    KorisnikService korisnikService;

    @GetMapping("/login")
    public ModelAndView loginGET(){
        return new ModelAndView("login", "korisnikDto", new KorisnikDto());
    }

    @PostMapping("/login")
    public String loginPOST(Model model, @ModelAttribute("korisnikDto")KorisnikDto korisnikDto, HttpServletRequest request){
        Korisnik login = korisnikService.login(korisnikDto);
        if(login != null){
            request.getSession().setAttribute("korisnik", login);
            model.addAttribute("videoDto", new VideoDto());
            return "redirect:/listaSvihVidea";
        }
        else{
            return "login";
        }


    }
}
