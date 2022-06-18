package com.example.youtube.service;

import com.example.youtube.dto.KorisnikDto;
import com.example.youtube.model.Korisnik;

public interface KorisnikService {
    Korisnik login(KorisnikDto korisnikDto);

    Korisnik findById(int idKorisnik);

    Korisnik loginRest(KorisnikDto korisnikDto);

    Korisnik findByToken(String token);
}
