package com.example.youtube.controllers;

import com.example.youtube.dto.KorisnikDto;
import com.example.youtube.model.Korisnik;
import com.example.youtube.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KorisnikControllerRest {

    @Autowired
    KorisnikService korisnikService;

    @PostMapping("/loginRest")
    public String loginRest(@RequestBody KorisnikDto korisnikDto){
        Korisnik loginRest = korisnikService.loginRest(korisnikDto);
        if(loginRest != null){
            return loginRest.getToken();
        }
        return null;

    }
    @PostMapping("/test")
    public String testLogin(@RequestHeader("token")String token){
        Korisnik k = korisnikService.findByToken(token);
        if(k == null){
            return "Molimo vas ulogujte se!";
        }
        else{
            return "Ulogovani korisnik: " + k.getUsername();
        }
    }
}
